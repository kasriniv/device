package io.swagger.server.api.verticle;

import io.swagger.server.api.model.Device;

import java.util.List;
import java.util.Map;

public interface DefaultApi  {
    //GET_device
    public Device deviceGet();
    
    //POST_device
    public Device devicePost(Device body);
    
    //PUT_device
    public Device devicePut(Device body);
    
}
