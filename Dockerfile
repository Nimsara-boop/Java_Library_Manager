FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY src/main/java/librarycentre_package/*.java ./

RUN javac *.java

CMD ["java", "WestminsterLibraryManager"]
