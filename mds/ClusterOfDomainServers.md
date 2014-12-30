Setup cluster of domain servers Quickstart checklist
=========================================

Setup master and slave domain
---------------------------------

1. Prepare master and slave jboss eap distibutions

2. On single machine setup, create additional ip alias

3. Modify datagram socket settings

	sudo sysctl -w net.core.wmem_max=640000
	sudo sysctl -w net.core.rmem_max=20000
	

4. MASTER - change the management, public, unsecure interfaces in host.xml to public IP address

	<interfaces/management/inet-address/value="${jboss.bind.address.management:192.168.11.135}">
    
5. SLAVE - change host name to slave in host.xml

	<host name="slave"

6. SLAVE - change interfaces (step3) for slave to slave's IP address

7. Setup authentication between master and slave
	
	MASTER

		1. add user "slave" to master security realm, (add.user.sh, option remote user) <secret value="cGEkJHdvcmQxLg==" />

		2. disable jms security <security-enabled>false</security-enabled> on all profiles

	SLAVE 

		modify management realm on host.xml. add server identity to it. 

Session replication
---------------------------------

8. Open management console (on master host)

9. Enable full-ha group

10. deploy cluster-demo, with <distributable/> in web.xml

11. 


Load balancing of standalone nodes
-------------------------------------
1. Add  <property name="jvmRoute" value="......"/> to system properties in standalone.xml

NOTE: If you have domain mode, service org.jboss.modcluster.ModClusterService should create it







