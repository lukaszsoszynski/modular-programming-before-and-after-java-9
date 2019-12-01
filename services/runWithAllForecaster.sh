#!/bin/bash

set -x

#build project if you need
#mvn clean install

MODULE_DIR=modules

rm -Rf $MODULE_DIR
mkdir $MODULE_DIR

for DIRECTORY in imgw meteo meteorologist yr
do
    cp $DIRECTORY/target/*.jar $MODULE_DIR
done

echo
echo
echo

java --module-path $MODULE_DIR \
-m meteorologist/com.gfi.lsos.modularity.meteorologist.Application