# Getting started

## Generate services production files with Maven  

### Change directory to each service folder and run below command  

 `mvnw -X package`

## Run databases services with Docker  

 `docker run --rm -e MYSQL_ROOT_PASSWORD=pass -e MYSQL_DATABASE=test -p 3306:3306 -d mysql:8.0.22`  
 `docker run --rm -p 27017:27017 -d mongo:4.4-bionic`  

## Load provinces JSON data into MongoDB database  

`airport\src\main\resources\Provincias.json`  

## Run all services from different terminals  

`java -jar airport\target\persistence-0.0.1-SNAPSHOT.jar`
