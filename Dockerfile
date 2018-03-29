FROM daggerok/jboss:eap-7.1
RUN echo "JAVA_OPTS=\"\$JAVA_OPTS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 \"" >> ${JBOSS_HOME}/bin/standalone.conf
EXPOSE 5005
HEALTHCHECK --timeout=2s --retries=22 \
        CMD wget -q --spider http://127.0.0.1:8080/spring-boot-jboss/actuator/health \
         || exit 1
ADD ./build/libs/*.war ${JBOSS_HOME}/standalone/deployments/
