FROM openjdk:8
EXPOSE 8761
ADD target/product.jar product.jar
ENTRYPOINT ["java","-jar","/product.jar"] 