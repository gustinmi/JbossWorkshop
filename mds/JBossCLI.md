JBoss CLI
=======================================

Navigation on resources
-------------------

Triggered with / 

cd, cd /, cd ..
cd subsystem/datasources

Which resources jboss has? Type cd and press TAB
Getting help?   type operation or command and add --help

Operations 
-------------------

Triggered with : 
Parameters specified inside brackets ()


Commands
-------------------

:take-snapshot    (of configuration)
batch     (enter batch mode, all commands are executed as atomic unit)


Example session
-------------------

1. connect     (connect to localhost:9999)

2. cd subsystem=deployment-scanner/scanner=default  (navigate to resource)    

3. :read-resource  (read whole resource, like datasource, logging handler)

4. :read-attribute(name=scan-interval)      (read specific attribute)

5. :write-attribute(name=scan-interval,value=3000)   (writes specific attribute)

6. cd subsystem/web, :read-resource(recursive=true)       (rekurzivno branje vsega)

	cd connector=http, :read-resource(include-runtime=true)      (vključi runtime statistike)

7. /subsystem=web/connector=ajp:add(socket-binding=ajp, protocol="AJP/1.3", enabled=true)

Example script
--------------------

./jboss-cli.sh --connect --file=myscript.cli

	batch
	deploy /home/jboss/code/JbossWorkshopMaster/cluster-demo/target/cluster-demo.war --force
	run-batch



