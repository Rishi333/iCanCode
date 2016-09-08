#!/bin/sh

java -jar OutputFiles/jasmin.jar OutputFiles/InputFiles/$1.j
java -cp '.:OutputFiles/jasmin.jar:OutputFiles/PascalRTL.jar:OutputFiles/DataStruct.jar' $1
mv $1.class OutputFiles/$1.class
