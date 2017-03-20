#!/usr/bin/env bash

MICROSERVICE_SUFIX="_img"
MS_NAME="`cat project.name`"
MS_NAME="$MS_NAME$MICROSERVICE_SUFIX"

#Remove all images not used
docker images -a --no-trunc | grep 'none' | awk '{print $3}' | xargs docker rmi
echo "Images not used deleted."

#Remove old images for this microservice
docker images -a --no-trunc | grep $MS_NAME | awk '{print $3}' | xargs docker rmi
echo "Images old deleted."

#Build a new images
docker build -f dev/Dockerfile.dev -t $MS_NAME --build-arg DEV_UID=$UID --build-arg DEV_HOME=$(pwd) .
echo "Build finished."