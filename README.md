## ☁️ 9oormthonUNIV_BE @ Hallym Univ.
> 구름톤 유니브 한림대 백엔드 기술 스터디
### 🧑‍💻 멤버
|                                                    Study Leader                                                    |                                                       Member                                                    |                                                       Member                                                    |                                                       Member                                                    |                                                       Member                                                    |
|:------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------:|
| [<img src="https://avatars.githubusercontent.com/bum0w0" width="100px;" alt="김진범"/>](https://github.com/bum0w0) | [<img src="https://avatars.githubusercontent.com/hskhsmm" width="100px;" alt="홍성민"/>](https://github.com/hskhsmm) | [<img src="https://avatars.githubusercontent.com/leetmdgus" width="100px;" alt="이승현"/>](https://github.com/leetmdgus) | [<img src="https://avatars.githubusercontent.com/BZzzzi" width="100px;" alt="김현진"/>](https://github.com/BZzzzi) | [<img src="https://avatars.githubusercontent.com/wldms-04" width="100px;" alt="최지은"/>](https://github.com/wldms-04) |
|                                                      **김진범**                                                   |                                                      **홍성민**                                                  |                                                      **이승현**                                                 |                                                      **김현진**                                                 |                                                      **최지은**                                                 |


### 🚀 프로젝트 기능 목표
#### 1. **Spring Security와 JWT**

- **Spring Security**를 사용하여 인증 및 인가 시스템 구축
- JWT를 이용한 토큰 기반 인증 시스템

#### 2. **카카오 로그인 API 연동**

- 카카오 로그인 API를 사용하여 소셜 로그인 기능 추가
- 카카오 API와의 연동을 통해 사용자 정보를 JWT 토큰과 함께 관리

#### 3. **다중 토큰 발급 및 Refresh Token 처리**

- **Redis**를 사용하여 **Refresh Token**을 안전하게 저장하고 관리
- **Access Token** 만료 시, **Refresh Token**을 이용하여 새로운 **Access Token**을 발급

### 📁 패키지 구조
```
com.example.projectname
│
├── config
│   └── SecurityConfig.java             // Spring Security 설정
│   └── JwtConfig.java                   // JWT 관련 설정
│
├── auth
│   ├── controller
│   │   └── AuthController.java          // 로그인, 토큰 재발급 등 API
│   ├── service
│   │   └── AuthService.java             // 인증/인가 로직
│   ├── dto
│   │   └── LoginRequestDto.java
│   │   └── TokenResponseDto.java
│   ├── jwt
│   │   └── JwtProvider.java             // JWT 토큰 생성/검증
│   │   └── JwtAuthenticationFilter.java
│   ├── kakao
│   │   └── KakaoLoginService.java       // 카카오 로그인 처리
│   │   └── KakaoUserInfo.java           // 카카오 사용자 정보 매핑
│
├── user
│   ├── entity
│   │   └── User.java                    // 사용자 Entity
│   ├── repository
│   │   └── UserRepository.java
│   ├── service
│   │   └── UserService.java             // 사용자 관련 비즈니스 로직
│
├── token
│   ├── entity
│   │   └── RefreshToken.java            // Refresh Token Entity
│   ├── repository
│   │   └── RefreshTokenRepository.java  // Redis 연동
│
└── common
    ├── exception
    │   └── CustomException.java
    │   └── ErrorCode.java
    │   └── GlobalExceptionHandler.java  // 전역 예외 처리
    ├── response
    │   └── ApiResponse.java              // 통일된 API 응답 포맷
```
