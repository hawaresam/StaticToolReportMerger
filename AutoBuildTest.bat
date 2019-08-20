@echo off
call mvnw.cmd clean compile assembly:single
cd target
call java -jar FirstProject-1.0-jar-with-dependencies.jar "C:/Users/320065418/OneDrive - Philips/Desktop/Case Study/FirstProject/config.properties"
pause