/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.google.app.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.googlecode.objectify.Key;
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
    public MyBean createProp(@Named("group") String group, @Named("pass") String pass, Map<String, String> attr){
        MyBean response = new MyBean();

        if(!validGroup(group, pass)){
            return response.setData("Invalid group");
        }
        PropEntity prop = putProp(group, attr);
        return response.setData("Prop created").setId(prop.getId().toString()).setTimestamp(prop.getTimestamp().toString());
    }

    @ApiMethod(name = "updateProp")
    public PropEntity updateProp(@Named("group") String group, @Named("pass") String pass, @Named("id") Long id, @Named("timestamp") long timestamp, Map<String, String> attr){
        if(!validGroup(group, pass)){
            return null;
        }
        PropEntity original = getProp(id);
        if(original.getTimestamp() > timestamp){
            return null;
        }
        return putProp(group, attr);
    }

    @ApiMethod(name = "getProps")
    public List<PropEntity> getProps(@Named("group") String group, @Named("pass") String pass){

        if(!validGroup(group,pass)){
            return null;
        }
        return OfyService.ofy().load().type(PropEntity.class).filter("groupName", group).list();
    }

    @ApiMethod(name = "deleteProp")
    public MyBean deleteProp(@Named("group") String group, @Named("pass") String pass, @Named("id") Long id){
        MyBean response = new MyBean();
        if(!validGroup(group,pass)){
            response.setData("Invalid group credentials");
            return response;
        }
        if(!propExists(id)){
            response.setData("Invalid prop ID");
            return response;
        }
        OfyService.ofy().delete().type(PropEntity.class).id(id).now();
        response.setData("Prop deleted");
        return response;
    }

    @ApiMethod(name = "createGroup", httpMethod = ApiMethod.HttpMethod.POST)
    public MyBean createGroup(@Named("groupName") String name, @Named("pass") String pass){
        MyBean response = new MyBean();
        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        if(groupExists(name)){
            response.setData("Group already exists.");
            return response;
        }
        putGroup(name, pass);
        response.setData("Group created");
        return response;

    }

    @ApiMethod(name = "doNothing", httpMethod = ApiMethod.HttpMethod.GET)
    public MyBean donNothing(){
        MyBean bean = new MyBean();
        bean.setData("answer");
        return bean;
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
        if(group != null && group.password.equals(pass)){
            return true;
        }
        return false;
    }

    private boolean groupExists(String name){
        //return OfyService.ofy().load().type(GroupEntity.class).id(name).now() != null;
        return OfyService.ofy().load().filterKey(Key.create(GroupEntity.class, name)).count() != 0;
    }
    private boolean propExists(Long id){
        return OfyService.ofy().load().type(PropEntity.class).id(id).now() != null;
    }

}