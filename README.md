# Paracord
A ReactJS front-end and Java JAX-RS REST api web project that will hold random useful tools for us and friends with various scopes.
## Dependencies
Docker

## Run
`docker-compose build` -- Builds all required docker containers from the respective Dockerfiles.

`docker-compose up` -- Starts all of the docker containers, networks, and dependencies. Mounts a persistant volume for the mongodb to connect to.

`docker-compose down` -- Cleans up all of the docker artifacts created by the `docker-compose up`.