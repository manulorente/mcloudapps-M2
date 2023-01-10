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

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import mcloudapps.server.eoloplant.model.EoloPlant;

@Component
public class WebSocketHandler extends AbstractWebSocketHandler {


    /*
    private Set<Session> sessions = new HashSet<>();

    @OnOpen
    public void open(Session session) {
        System.out.println("Session opened: " + session.getId());
        sessions.add(session);
    }

    @OnMessage
    public void handleMessage(EoloPlant eoloPlant, Session session) throws IOException{
        for (Session s : sessions) {
            System.out.println("Message received: "+eoloPlant.toString());
            s.getAsyncRemote().sendObject(eoloPlant.toString(),
            result -> {
                if (result.getException() != null) {
                    System.out.println("Unable to send message: " + result.getException());
                }
            });
        }
    }

    @OnClose
    public void close(Session session) {
        System.out.println("Session closed: " + session.getId());
        sessions.remove(session);
    }

    @OnError
    public void onError(Throwable error) {
        System.out.println(error.getMessage());
        error.printStackTrace();
    }
    */

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage eoloPlant) throws InterruptedException, IOException {
        System.out.println("Message received: "+ eoloPlant.getPayload().toString());
        session.sendMessage(new TextMessage(eoloPlant.getPayload().toString()));
    }

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("User disconnected "+ session.getId());
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("User connected " + session.getId());
		session.sendMessage(new TextMessage("Hello user"));
	}
    
}
