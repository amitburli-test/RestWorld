Directory structure:
└── amitburli-test-restworld/
    ├── pom.xml
    ├── Suite.xml
    ├── reports/
    │   └── myreprot1.html
    └── src/
        ├── main/
        │   └── java/
        │       └── org/
        │           └── example/
        │               └── Main.java
        └── test/
            ├── java/
            │   ├── base/
            │   │   ├── AuthService.java
            │   │   └── BaseService.java
            │   ├── filters/
            │   │   └── LoggingFilters.java
            │   ├── listeners/
            │   │   └── TestListeners.java
            │   ├── model/
            │   │   ├── request/
            │   │   │   ├── LoginRequest.java
            │   │   │   └── RegisterRequest.java
            │   │   └── response/
            │   │       ├── LoginResponse.java
            │   │       └── UserDetails.java
            │   └── testcases/
            │       ├── FetchMeApi.java
            │       ├── LoginApi.java
            │       └── RegisterApi.java
            └── resources/
                └── log4j2.xml
