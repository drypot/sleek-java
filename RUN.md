# How to Run

## MySQL

config/application-*.properties 파일을 참고해서 디비를 준비한다.

## Run

    $ bin/run-test

전체 테스트.

    $ bin/run-dev
    
dev 프로파일로 서버 실행.

## Spring profile

각 개발 환경에서 실행할 때 Spring Profile 을 지정해야 한다.

### IntelliJ / Application

1. Run/Debug Configurations Dialog
2. Spring Boot Configuration Section
3. Active Profile field: dev

### Maven

    $ mvn spring-boot:run -Dspring-boot.run.profiles=dev
    $ SPRING_PROFILES_ACTIVE=dev mvn spring-boot:run

<https://github.com/spring-projects/spring-boot/issues/1095>

### Gradle

    $ gradle bootRun -Dspring.profiles.active=dev

### Java

    $ java -jar -Dspring.profiles.active=dev xxx.jar
    
