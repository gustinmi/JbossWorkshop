# Jboss Administration 1 Datasources

JDBC Resource pool is "datasource".

## Datasources old way

In old jboss, you could add -ds.xml dile to deployment directory, and datasource was created. But you cannot manage it via management tools. Datasources can also be defined within Java code with annotations. The jar file is placed inside servers lib folder.

Example of *-ds.xml file

    <?xml version="1.0" encoding="UTF-8"?>
	<datasources>
	   <datasource>
	      <jndi-name>myDS</jndi-name>
	      <connection-url>jdbc:hsqldb:hsql://localhost:1701</connection-url>     
	      <driver-class>org.hsqldb.jdbcDriver</driver-class>
	      <user-name>sa</user-name>
	      <password></password>
	      <min-pool-size>5</min-pool-size>
	      <max-pool-size>20</max-pool-size>
	      <idle-timeout-minutes>0</idle-timeout-minutes>
	      <track-statements/>
          
	      <security-domain>HsqlDbRealm</security-domain>
	      <prepared-statement-cache-size>32</prepared-statement-cache-size>
	   </datasource>
	</datasources>

## Datasources new way

Datasource needs driver jar. You deploy it as jar or as module.

### Deploy as jar file

1. If driver is not JDBC4 compliant, you need to add full qualified driver name to META-INF/service/java.Sql.Driver file (create it)

2. If it is JDBC4 compliant, simply deploy it.

### Deploy as module

1. Create module folder nad module.xml. Add jar file.

2. Add driver to section drivers inside datasources subsystem. Driver-class is optional, in case there are multiple within jar file.

        <drivers>
            <driver name="mysql" module="com.mysql.jdbc">
                <driver-class>
                    com.mysql.jdbc.Driver
                </driver-class>
            </driver>
        </drivers>


## Tasks

1. Create Datasource with deploying jar. Configure validation query, max and min pool size.

2. Create module for mysql driver. Create datasource with driver in module.
