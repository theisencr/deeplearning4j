#!/bin/sh
 
ssh app@APP.SERVER.IP.ADDRESS <<EOF
  cd ~/hello-jenkins
  git pull
  npm install --production
  forever restartall
  exit
EOF