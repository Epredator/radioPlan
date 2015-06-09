package com.etroya.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Adam on 2015-06-09.
 */

@Path("/injectTest")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class StaticResource {

    @GET
    @Path("annotations")
    public String getParamsFrommAnnotations(){
        return"TEst";

    }
}
