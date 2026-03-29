FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN javac -version

# If mvnw exists use it, else use mvn
RUN if [ -f mvnw ]; then chmod +x mvnw && ./mvnw clean package -DskipTests; else apt-get update && apt-get install -y maven && mvn clean package -DskipTests; fi

EXPOSE 8080

CMD ["sh", "-c", "java -jar target/*.jar"]
