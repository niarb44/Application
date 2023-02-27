FROM openjdk:19
ADD out/artifacts/Aplikacja_jar/Aplikacja.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "*jar"]

