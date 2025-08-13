FROM eclipse-temurin:24-jdk-alpine AS builder
RUN mkdir -p /build
WORKDIR /build
COPY . /build/
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:24-jre-alpine
RUN mkdir -p /app
WORKDIR /app
COPY --from=builder /build/target/*.jar /app/app.jar
EXPOSE 8080
CMD [ "java", "-jar", "/app/app.jar" ]