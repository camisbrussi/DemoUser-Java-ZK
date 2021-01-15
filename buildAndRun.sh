#!/bin/sh
mvn clean package && docker build -t com.mycompany/DemoForm .
docker rm -f DemoForm || true && docker run -d -p 9080:9080 -p 9443:9443 --name DemoForm com.mycompany/DemoForm