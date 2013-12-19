JbossWorkshop
==============

Accompany guide and code for JBoss7 Workshop.....

# to send cert data to jboss via AJP
SSLOptions +StdEnvVars +ExportCertData

# Setup custom error page to be returned when there is no user certificate available
RewriteEngine on
RewriteRule   ^/503.html$ - [L]
RewriteCond   %{SSL:SSL_CLIENT_VERIFY} !=SUCCESS
RewriteRule   .? - [F]
ErrorDocument 403 /503.html
