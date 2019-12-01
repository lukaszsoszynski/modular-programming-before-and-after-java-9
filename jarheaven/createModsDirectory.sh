#!/usr/bin/env bash
mvn clean install

LIB_ONE_DIR="modsLibOne"
LIB_TWO_DIR="modsLibTwo"
LIB_ONE_AND_TWO_DIR="modsLibOneAndTwo"
LIB_MISSING="modsApplicationOnly"
MODULES_DIRECTORIES=(${LIB_ONE_DIR} ${LIB_TWO_DIR} ${LIB_ONE_AND_TWO_DIR} ${LIB_MISSING})

for dirName in "${MODULES_DIRECTORIES[@]}"
do
    rm -rf ${dirName}
    mkdir ${dirName}
    cp application/target/application-0.0.1-SNAPSHOT.jar ${dirName}
done

cp library-one/target/library-one-0.0.1-SNAPSHOT.jar ${LIB_ONE_DIR}
cp library-one/target/library-one-0.0.1-SNAPSHOT.jar ${LIB_ONE_AND_TWO_DIR}

cp library-two/target/library-two-0.0.1-SNAPSHOT.jar ${LIB_TWO_DIR}
cp library-two/target/library-two-0.0.1-SNAPSHOT.jar ${LIB_ONE_AND_TWO_DIR}