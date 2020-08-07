package org.acme;

import org.acme.MultipartForm.MultipartBodyCreate;
import org.acme.MultipartForm.MultipartBodyLogIn;
import org.acme.model.User;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("/user")
public class UserResource {
    @Inject
    LogInService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "user";
    }

    @POST
    @Path("/veryLogIn")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("application/json")
    public Set<User> verifyLogIn(@MultipartForm MultipartBodyLogIn data) {
        return service.verifyLogIn(data.email,data.password);
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("application/json")
    public Set<User> createUser(@MultipartForm MultipartBodyCreate data) {
        return service.createUser(data.name,data.email,data.password,data.role);
    }
}
