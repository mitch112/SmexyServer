@echo off
title Map
java -client -Xmx512m -cp bin;lib/* org.dementhium.tools.coordinategrabber.Main
pause