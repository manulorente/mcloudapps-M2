# Getting started

## Place your local directory into the project folder

## Run MongoDB and MySQL services with Docker
	docker run --rm -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=eolo -p 3306:3306 -d mysql:8.0.22
	docker run --rm -p 27017:27017 -d mongo:4.4-bionic

# Run all services from differents terminals
	java -jar toposervice-0.0.1-SNAPSHOT.jar
	java -jar server-0.0.1-SNAPSHOT.jar
				
## The app will be served at http:\\localhost:8080\
