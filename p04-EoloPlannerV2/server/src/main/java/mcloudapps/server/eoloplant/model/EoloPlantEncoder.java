package mcloudapps.server.eoloplant.model;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;

import com.fasterxml.jackson.core.JsonProcessingException;

public class EoloPlantEncoder implements Encoder.Text<EoloPlant> {

    @Override
    public String encode(EoloPlant eoloPlant) throws EncodeException {
        try {
            return eoloPlant.toJson();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void init(javax.websocket.EndpointConfig config) {
        
    }

    @Override
    public void destroy() {
        
    }
    
}
