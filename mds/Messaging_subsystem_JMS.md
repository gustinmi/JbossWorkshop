# Messaging subsystem JMS

* Queues   producer places message in queue and consumer removes the message

* Topics publish subscribe; multiple publishers publish to topic, multiple consumers are subscribed to topic

## What we need to do

1. Define connection factories (durable or not; not for topics), topics, queues

2. configure features : security, persistence, journals

## HornetQ Terminology

Connectors: how to connect

Acceptors: what connection is accepted

Connection factory types: 
	* invm  : local
	* netty: over jvms

	<jms-queue name="testQueue">
	    <entry name="queue/test"/> <!-- for local -->
	    <entry name="java:jboss/exported/jms/queue/test"/> <!-- for netty -->
	</jms-queue>
