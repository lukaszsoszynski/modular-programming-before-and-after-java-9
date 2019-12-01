#!/bin/bash

function contain_module_descriptor() {
#    echo "Check file $1"
    return $(unzip -l $1 | grep "module-info.class" | wc -l)
}

function contain_automatic_module_name(){
    return $(unzip -p $1 | grep -i "Automatic-Module-Name" | wc -l)
}

cd ./install/

mvn dependency:copy-dependencies

cd -

MODULE_PATH_DIR=module_path
CLASS_PATH_DIR=class_path

rm -Rf $MODULE_PATH_DIR
rm -Rf $CLASS_PATH_DIR

mkdir $MODULE_PATH_DIR $CLASS_PATH_DIR

ALL_DEPENDENCIES_DIR=./install/target/dependencies

du -hs $ALL_DEPENDENCIES_DIR

rm $ALL_DEPENDENCIES_DIR/lombok*.jar
#rm $ALL_DEPENDENCIES_DIR/javax.activation-1.2.0.jar
cp ./install/target/install*jar $MODULE_PATH_DIR

for jarfile in $ALL_DEPENDENCIES_DIR/*.jar; do
    contain_module_descriptor $jarfile
    HAS_MODULE_DESCRIPTOR=$?
    contain_automatic_module_name $jarfile
    IS_AUTOMATIC_MODULE=$?
    if [ "$HAS_MODULE_DESCRIPTOR" -eq "1" ]; then
        cp $jarfile $MODULE_PATH_DIR
    elif [ "$IS_AUTOMATIC_MODULE" -eq "1" ]; then
        cp $jarfile $MODULE_PATH_DIR
    else
        cp $jarfile $CLASS_PATH_DIR
    fi
    echo "Current jar file $jarfile has module descriptor $HAS_MODULE_DESCRIPTOR or contain automatic module name $IS_AUTOMATIC_MODULE"
done

#this module has not stable name. Do not use it on production
mv $CLASS_PATH_DIR/spring-xml-3.0.7.RELEASE.jar $MODULE_PATH_DIR
mv $CLASS_PATH_DIR/spring-ws-core-3.0.7.RELEASE.jar $MODULE_PATH_DIR

set -x

java  \
--class-path "$CLASS_PATH_DIR/*" \
--module-path $MODULE_PATH_DIR \
--add-modules java.instrument,java.xml.bind \
-m install/com.gfi.lsos.training.jigsaw.install.JigsawApplication