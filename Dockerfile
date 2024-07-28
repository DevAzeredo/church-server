# Usar uma imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o arquivo JAR para o diretório de trabalho
COPY target/seu-app.jar /app/seu-app.jar

# Expor a porta que o aplicativo vai usar
EXPOSE 

# Comando para executar o JAR
CMD ["java", "-jar", "/app/seu-app.jar"]

