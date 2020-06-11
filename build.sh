#!/bin/bash

find -name *.java > /tmp/compilation.txt
javac @/tmp/compilation.txt