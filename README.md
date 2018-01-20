Spring Boot on JBoss container [![build](https://travis-ci.org/daggerok/spring-boot-jboss.svg?branch=master)](https://travis-ci.org/daggerok/spring-boot-jboss)
==============================

NOTE: to avoid any build errors use gradle wrapper: `bash gradlew clean build`

1. download and unzip jboss-eap-6.4 for example into ~/jboss-eap-6.4/
2. folow these steps:
```shell
$ git clone --depth=1 https://github.com/daggerok/spring-boot-jboss.git jboss-boot
$ cd jboss-boot
$ ./gradlew build
$ cp build/libs/spring-boot-jboss-1.0.war.original ~/jboss-eap-6.4/standalone/deployments/spring-boot-jboss-1.0.war
$ ~/jboss-eap-6.4/bin/standalone.sh 
```
3. open http://localhost:8080/spring-boot-jboss/

Spring Boot Embedded container
==============================
```shell
$ git clone --depth=1 https://github.com/daggerok/spring-boot-jboss.git jboss-boot
$ cd jboss-boot
$ ./gradlew build
$ ./gradlew bootRun
```
open http://localhost:8080/

Docker / Compose
================
```bash
docker-compose down -v; ./gradlew; docker-compose up --build --force-recreate --remove-orphans
open http://127.0.0.1:8080/spring-boot-jboss/
```
