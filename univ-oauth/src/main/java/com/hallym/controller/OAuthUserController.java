package com.hallym.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class OAuthUserController {

    @GetMapping("/oauth/success")
    public String oauthSuccess(@AuthenticationPrincipal OAuth2User oauthUser, Model model) {
        String nickname = oauthUser.getAttribute("nickname");
        model.addAttribute("nickname", nickname);
        return "welcome";
    }
}