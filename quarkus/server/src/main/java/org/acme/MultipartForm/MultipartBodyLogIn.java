package org.acme.MultipartForm;

import java.io.InputStream;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class MultipartBodyLogIn {

    @FormParam("email")
    @PartType(MediaType.TEXT_PLAIN)
    public String email;

    @FormParam("password")
    @PartType(MediaType.TEXT_PLAIN)
    public String password;
}
