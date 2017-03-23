# Server [![Build Status](https://travis-ci.org/UNIZAR-30226-2017-01/Server.svg?branch=master)](https://travis-ci.org/UNIZAR-30226-2017-01/Server)
## Required
+ openjdk8 or oraclejdk8
+ Apache Maven 3.3.9
+ git

## Install
```zsh
$ git clone https://github.com/Grace-Hopper/Server.git
$ cd Server
```
If you are using an IDE just import maven project and search for *pom.xml*
## Run
```zsh
$ ./run.sh
```
## Test with curl
```zsh
$ curl -H "Content-Type: application/json" -i http://localhost:8080/api/user --data '{"username":"xyz"}'
$ curl -H "Content-Type: application/json" -i http://localhost:8080/api/recepies
$ curl -H "Content-Type: application/json" -i http://localhost:8080/api/recepie\?id\=78
```
