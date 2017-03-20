package com.example.demo.rest.resources;


import com.example.demo.rest.PersistenceHelper;
import com.example.demo.rest.model.Tool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/tools")
@Api(value = "/tools", description = "Get tools information", tags = "tools")
public class ToolResource {

    @Inject
    PersistenceHelper helper;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get the all tool",
            notes = "Returns tool as list",
            response = List.class)
    public Tool[] get() {


        return helper.getEntityManager().createNamedQuery("Tool.findAll", Tool.class).getResultList().toArray(new Tool[0]);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tool get(@PathParam("id") int id) {

        return helper.getEntityManager().createNamedQuery("Tool.getById", Tool.class).setParameter("id", id).getSingleResult();
    }


    @GET
    @Path("/task/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get the all tool associated in the task",
            notes = "Returns tool as list",
            response = List.class)
    public Tool[] findByTaskId(@PathParam("id") int id) {

        return helper.getEntityManager().createNamedQuery("Tool.findByTaskId", Tool.class).setParameter("id", id).getResultList().toArray(new Tool[0]);

    }

}

