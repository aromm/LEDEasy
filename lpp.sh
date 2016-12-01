#!/bin/bash

# get arguments
filename=$1

# run sbt program
echo "Initializing program"
sbt --warn <<<  "run ledplusplus $filename"

echo "--------------------------"
echo "Arduino file created"
echo "Located at $filename/$filename"
echo ""

