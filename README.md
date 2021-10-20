# Echo IP 👀

A tiny web service for looking up the client's public IP address.

Written in Java 11 & Javalin microframework.

## Building JAR

```shell
./gradlew build
```

## Running the service

```shell
java -jar build/libs/echo-ip-0.1.jar
```

## Docker

```shell
docker build -t akrisanov/echo-ip:0.1 .
docker run -p 3001:3001 akrisanov/echo-ip:0.1
```

---

© Andrey Krisanov, 2021