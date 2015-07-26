Spring Boot on JBoss
====================
1. download and unzip jboss-eap-6.4 for example into ~/jboss-eap-6.4/
2. folow these steps:
```shell
$ git clone --depth=1 https://github.com/daggerok/spring-boot-jboss.git jboss-boot
$ cd jboss-boot && gradle build
$ cp build/libs/spring-boot-jboss-1.0.war.original ~/jboss-eap-6.4/standalone/deployments/spring-boot-jboss-1.0.war
$ ~/jboss-eap-6.4/bin/standalone.sh 
```
3. goto http://localhost:8080/spring-boot-jboss/
====================
spring-boot also should work as well:
```shell
$ git clone --depth=1 https://github.com/daggerok/spring-boot-jboss.git jboss-boot
$ cd jboss-boot
$ gradle build
$ gradle bootRun
```
goto http://localhost:8080/
