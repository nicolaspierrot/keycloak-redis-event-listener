# Keycloak Redis Event Publisher

Publish Keycloaks's admin events to Redis pub/sub broker to subscribe it from a Spring Boot project.

## Compile and install SPI
```shell
mvn clean package
cp target/keycloak-redis-event-listener.jar ${KEYCLOAK_DIR}/standalone/deployments/
```

## Configure
Add xml configuration to ${KEYCLOAK_DIR}/standalone/configuration/standalone.xml

```xml
<subsystem xmlns="urn:jboss:domain:keycloak-server:1.1">
[...]
<spi name="eventsListener">
    <provider name="redis-event-publisher" enabled="true">
        <properties>
            <property name="serverType" value="redis"/>
            <property name="serverHost" value="localhost"/>
            <property name="serverPort" value="6379"/>
        </properties>
    </provider>
</spi>
[...]
</subsystem>

```
