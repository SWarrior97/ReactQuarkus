package org.acme.MultipartForm;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

public class MultipartBodyCreate {

    @FormParam("name")
    @PartType(MediaType.TEXT_PLAIN)
    public String name;

    @FormParam("email")
    @PartType(MediaType.TEXT_PLAIN)
    public String email;

    @FormParam("password")
    @PartType(MediaType.TEXT_PLAIN)
    public String password;

    @FormParam("role")
    @PartType(MediaType.TEXT_PLAIN)
    public String role;
}
