#!/bin/bash

sh build.sh
java -ea -classpath "$(pwd)/src/main/java/:$(pwd)/src/test/java/" com.devcookhome.dao.ConnectionManagerTest