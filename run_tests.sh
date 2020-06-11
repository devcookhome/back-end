#!/bin/bash

sh build.sh
java -ea -classpath "$(pwd)/lib/mysql-connector-java-8.0.20.jar:$(pwd)/src/main/java/:$(pwd)/src/test/java/" com.devcookhome.dao.ConnectionManagerTest