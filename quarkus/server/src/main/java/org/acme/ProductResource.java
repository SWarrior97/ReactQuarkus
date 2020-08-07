package org.acme;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/product")
public class ProductResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }


}