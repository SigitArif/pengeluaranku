FROM openjdk:8-jdk-alpine

COPY target/pengeluaranku-0.0.1-SNAPSHOT.jar /app/pengeluaranku.jar

CMD ["java", "-jar", "/app/pengeluaranku.jar"]
