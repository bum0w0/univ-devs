package com.hallym.user.controller;

import com.hallym.user.model.Role;
import com.hallym.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // 회원가입 요청 처리 (POST)
    @PostMapping("/api/register")
    public String register(@RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String nickname,
                           Model model) {
        try {
            userService.registerUser(email, password, nickname);
            model.addAttribute("nickname", nickname);
            return "welcome";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "register";  // 실패 시 다시 회원가입 폼으로
        }
    }

    // 로그인 요청 처리 (POST)
    @PostMapping("/api/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {
        return userService.findByEmail(email)
                .filter(user -> user.getPassword().equals(password))
                .map(user -> {
                    session.setAttribute("user", user); // 로그인 사용자 세션 저장

                    if (user.getRole() == Role.ADMIN) {
                        return "redirect:/admin/dashboard";  // 관리자용 대시보드
                    } else {
                        return "redirect:/user/dashboard";   // 일반 유저용 대시보드
                    }
                })
                .orElseGet(() -> {
                    model.addAttribute("error", "이메일 또는 비밀번호가 일치하지 않습니다.");
                    return "login";
                });
    }

    @GetMapping("/user/dashboard")
    public String userDashboard() {
        return "study/user-dashboard";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "study/admin-dashboard";
    }

    @PostMapping("/logout")
    public String logoutPost(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/welcome")
    public String welcomePage(Model model,
                              @SessionAttribute(value = "user", required = false) Object sessionUser,
                              @AuthenticationPrincipal org.springframework.security.oauth2.core.user.OAuth2User oauthUser) {

        if (sessionUser != null) {
            // 일반 로그인 사용자 (세션 기반)
            model.addAttribute("userType", "session");
            model.addAttribute("email", ((com.hallym.user.entity.User) sessionUser).getEmail());
            model.addAttribute("nickname", ((com.hallym.user.entity.User) sessionUser).getNickname());
        } else if (oauthUser != null) {
            // 소셜 로그인 사용자 (Spring Security 기반)
            model.addAttribute("userType", "oauth");
            model.addAttribute("email", oauthUser.getAttribute("email"));
            model.addAttribute("nickname", oauthUser.getAttribute("name"));
        } else {
            // 로그인 안 된 상태 → 로그인 페이지로 리다이렉트
            return "redirect:/login";
        }

        return "welcome"; // templates/welcome.html 렌더링
    }

}