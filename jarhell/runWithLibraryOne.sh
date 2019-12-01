#!/bin/bash
java -cp \
application/target/application-0.0.1-SNAPSHOT.jar:\
library-one/target/library-one-0.0.1-SNAPSHOT.jar \
com.impaq.lsos.modularity.application.Application