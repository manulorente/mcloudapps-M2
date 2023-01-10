package mcloudapps.server.eoloplant.model;

import javax.websocket.Decoder;

public class EoloPlantDecoder implements Decoder.Text<EoloPlant> {

    @Override
    public EoloPlant decode(String s) throws javax.websocket.DecodeException {
        try {
            return EoloPlant.fromJson(s);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void init(javax.websocket.EndpointConfig config) {
        
    }

    @Override
    public void destroy() {
        
    }
    
}
