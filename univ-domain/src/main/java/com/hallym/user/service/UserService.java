package com.hallym.user.service;

import com.hallym.user.entity.User;
import com.hallym.user.model.Provider;
import com.hallym.user.model.Role;
import com.hallym.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    public boolean isEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    @Transactional
    public User registerUser(String email, String password, String nickname) {
        if (isEmailExists(email)) {
            throw new IllegalArgumentException("이미 사용중인 이메일입니다.");
        }

        User user = User.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .provider(Provider.LOCAL)
                .role(Role.USER)
                .build();

        return userRepository.save(user);
    }

    @Transactional
    public User getOrCreateSocialUser(String socialId, Provider provider, String email, String nickname) {
        Optional<User> userOptional = userRepository.findBySocialIdAndProvider(socialId, provider);

        if (userOptional.isPresent()) {
            return userOptional.get();
        }

        User user = User.builder()
                .socialId(socialId)
                .provider(provider)
                .email(email)
                .nickname(nickname)
                .password("")
                .role(Role.USER)
                .build();

        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

}