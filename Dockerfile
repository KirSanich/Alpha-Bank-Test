FROM openjdk:17
ADD build/libs/Alpha-Bank-Test-0.0.1-SNAPSHOT.jar giphy.jar
ENTRYPOINT ["java","-jar","giphy.jar"]