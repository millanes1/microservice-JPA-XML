package com.example.demo.rest.resources;


import com.example.demo.rest.PersistenceHelper;
import com.example.demo.rest.model.WorkPackage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/workpackages")
@Api(value = "/workpackages", description = "Get workpackage information", tags = "workpackage")
public class WorkPackageResource {

    @Inject
    PersistenceHelper helper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get the all workpackages",
            notes = "Returns workpackages as list",
            response = List.class)


    public WorkPackage[] get() {


        return helper.getEntityManager().createNamedQuery("WorkPackage.findAll", WorkPackage.class).getResultList().toArray(new WorkPackage[0]);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public WorkPackage get(@PathParam("id") int id) {

        return helper.getEntityManager().createNamedQuery("WorkPackage.getById", WorkPackage.class).setParameter("id", id).getSingleResult();
    }


}

