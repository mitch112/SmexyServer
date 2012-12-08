@echo off
title Compiler
echo Compiling RS2Server...
"C:/Program Files/Java/jdk1.7.0_03/bin/javac.exe" -d bin -cp lib/*; -sourcepath src src\org\dementhium\tools\ShopEditor.java
echo Complete
pause