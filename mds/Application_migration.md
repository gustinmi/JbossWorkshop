Application migration
================================================

* class-path and modules

Migrate the old dependencies to modules. Decide what forms a module and create it. Add reference to module to jar files,
or jboss-deployment-structure.xml in war.

mydeployment.jar/META-INF/MANIFEST.MF

	Dependencies: my.module.name, my.moduleX.other export


* JPA (hibernate or JPA, 2nd level cache)
	
	 <property name="hibernate.cache.use_second_level_cache">true</property>

* security  (all security goes to configuration files)

* messaging (No more JBoss Messaging)

* resources (all resources are configured in config files)

* jndi lookups (standardanization)

	* no more unqualified lookups (jdbc/MyDs0). Only fully qualified java:jboss/MyDs0

Other
----------------------
* migration of web.xml version number

* jboss-deployment-structure.xml
