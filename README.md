# 204-case-biro

## How to run
on docker-compose-support.yml change the following params:

| VARIABLE                         | VALUE                 | EXAMPLE     |
| -------------------------------- | --------------------- | ----------- |
| SERVICE_DISCOVERY_SERVER_ADDRESS | Your local IP ADDRESS | 192.168.0.2 |
| LOCAL_ADDRESS                    | Your local IP ADDRESS | 192.168.0.2 |

then run:
```sh
$ docker-compose -f docker-compose-support.yml up
``` 

## Docker compose content:
- consul <br>
    https://hub.docker.com/_/consul
- docker.io/tonsaito/mtc-configuration-service:latest <br>
    https://hub.docker.com/repository/docker/tonsaito/mtc-configuration-service
- docker.io/tonsaito/mtc-gateway-service:latest <br>
    https://hub.docker.com/repository/docker/tonsaito/mtc-gateway-service   

## Configuration repository
https://github.com/tonsaito/configuration-repo-biro.git

## How to run the microservices
```sh
$ gradle bootRun
``` 
on each microservice folder.

## How to test
(consul server) http://localhost:8500/ <br>
(configuration server) http://localhost:8888/service-name/profile <br>
(gateway server) http://localhost:9080/service-name/** <br>

(company-api) http://localhost:5000/swagger-ui.html#/ <br>
(capital-validation-api) http://localhost:5100/swagger-ui.html#/ <br>
(company-confirmation-api) http://localhost:5200/swagger-ui.html#/  <br>