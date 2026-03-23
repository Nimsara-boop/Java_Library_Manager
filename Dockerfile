FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy entire package folder (not just files)
COPY src/main/java/librarycentre_package /app/librarycentre_package

# Compile all classes
RUN javac librarycentre_package/*.java

# Run the class that contains main()
CMD ["java", "-cp", "/app", "librarycentre_package.LibraryCentre_MockLabBasedPractical"]
