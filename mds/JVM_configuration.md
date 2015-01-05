JVM Configuration
====================================

For standalone mode, the process that starts jboss configures JVM (standalone.config)
In domain mode, JVM settings are defined in host configuration

Parameters for JVM

* Xmx

* Xms

* -XX:MaxPermSize

* -XX:NewRation

* -XX:NewSize

Others
----------------------
stack-size  (128K if you have multiple thread containers 1MB default)
gc-interval
gc-algorithm


Example of JVM settings for standalone.xml
-------------------------

./standalone.sh 

"-Dconfig.path=C:/Program Files (x86)/Java/jboss-eap-6.1/modules/my/foo/configuration/main"       	#extra modules
"-Dhttp.proxyHost=proxy.gov.si"																		#jvm params
"-Dhttp.proxyPort=80" 

