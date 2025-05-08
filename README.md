## ☁️ 9oormthonUNIV_BE @ Hallym Univ.
> 구름톤 유니브 한림대 백엔드 기술 스터디
### 🧑‍💻 멤버
|                                                    Study Leader                                                    |                                                       Member                                                    |                                                       Member                                                    |                                                       Member                                                    |                                                       Member                                                    |
|:------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------:|
| [<img src="https://avatars.githubusercontent.com/bum0w0" width="100px;" alt="김진범"/>](https://github.com/bum0w0) | [<img src="https://avatars.githubusercontent.com/hskhsmm" width="100px;" alt="홍성민"/>](https://github.com/hskhsmm) | [<img src="https://avatars.githubusercontent.com/leetmdgus" width="100px;" alt="이승현"/>](https://github.com/leetmdgus) | [<img src="https://avatars.githubusercontent.com/BZzzzi" width="100px;" alt="김현진"/>](https://github.com/BZzzzi) | [<img src="https://avatars.githubusercontent.com/wldms-04" width="100px;" alt="최지은"/>](https://github.com/wldms-04) |
|                                                      **김진범**                                                   |                                                      **홍성민**                                                  |                                                      **이승현**                                                 |                                                      **김현진**                                                 |                                                      **최지은**                                                 |
### 🚀 프로젝트 개요
멀티 모듈 구조를 기반으로, 팀원이 각 기능을 분담하여 개발하는 실습형 백엔드 프로젝트입니다.  
매주 **목요일 오후 8시 오프라인 스터디**를 통해 **PR 리뷰**, **기능 구현 설명**, **기술 세미나**를 진행합니다.


### 📚 주요 기능 목표

| 기능 항목             | 목표                                                         |
|-----------------------|--------------------------------------------------------------|
| WebSocket             | 실시간 메시지 전송, 연결 관리 등                            |
| 로그인                | Spring Security + JWT 기반 인증/인가                        |
| 알림 시스템           | 사용자 알림 전송 및 저장 (WebSocket, 이벤트 기반)           |
| CRUD 구현             | 게시글, 유저 등 주요 리소스에 대한 생성/조회/수정/삭제     |
| 파일 업로드           | 이미지/문서 업로드, 미디어 파일 저장                        |
| 동영상 처리           | 업로드, 썸네일 생성 등 (선택 구현)                          |
| Redis 활용            | Refresh Token 캐싱, 성능 개선 목적의 데이터 저장            |
| OAuth2 로그인         | 카카오, 구글 등 소셜 로그인 연동                           |
| 공공데이터 API 연동   | 외부 데이터 활용을 통한 기능 확장                           |

---

### 🔑 Commit Convention

| 커밋 태그(Tag)       | 변경 사항 설명 예시                             |
|----------------------|-----------------------------------------------|
| Feat                 | 새로운 기능 추가                                |
| Fix                  | 버그 수정                                      |
| HOTFIX               | 치명적인 긴급 수정                              |
| Build                | 빌드 설정, 의존성 관련 변경                     |
| Design               | UI, CSS 등 디자인 요소 변경                     |
| Docs                 | 문서 추가, 수정, 삭제 등                        |
| Test                 | 테스트 코드 추가 및 수정                        |
| Refactor             | 리팩토링 (구조 개선)            |
| Chore                | 자잘한 설정 변경, 코드 포맷팅 등               |
| Rename               | 파일 또는 폴더의 이름 변경                      |
| Remove               | 불필요한 파일 또는 폴더 삭제                    |


### 🌿 Branch Convention

**Branch Structure**
- `main`: 배포 브랜치
- `develop`: 통합 개발 브랜치
- `feature/`: 기능 개발 및 이슈 해결 브랜치

**Branch Flow**
 ```
Main Branch
  ▲
  └── Develop Branch ── 테스트 완료 후 병합 
                              ▲
                              └── Feature Branch ── 작업 완료 후 병합 
                                          └── 새로운 기능 추가

 ```
---

### 📁 패키지 구조
```
backend_study/
├── settings.gradle
├── build.gradle

├── domain/                  # 핵심 도메인 (User, Content 등)
│   ├── user/                # 사용자 엔티티, 리포지토리
│   └── content/             # 콘텐츠 관련 도메인

├── oauth/                   # OAuth2 소셜 로그인
│   ├── config/              # OAuth 설정
│   ├── dto/                 # 요청/응답 DTO
│   ├── service/             # 로그인 처리 로직
│   └── userinfo/            # Kakao 등 provider별 유저정보

├── events/                  # 실시간 기능, 알림 시스템
│   ├── websocket/           # WebSocket 설정 및 핸들러
│   ├── notification/        # 알림 메시지 처리
│   └── listener/            # 이벤트 리스너

├── cache/                   # Redis 기반 토큰/데이터 캐싱
│   ├── config/              # Redis 설정#
│   └── repository/          # 캐시 데이터 저장소

├── external/                # 외부 API 연동
│   ├── s3/                  # AWS S3 연동
│   └── api/                 # 공공데이터 API 등

├── security/                # 인증/인가 및 JWT 처리
│   ├── jwt/                 # JWT 생성, 검증 유틸
│   ├── config/              # Spring Security 설정
│   └── exception/           # 인증 관련 예외 처리

├── media/                   # 파일 업로드 및 동영상 처리
│   ├── service/             # 업로드/변환 로직
│   └── dto/                 # 파일 관련 DTO

└── api/                     # 컨트롤러와 실제 요청 진입점
    ├── controller/          # REST API 엔드포인트
    ├── service/             # 서비스 호출 조합
    └── dto/                 # API 요청/응답 DTO
```
---
