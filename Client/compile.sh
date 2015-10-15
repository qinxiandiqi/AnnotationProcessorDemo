#!/bin/bash
$JAVA_HOME/bin/javac -cp ../Annotations/target/annotationprocessordemo-annotations-1.0-SNAPSHOT.jar;../Processors/target/annotationprocessordemo-processors-1.0-SNAPSHOT.jar -d target/classes/com/qinxiandiqi/annotationprocessordemo/client/ src/main/java/com/qinxiandiqi/annotationprocessordemo/client/SimpleAnnotationsTest.java
