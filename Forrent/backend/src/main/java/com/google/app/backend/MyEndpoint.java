/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.google.app.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.googlecode.objectify.Objectify;

import java.util.List;
import java.util.Map;

import javax.inject.Named;

import static com.googlecode.objectify.ObjectifyService.factory;

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

    @ApiMethod(name = "createProp")
    public PropEntity createProp(@Named("group") String group, @Named("pass") String pass, Map<String, String> attr){
        if(!validGroup(group, pass)){
            return null;
        }
        return putProp(group, attr);
    }

    @ApiMethod(name = "updateProp")
    public Response updateProp(@Named("group") String group, @Named("pass") String pass, @Named("id") Long id, @Named("timestamp") long timestamp, Map<String, String> attr){
        if(!validGroup(group, pass)){
            return new Response("Invalid group credentials", true);
        }
        PropEntity original = getProp(id);
        if(original.getTimestamp() > timestamp){
            return(new Response("A recent update has already been made to this Prop", true));
        }
        putProp(group, attr);
        return new Response("Prop Updated", false);

    }

    @ApiMethod(name = "getProps")
    public List<PropEntity> getProps(@Named("group") String group, @Named("pass") String pass){
        if(!validGroup(group,pass)){
            return null;
        }
        return OfyService.ofy().load().type(PropEntity.class).filter("groupName", group).list();
    }

    @ApiMethod(name = "deleteProp")
    public Response deleteProp(@Named("group") String group, @Named("pass") String pass, @Named("id") Long id){
        if(!validGroup(group,pass)){
            return new Response("Invalid group credentials", true);
        }
        if(!propExists(id)){
            return new Response("Invalid prop ID", true);
        }
        OfyService.ofy().delete().type(PropEntity.class).id(id).now();
        return new Response("Prop deleted", false);

    }

    @ApiMethod(name = "createGroup")
    public Response createGroup(@Named("groupName") String name, @Named("pass") String pass){
        if(groupExists(name)){
            return new Response("Group already exists", true);
        }
        putGroup(name, pass);
        return new Response("Group created", true);
    }


    private PropEntity putProp(String group, Map<String, String> attr){
        PropEntity prop = new PropEntity(group, attr);

        prop.setId(factory().allocateId(PropEntity.class).getId());
        Objectify objectify = OfyService.ofy();
        objectify.save().entity(prop).now();
        return prop;
    }

    private void putGroup(String name, String pass){
        GroupEntity group = new GroupEntity(name, pass);

        OfyService.ofy().save().entity(group).now();
    }

    private PropEntity getProp(long id){
        return OfyService.ofy().load().type(PropEntity.class).id(id).now();
    }

    private boolean validGroup(String name, String pass){
        GroupEntity group = OfyService.ofy().load().type(GroupEntity.class).id(name).now();
        if(group != null &&group.password == pass){
            return true;
        }
        return false;
    }

    private boolean groupExists(String name){
        return OfyService.ofy().load().type(GroupEntity.class).id(name).now() != null;
    }
    private boolean propExists(Long id){
        return OfyService.ofy().load().type(PropEntity.class).id(id).now() != null;
    }



}