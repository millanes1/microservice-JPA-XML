#!/usr/bin/env bash

MS_NAME="`cat project.name`"
CONTAINER_SUFIX="_cn"
CONTAINER_NAME="$MS_NAME$CONTAINER_SUFIX"

#Stop container
docker stop $CONTAINER_NAME