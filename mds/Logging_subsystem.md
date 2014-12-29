# Logging subsystem

# JBOSS 6 EAP logging

Logging is handled in subsystem. This goes for application server itself, and for applications also.

## Logging subsystem

* formatter (how its logged)

* handlers  (where (category/java package) and how (level) event is logged)

* loggers (divides events in categories)

	* si.gustinmi is parent to si.gustinmi.data (this is child). If logger is defined for parent, it's also for child. You can disable cascade with:

		<logger category="foo.bar" use-parent-handlers="false">

* root logger (top of hierarchies)

Application code issue logging on Logger object. Logger passes log record to handler for publication. Filter is applied on both.
Handler may use formatter. 

## Appenders

* console logger

* periodic rotating file ( rotates after time period ). Period must be in SimpleDateTimeFormat (java)

	suffix value .yyyy-MM-dd   roate every day at midnight
	suffix value .yyyy-MM-dd-HH   every hour

* size rotating handler

	<rotate-size value="500k" />

* asynchronous handler (composite logger, wraps 1st level loggers, ie. FILE). Use it if your application has intensive IO bound operations. If your application is CPU intensive, you wil not profit from it.

	<async-handler name="ASYNC">
	    <level name="INFO"/>
	    <queue-length value="1024"/>
	    <overflow-action value="block"/>   <!-- block|discard -->
	    <subhandlers>
	        <handler name="FILE"/>
	    </subhandlers>
	</async-handler>


## Available logging options

* JBoss Logging - included with JBoss Enterprise Application Platform 6

* Apache Commons Logging - http://commons.apache.org/logging/

* Simple Logging Facade for Java (SLF4J) - http://www.slf4j.org/

* Apache log4j - http://logging.apache.org/log4j/1.2/

* Java SE Logging (java.util.logging) - http://download.oracle.com/javase/6/docs/api/java/util/logging/package-summary.html

## Boot logging

Configured with file logging.properties inside standalone directory.

JBoss Log Manager does not pick up your logging configuration and your own logging JARs will work as normal.

	/standalone.sh -Dorg.jboss.as.logging.per-deployment=false

## What to do

1. Use jboss logging. Application developers must provide you with a list of appenders. Optionally you can configure root logger, which will intercept all the logging messages. 

2. Use logging library that enables per-application logging. In this way, application can define it's very own logging appenders etc.

## Per application logging

Create logging.properties file inside root classpath. Define only appenders.


	loggers=si.gustinmi
	logger.level=INFO
	logger.gustinmi.level=INFO
