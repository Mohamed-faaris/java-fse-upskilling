## Hands on 1
Create a Spring Web Project using Maven Follow steps below to create a project:
Go to https://start.spring.io/
Change Group as “com.cognizant”
Change Artifact Id as “spring-learn”
Select Spring Boot DevTools and Spring Web
Create and download the project as zip
Extract the zip in root folder to Eclipse Workspace
Build the project using ‘mvn clean package -Dhttp.proxyHost=proxy.cognizant.com -Dhttp.proxyPort=6050 -Dhttps.proxyHost=proxy.cognizant.com -Dhttps.proxyPort=6050 -Dhttp.proxyUser=123456’ command in command line
Import the project in Eclipse "File > Import > Maven > Existing Maven Projects > Click Browse and select extracted folder > Finish"
Include logs to verify if main() method of SpringLearnApplication.
Run the SpringLearnApplication class.
SME to walk through the following aspects related to the project created:
src/main/java - Folder with application code
src/main/resources - Folder for application configuration
src/test/java - Folder with code for testing the application
SpringLearnApplication.java - Walkthrough the main() method.
Purpose of @SpringBootApplication annotation
pom.xml
Walkthrough all the configuration defined in XML file
Open 'Dependency Hierarchy' and show the dependency tree.