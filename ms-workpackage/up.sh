#!/usr/bin/env bash

MS_NAME="`cat project.name`"
CONTAINER_SUFIX="_cn"
CONTAINER_NAME="$MS_NAME$CONTAINER_SUFIX"

MICROSERVICE_SUFIX="_img"
MS_NAME="$MS_NAME$MICROSERVICE_SUFIX"

#Delete old containers
docker ps --filter name=$CONTAINER_NAME -qa | xargs docker rm -f 
echo "Removing old containers."

#Delete last compilation
rm -rf target
echo "Last compilation deleted. (target folder purged)"

#Run new container
docker run --name $CONTAINER_NAME -p 8080:8080 -u $UID -v $(pwd):$(pwd) -it --net postgresdb_default --link postgresdb:postgres $MS_NAME