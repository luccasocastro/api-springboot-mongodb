package com.luxkapotter.Api.Mongo.services.exception;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException (String msg){
        super(msg);
    }
}
