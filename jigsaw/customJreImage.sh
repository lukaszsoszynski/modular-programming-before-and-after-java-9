#!/bin/bash

#First build and run project with script "runWithModulePath.sh"

echo "Required dependencies (this works with jdk 12 or latter due to mixing multi release and not multi relese jars)"
echo "Thus jdeps from java 11 is useless in this case."
#jdeps --list-deps --ignore-missing-deps --multi-release 11 --module-path module-path --class-path class_path/*.jar
#java.base
#   java.desktop
#   java.instrument
#   java.logging
#   java.management
#   java.naming
#   java.scripting
#   java.security.jgss
#   java.security.sasl
#   java.sql
#   java.transaction.xa
#   java.xml
#   jdk.attach
#   jdk.jdi
#   jdk.unsupported
#   jdk8internals/sun.reflect

IMAGE_PATH=customJreImage
rm -rf $IMAGE_PATH

MODULE_PATH_DIR=module_path
CLASS_PATH_DIR=class_path

#one additional module required: java.compiler

#JLINK_EXTRA=""
JLINK_EXTRA="--no-header-files --no-man-pages --compress=2 --strip-debug"

jlink --module-path $JAVA_HOME/jmods \
    $JLINK_EXTRA \
    --add-modules java.desktop,java.instrument,java.logging,java.management,java.naming,java.scripting,java.security.jgss,java.security.sasl,java.sql,java.transaction.xa,java.xml,jdk.attach,jdk.unsupported,java.compiler \
    --output $IMAGE_PATH

echo "Size of custom jre image:"
du -hs $IMAGE_PATH

$IMAGE_PATH/bin/java  \
--class-path "$CLASS_PATH_DIR/*" \
--module-path $MODULE_PATH_DIR \
--add-modules java.instrument,java.xml.bind \
-m install/com.gfi.lsos.training.jigsaw.install.JigsawApplication