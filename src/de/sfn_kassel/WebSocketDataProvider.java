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

    public void sendToAll() {
        for(WebSocket conn : connections()) {
            System.out.println(nb.json);
            conn.send(nb.json);
        }
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        conn.send(nb.json);
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {

    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        conn.send(nb.json);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {

    }
}
