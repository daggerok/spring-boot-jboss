Spring Boot on JBoss
====================
1. download and unzip jboss-eap-6.4
2. $ git clone --depth=1 https://github.com/daggerok/spring-boot-jboss.git jboss-boot
3. $ cd jboss-boot && gradle build
4. $ cp build/libs/spring-boot-jboss-1.0.war.original ~/jboss-eap-6.4/standalone/deployments/spring-boot-jboss-1.0.war
5. $ ~/jboss-eap-6.4/bin/standalone.sh 
6. goto http://localhost:8080/spring-boot-jboss/
