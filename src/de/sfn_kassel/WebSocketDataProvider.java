package de.sfn_kassel;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * Created by anselm on 24.06.16.
 */
public class WebSocketDataProvider extends WebSocketServer {

    private NetBackend nb;

    public WebSocketDataProvider(NetBackend nb) throws UnknownHostException {
        super( new InetSocketAddress( 8888 ));
        this.nb = nb;
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        System.out.println("connect");
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {

    }

    @Override
    public void onMessage(WebSocket conn, String message) {
//        System.out.println("onMessage");
        conn.send(nb.json);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {

    }
}
