FROM openjdk:17-alpine
WORKDIR /app
CMD ["./gradlew", "clean", "build"]
COPY --from=build /app/build/libs/shop-coupon-ms-0.0.1-SNAPSHOT.jar /app/shop-coupon-ms-0.0.1-SNAPSHOT.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/shop-coupon-ms-0.0.1-SNAPSHOT.jar"]