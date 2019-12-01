#!/bin/bash

echo "Use script runWithAllForecaster.sh first to build application"
ALL_MODULES=$(ls -la modules)
echo "Available application modules $ALL_MODULES"

set -x

CUSTOM_JRE=customjre

rm -Rf $CUSTOM_JRE

#MODULE_LIST="meteorologist"
#MODULE_LIST="imgw"
MODULE_LIST="imgw,meteo,yr"

JLINK_EXTRA=""
JLINK_EXTRA="--no-header-files --no-man-pages --compress=2 --strip-debug"

jlink --module-path modules \
    --add-modules $MODULE_LIST \
    --launcher forecaster=meteorologist/com.gfi.lsos.modularity.meteorologist.Application \
    $JLINK_EXTRA \
    --output $CUSTOM_JRE

du -hs $CUSTOM_JRE

echo "modules included to custom java image:"
./$CUSTOM_JRE/bin/java --list-modules

./$CUSTOM_JRE/bin/java --module meteorologist/com.gfi.lsos.modularity.meteorologist.Application