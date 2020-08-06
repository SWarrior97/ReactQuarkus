package org.acme;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.acme.model.MultipartBodyLogIn;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@Path("/product")
public class ProductResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String greetingFull(@MultipartForm MultipartBodyLogIn data) {
        return null;
    }
}