# Keycloak Redis Event Publisher

Publish Keycloaks's admin events to Redis pub/sub broker to subscribe it from a Spring Boot project.

## Compile and install SPI
```shell
mvn clean package
cp target/keycloak-redis-event-listener.jar ${KEYCLOAK_DIR}/standalone/deployments/
```

