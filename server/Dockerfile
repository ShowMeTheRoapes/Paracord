FROM openjdk:8 as builder

COPY . /server
WORKDIR /server

RUN chmod 777 mvnw

# Running from Windows will add a windows EOF. Need to change it to linux.
RUN /bin/sed -i 's/\r//' mvnw

# Build Spring project
RUN ./mvnw install

FROM openjdk:8
WORKDIR /app
COPY --from=builder /server/target/*.jar /app/paracord.jar
ENTRYPOINT ["java","-jar","paracord.jar"]
