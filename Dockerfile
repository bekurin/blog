# JDK 17을 사용하는 base 이미지를 지정
FROM openjdk:17-jdk-slim

# 컨테이너 내에서 애플리케이션을 실행할 디렉토리 생성
WORKDIR /app

COPY build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
