SSL setup
==================================

General info
--------------------------------

Due to JAVA security constraints, we created a special keystore, which contains all the trusted certificate CAs,
that we trust. Curently these are: SIGEN-CA. Keystore needs to be saved somewhere where jboss can read it. Further, we 
created a special SSL authenticator class, which trustes all host names (if they have certificates issued by trusted CAs).

Additional change is requred to jboss module for SUN_JDK. We need to include ssl related classes to be included in
jboss module, that contains sun JDK classes.


Jboss setup for LINUX
--------------------------------

1.A Java Keystore File (JKS) should be copied to readable location (by user running jboss)
On production this is :

    /somewhere/MyKeystore.jks

2.Following changes are needed to jboss module file <JBOSS_HOME>\modules\system\layers\base\sun\jdk\main\module.xml

    <path name="com/sun/ssl/internal/ssl"/>
    <path name="com/sun/net/ssl"/>


**IMPORTANT : After changes to jboss module, jboss needs a restart.**   

3. In deployment strcuture you need to add reference to 

    <dependencies>
            <module name="sun.jdk"/>
    </dependencies>
   