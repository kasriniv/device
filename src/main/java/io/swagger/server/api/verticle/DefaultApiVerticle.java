package io.swagger.server.api.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import io.swagger.server.api.model.Device;

import java.util.List;
import java.util.Map;

public class DefaultApiVerticle extends AbstractVerticle {
    final static Logger LOGGER = LoggerFactory.getLogger(DefaultApiVerticle.class); 
    
    final static String GET_DEVICE_SERVICE_ID = "GET_device";
    final static String POST_DEVICE_SERVICE_ID = "POST_device";
    final static String PUT_DEVICE_SERVICE_ID = "PUT_device";
    
    //TODO : create Implementation
    DefaultApi service = new DefaultApiImpl();

    @Override
    public void start() throws Exception {
        
        //Consumer for GET_device
        vertx.eventBus().<JsonObject> consumer(GET_DEVICE_SERVICE_ID).handler(message -> {
            try {
                
                Device result = service.deviceGet();
                message.reply(new JsonObject(Json.encode(result)).encodePrettily());
            } catch (Exception e) {
                //TODO : replace magic number (101)
                message.fail(101, e.getLocalizedMessage());
            }
        });
        
        //Consumer for POST_device
        vertx.eventBus().<JsonObject> consumer(POST_DEVICE_SERVICE_ID).handler(message -> {
            try {
                Device body = Json.mapper.readValue(message.body().getJsonObject("body").encode(), Device.class);
                
                Device result = service.devicePost(body);
                message.reply(new JsonObject(Json.encode(result)).encodePrettily());
            } catch (Exception e) {
                //TODO : replace magic number (101)
                message.fail(101, e.getLocalizedMessage());
            }
        });
        
        //Consumer for PUT_device
        vertx.eventBus().<JsonObject> consumer(PUT_DEVICE_SERVICE_ID).handler(message -> {
            try {
                Device body = Json.mapper.readValue(message.body().getJsonObject("body").encode(), Device.class);
                
                Device result = service.devicePut(body);
                message.reply(new JsonObject(Json.encode(result)).encodePrettily());
            } catch (Exception e) {
                //TODO : replace magic number (101)
                message.fail(101, e.getLocalizedMessage());
            }
        });
        
    }
}