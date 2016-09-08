#!/bin/bash

cd src/wci/frontend/
jjtree calc.jjt
javacc calc.jj
cd ../../../
