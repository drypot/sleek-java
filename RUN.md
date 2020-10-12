# How to Run

## MySQL

config/application-*.properties 파일을 참고해서 디비를 준비한다.

## Run

    ...

추후 추가.

## Spring profile

각 개발 환경에서 실행할 때 Spring Profile 을 지정해야 한다.

### IntelliJ / Application

1. Run/Debug Configurations Dialog
2. Spring Boot Configuration Section
3. Active Profile field: dev

### IntelliJ / JUnit

    -Dspring.profiles.active=test

JUnit 에 위 인자를 전달해야 한다.
Run/Debug 다이얼로그의 JUnit Template 을 수정한다.

내용이 더 필요하면 'IntelliJ Changing Run/Debug Configuration Defaults' 로 구글 검색.

### Maven

    $ mvn spring-boot:run -Dspring-boot.run.profiles=dev
    $ SPRING_PROFILES_ACTIVE=dev mvn spring-boot:run

<https://github.com/spring-projects/spring-boot/issues/1095>

### Gradle

    $ gradle bootRun -Dspring.profiles.active=dev

### Java

    $ java -jar -Dspring.profiles.active=dev xxx.jar
    
