# Spring20260622

初回起動コマンド

'''bash
$env:MAVEN_OPTS="-Daether.transport.https.securityMode=insecure -Daether.connector.https.securityMode=insecure -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true"
 
& ".\mvnw.cmd" `
  -f ".\pom.xml" `
  -U spring-boot:run
'''
