Spring Boot on JBoss container [![build](https://travis-ci.org/daggerok/spring-boot-jboss.svg?branch=master)](https://travis-ci.org/daggerok/spring-boot-jboss)
==============================

testing next stack:

. spring-boot 1.5.10.RELEASE
. gradle 4.6
. java 7 (supported only with gradle version < 5.0)

NOTE: to avoid any build errors use gradle wrapper: `bash gradlew clean build`

Spring Boot Embedded container
==============================

```bash
git clone --depth=1 https://github.com/daggerok/spring-boot-jboss.git
cd spring-boot-jboss/
bash ./gradlew build
bash ./gradlew bootRun
open http://localhost:8080/
```

Docker / Compose
================

```bash
docker-compose down -v; ./gradlew; docker-compose up --build --force-recreate --remove-orphans
open http://127.0.0.1:8080/spring-boot-jboss/
```

Usage without Docker / Compose
==============================

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

links:

* [Automatic Property Expansion Using Gradle](https://docs.spring.io/spring-boot/docs/current/reference/html/howto-properties-and-configuration.html)
* [Generating your own meta-data using the annotation processor](https://docs.spring.io/spring-boot/docs/1.5.10.RELEASE/reference/html/configuration-metadata.html#configuration-metadata-annotation-processor)
