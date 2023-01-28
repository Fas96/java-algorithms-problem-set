## MAIN POINTS TO NOTICE


## Requirements of the Various Components should be met

 - Compatible versions should be same or not of much difference
 - Preferred version of the components should be used
 - Binary files should be used Preferably
 -  AJP port 8009- Should not be configured if not needed

## Failed Components

-  Java version errors with Alfresco[oracle openjdk-11 preferrable] Ensure the java version is verified or if several is 
ensure the JAVA_HOME is set to the correct version[11]

-  Error with license key[Ensure the license key is correct and the license key is not expired] or used from other projects. But it should use the same with
with the download made from the community version[ If using the community version]

- SSL ERRORS- Failure to include the SSL files would cause errors.


## NOTE-IMPORTANT

alfresco-share-services.amp -> Alfresco share service module containing extensions for search, datalist, sample sites patch etc.


### AJP

Tomcat uses ISO-8859-1 character encoding when decoding URLs that are received from a browser. This can cause problems when creating, uploading, and renaming files with international characters.

Do not include it.


### apply_amps.bat

used for  directories to alfresco.war and share.war.

improper execution would cause errors.


## NOTE-IMPORTANT When using MODHEADER

X-Alfresco-Search-Secret: secret

any space in the secret would cause errors.
or the key with and little space can cause errors.
