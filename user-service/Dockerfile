# Use a imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Configure o diretório de trabalho dentro do contêiner
WORKDIR /app

VOLUME /tmp

# Copie o arquivo JAR gerado para o contêiner
COPY target/user-service-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta que a aplicação vai usar
EXPOSE 8082

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
