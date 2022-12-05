package websocketsarefun.websockets;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint(value = "/chat")
public class HelloWorldEndpoint
{
    private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(Session session)
    {
        System.out.println("Session open with id: " + session.getId());
        sessions.add(session);
        /*
        System.out.printf("Session open, id: %s",session.getId());
        try {
            session.getBasicRemote().sendText("Successfully connected!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        */
    }


    @OnMessage
    public String onMessage(String message, Session session)
    {
        System.out.println("Handling message: " + message);
        return message;
        /*
        System.out.printf("Message received. Session id: %s Message: %s%n",session.getId(),message);
        try
        {
            session.getBasicRemote().sendText(String.format("We received you message: %s%n",message));
        } catch(IOException ex)
        {
            ex.printStackTrace();
        }
        */
    }

    @OnError
    public void onError(Throwable e) {e.printStackTrace();}

    @OnClose
    public void onClose(Session session)
    {
        System.out.printf("Session closed with id: ",session.getId());
        sessions.remove(session);
    }


}
