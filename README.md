# Server [![Build Status](https://travis-ci.org/Grace-Hopper/Server.svg?branch=master)](https://travis-ci.org/Grace-Hopper/Server)
## Run
```zsh
# Compile and generate a war if all test are passed
$ mvn package 
# Run server in port 8080
$ java -jar target/dependency/webapp-runner.jar target/*.war
```