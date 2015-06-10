package com.etroya.resources;

import javax.ws.rs.*;
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

    @GET
    @Path("matrix")
    public String getParamsFromMatrixParam(@MatrixParam("param") String matrixParam){
        return"Matrix Param: " + matrixParam;
    }

    @GET
    @Path("header")
    public String getParamsFromHeaderParam(@HeaderParam("headerValue") String header){
        return "Header param: " + header;
    }

    @GET
    @Path("cookie")
    public String getParamsFromCookieValues(@CookieParam("cookie") String cookieVal){
        return "Cookie value: "+ cookieVal;

    }
}
