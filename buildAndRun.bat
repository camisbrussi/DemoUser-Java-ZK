@echo off
call mvn clean package
call docker build -t com.mycompany/DemoForm .
call docker rm -f DemoForm
call docker run -d -p 9080:9080 -p 9443:9443 --name DemoForm com.mycompany/DemoForm