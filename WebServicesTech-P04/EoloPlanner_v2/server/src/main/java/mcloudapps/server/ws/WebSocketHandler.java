package mcloudapps.server.ws;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import mcloudapps.server.eoloplant.model.EoloPlant;
import mcloudapps.server.eoloplant.model.EoloPlantDecoder;
import mcloudapps.server.eoloplant.model.EoloPlantEncoder;

@Component
@ServerEndpoint(value = "/eoloplants",
                decoders = {EoloPlantDecoder.class},
                encoders = {EoloPlantEncoder.class})
public class WebSocketHandler {

    private static Set<Session> sessions = new HashSet<>();

    private Logger log = LoggerFactory.getLogger(ServerEndpoint.class);

    @OnOpen
    public void onOpen(Session session) {
        log.info( "Session opened: " + session.getId());
        sessions.add(session);
    }

    @OnMessage
    public void sendMessage(EoloPlant message) throws IOException {
        log.info("Message sent: " + message);
        for (Session s : sessions) {
            try{
                s.getBasicRemote().sendObject(message);
            } catch (Exception e) {
                log.error("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        log.info("Session closed: " + session.getId());
        sessions.remove(session);
    }

    @OnError
    public void onError(Throwable error) {
        log.error("Error: " + error.getMessage());
        error.printStackTrace();
    }
    
}
