#!/bin/bash
while ! nc -z ${MYSQL_IP} ${MYSQL_PORT}; do sleep 3; done
echo "${MYSQL_IP}:${MYSQL_PORT}"
java -jar /Exam1.jar test
java -jar /Exam1.jar