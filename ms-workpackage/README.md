
# Microservice Template.

## 1 Overview
This project contains the Microservice Template. It uses docker in development, build and production.

## 2 Developing locally 
Local development is done via a development docker image. As a minimum requirement, you need docker installed and a local clone of this repository.

> For information about install docker in your machine follow the next link :
> https://docs.docker.com/engine/installation/

> Note, for run this MicroService is necessary up postgres docker image. Here the link to pull and run:
> postgres docker image :  https://github.com/capablaza/postgresdb.git

### 2.1 Creating and running your docker development environment

#### 2.1.1 Using Docker Compose

The most simple way to build & run the MicroService is using Docker Composer, to this run the next command in the current folder **(repository root)**:

```docker-compose up```

#### 2.1.2 Manual Method

First, you need to build your docker image. To do so, run a similar command from your **repository root**:     

```docker build -f dev/Dockerfile.dev -t wildflyswarm --build-arg DEV_UID=$UID --build-arg DEV_HOME=$(pwd) .```

Once your image is built, you need to run it. Run the following command from your **repository root**:  

```docker run --name wildflyswarm -p 8080:8080 -u $UID -v $(pwd):$(pwd) -it --net postgresdb_default --link postgresdb:postgres wildflyswarm```

Finally you can view the application at ```http://localhost:8080```  and for review swagger api information you can use ```http://localhost:8080/swagger.json```


## General Document Helper Reference

#### Docker Cheat Sheet 

https://github.com/wsargent/docker-cheat-sheet

#### Wildfly Swarm

http://wildfly-swarm.io/documentation/

#### JPA
http://docs.oracle.com/javaee/6/tutorial/doc/bnbpz.html