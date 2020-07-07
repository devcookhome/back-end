#!/bin/bash

find -name *.java > /tmp/compilation.txt
javac -Xlint:unchecked @/tmp/compilation.txt