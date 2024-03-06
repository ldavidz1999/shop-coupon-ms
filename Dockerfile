FROM gradle:7.3.0-jdk11 AS build
WORKDIR /app
COPY . /app
RUN gradle clean build
FROM openjdk:17-alpine
EXPOSE 8080
COPY --from=build /app/build/libs/shop-coupon-ms-0.0.1-SNAPSHOT.jar /app/shop-coupon-ms-0.0.1-SNAPSHOT.jar
LABEL authors="User"
ENTRYPOINT ["java", "-jar", "/app/shop-coupon-ms-0.0.1-SNAPSHOT.jar"]