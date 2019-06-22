# Paracorde Rest Server
The Java REST server for the Paracode project

# Requirements:
Java JRE of 1.8+

Maven (latest)

## Dependencies:
Jersey - This runs on an embedded Jersey Grizzly server and uses a Jersey Client to make the GET request to 

Google Gson - Used for object to json serialization

## How to run:
1. Checkout the repository
1. From the main project level run `mvn clean package` 
1. From the main project level run a `java -jar target paracord-server-0.0.1-SNAPSHOT-jar-with-dependencies.jar` which will bring up the service
    * or you can cd into the "target" folder and run `java -jar paracord-server-0.0.1-SNAPSHOT-jar-with-dependencies.jar`
1. Open up chrome (or other brower/postman) and hit http://localhost:8080/service/example/users/123