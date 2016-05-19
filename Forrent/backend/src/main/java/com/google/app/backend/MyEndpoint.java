/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.google.app.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.app.backend.PropEntity;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.google.app.backend.OfyService;

import java.util.Map;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.app.google.com",
    ownerName = "backend.app.google.com",
    packagePath=""
  )
)
public class MyEndpoint {


    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi " + name + ", you son of a bitch");

        return response;
    }

    @ApiMethod(name = "createEntity")
    public PropEntity createEntity(@Named("group") String group, @Named("pass") String pass, Map<String, String> attr){
        PropEntity prop = new PropEntity(group, pass, attr);


        Objectify objectify = OfyService.ofy();
        objectify.save().entity(prop);

        return prop;
    }



}