# ForumHub-Java-Spring

forum-api
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── forum
│   │   │           └── forumapi
│   │   │               ├── config
│   │   │               │   ├── JwtConfig.java
│   │   │               │   ├── JwtRequestFilter.java
│   │   │               │   └── SecurityConfig.java
│   │   │               ├── controller
│   │   │               │   └── TopicController.java
│   │   │               ├── exception
│   │   │               │   └── GlobalExceptionHandler.java
│   │   │               ├── model
│   │   │               │   └── Topic.java
│   │   │               ├── repository
│   │   │               │   └── TopicRepository.java
│   │   │               ├── service
│   │   │               │   ├── TopicService.java
│   │   │               │   └── impl
│   │   │               │       └── TopicServiceImpl.java
│   │   │               └── util
│   │   │                   └── JwtTokenUtil.java
│   │   └── resources
│   │       ├── application.properties
│   │       ├── data.sql
│   │       ├── static
│   │       └── templates
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── forumapi
│                       ├── controller
│                       │   └── TopicControllerTest.java
│                       └── service
│                           └── TopicServiceTest.java
└── pom.xml
