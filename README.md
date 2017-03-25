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
$ curl -H "Content-Type: application/json" -H "Authorization: admin" -i http://localhost:8080/api/user # GET user by name
$ curl -H "Content-Type: application/json" -i http://localhost:8080/api/user/login --data '{"name":"test","password":"test"}' # POST login user
$ curl -H "Content-Type: application/json" -i http://localhost:8080/api/user/signup --data '{"name":"test","password":"test"}' # POST user named test and pass test
$ curl -H "Content-Type: application/json" -H "Authorization: <username>" -i http://localhost:8080/api/recipes # GET all recipes
$ curl -H "Content-Type: application/json" -H "Authorization: <username>" -i http://localhost:8080/api/recipe\?id\=78 # GET the recipe with id = 78
```
