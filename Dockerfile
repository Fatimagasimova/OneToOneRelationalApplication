FROM amazoncorretto:21-alpine
WORKDIR /app
COPY build/libs/*-SNAPSHOT.jar app.jar
CMD ["java","-jar", "app.jar"]