# Java EE anti-patterns and good practices

Below is a list of general recomendations for Java EE applications. 

## Dev tools, code, architecture

1. Do not generating code generators and various other development helper tools to early. First implement 5 user stories, then observe reocurring patterns and only then create helper tools.

1. Only automate what could be automated out of the box. Better to do one or two extra steps in your build script then to have fency deploy scripts, that you need to maintain over time.

1. Do not underestimate the effect of well written plain java code / pojos (java 1-4 through 1.6). Take advantage of inner classes, enums, constants, serialization, multithreading, final keyword. Revisit forgotten  java internals:
    * inner classes
    * inner interfaces
    * static 
    * final
    * enums and switch case
    * generics and wildcards

1. Rethink your rules. Do not take them absolutely, but rethink their context.  There are lots of rules, that we should rethink and revisit. For example, rule : Split long code in more files, if lines exceed 100. This however should not be true for boilerplate code. You can have 1000 lines of boilerplate code if it does not change too much. Better 2000 lines of boilerplate code, then 20 subclasses with 100 lines each.)

1. Do not over engineer environments. Development machines (test, pre production, staging) means resources, time spent in configuration.

1. How to do “your framework”. 
    * identify your use cases (think of problem first)
    * develop a clean prototype (that will be thrown away)
    * detect reoccuring patterns
    * extract minimal “core” or “micro framework”

1. Do not ever compromise your code on premesis of unit test coverage. Do not subclass classes jut for make base classes unit-tested. Unit test should test the know-how (the what) of clases. You cannot test functionality or even gui with unit test. Said that, the JSF code is much less unit-testable then JSP code. 

1. Javadoc is suspicious. Use log statements as comments, use good names, etc. Maven for building site documentation. Reject all external tools that need extra maintenance and add to complexity. Study design patterns, to give your component a correct name (Proxy, Dispatcher, Sanatizer, Factory, Observer, Vistitor, Client, Server, Listener, FIlter, AppInit, onStop, onPreOpen). Make names describe what function/object do, not how they do it.  Do not invent your names unless needed. 

1. Use well knows libraries only. Check if your application servlet already support librarires in first place, before bringing your own.

1. Modularity of system arhitecure
Make every component / module /service do what it does best. Do not burden the application server with serving static resource, put that to apache. Do not process SSL on app server, before it pass apache SSL validation. (authenticate on apache, authorize on jboss, tomcat). [Modularity](http://cdn.dzone.com/sites/all/files/refcardz/rc166-010d-ModularityPatterns_0.pdf)

1. Let the packaging for production be completely different then the one for development. The development profile needs to be effective, fast, clean, easy to change. Production deployment could include more packaging.

1. Think about polyglot solutiuon. Combine php and java if you have the use case. Sometimes php can handle something in 2 seconds in 2 lines, where as java would need 10 seconds and 1000 lines of code. Thing about authentication mechanism and passing the session details between them. Do not insist on one language if you hit the problem that is best solved in other languages.

1. Use common free software for documentation sites, support desks, bugtracking, project management.

1. Do not never/ever develop your own build programs etc.. You will again endup with developing nonfocused stuff. Also, it is very likely that others will use it’s own tools anyway.

1. Development style and practices are like a art. If you have to force it, it’s probably shit.

## Database

1. Use datasources (JDBC resource pools) for database connectivity. Defines datasource always on application server, beacuse you can monitor them easily.

1. Use prepared statements only (SQL injection attack, performance, cache).
[Prepared statements](http://www.theserverside.com/news/1365244/Why-Prepared-Statements-are-important-and-how-to-use-them-properly)

## Container services and classes

1. All classes that run in container services must be thread save (servlets, beans, web services, etc). First line of defense is finally variable.

1. Be careful on overriding default classes. Example is servlet.init method. If you forgot one line (super.init), then all servlets becomes unusable. Unnecessary abstractions and class hierarchies are hard to maintain. Some goes for helper functions. Let’s first have 10 repeating pieces of code, then carefully think to create some common helpers.

1. Do not forget good old java singletons in favor of EJBs. EJB run in container and consume resources. Having EJBs for string calculation is overhead, overkill and completely unnecessary. Be aware that EJB container is required even for things such as unittesting. Remote EJBs are fine, but do not forget that they neeed EJB container to run. If you need to exchange messages, use websockets if possible, or socket client/server programs.

## Communication

1. Use HTTP protocol whenever possible in favor of RMI or/and others. The array of HTTP tools is almost infinite, and you do not need any special tools for debugging, testing, development.

1. Prefer lightweight data exchange formats (JSON) versus XML for tasks such as communication between client UI and server. 
