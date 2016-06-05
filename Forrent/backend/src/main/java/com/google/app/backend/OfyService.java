package com.google.app.backend;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

import java.util.Map;

/**
 * Created by Michael on 5/18/2016.
 */


public class OfyService {

    static {
        ObjectifyService.register(PropEntity.class);
        ObjectifyService.register(GroupEntity.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }

}
