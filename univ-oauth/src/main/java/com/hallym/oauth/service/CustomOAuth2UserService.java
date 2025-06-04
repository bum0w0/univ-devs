package com.hallym.oauth.service;

import com.hallym.user.entity.User;
import com.hallym.user.model.Provider;
import com.hallym.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserService userService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest request) throws OAuth2AuthenticationException {
        OAuth2User oauthUser = super.loadUser(request);
        String providerName = request.getClientRegistration().getRegistrationId();
        OAuth2UserInfo userInfo = extractOAuth2UserInfo(providerName, oauthUser.getAttributes());

        User user = userService.getOrCreateSocialUser(
                userInfo.getId(),
                Provider.valueOf(providerName.toUpperCase()),
                userInfo.getEmail(),
                userInfo.getNickname()
        );

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(user.getRole().name())),
                oauthUser.getAttributes(),
                "id"
        );
    }

    private OAuth2UserInfo extractOAuth2UserInfo(String provider, Map<String, Object> attributes) {
        return switch (provider) {
            case "kakao" -> new KakaoOAuth2UserInfo(attributes);
            case "naver" -> new NaverOAuth2UserInfo(attributes);
            case "google" -> new GoogleOAuth2UserInfo(attributes);
            default -> throw new IllegalArgumentException("지원하지 않는 OAuth 제공자입니다.");
        };
    }
}