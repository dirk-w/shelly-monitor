# Project Shelly monitor
this is a sample project to show how easy it is to develop a spring boot application

## Details
for more details see my blog under [Blog Shelly Monitor](https://dwich.de/?p=290)

## installation / running
first create a file in the resources folder named application-prod.properties
do the config stuff
run the maven clean install task 
then there is a jar file under target, this file is runnable with `java  -jar shelly-monitor-0.0.1.jar`
on Linux machine you can run that file with `java -jar shelly-monitor-1.0.0.jar --spring.profiles.active=prod & `

ths spring profiles active is a staging concept to run the application with different configurations
In this case we use prod and so the application-prod.properties will be used 

Another possibility is to change the configuration path as shown here
`java -jar shelly-monitor-1.0.0.jar --spring.profiles.active=prod --spring.config.location=/bin/<directory>/config`

> __Note__: java 17 must be installed on your system


## TODO 
- run inside docker container
