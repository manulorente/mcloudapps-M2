# Getting started

## Generate services production files with Maven  

### Change directory to each service folder and run below command  

 `mvnw -X package`

## Run databases services with Docker  

 `docker run --rm -e MYSQL_ROOT_PASSWORD=pass -e MYSQL_DATABASE=test -p 3306:3306 -d mysql:8.0.22`  

## Run all services from different terminals  

`java -jar airport\target\persistence-0.0.1-SNAPSHOT.jar`
