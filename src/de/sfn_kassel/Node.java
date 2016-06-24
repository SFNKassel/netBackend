package de.sfn_kassel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anselm on 24.06.16.
 */
public class Node {
    String ip, mac, ping, parent;
    Node parentNode;
    List<Node> children = new ArrayList<>();

    public Node(String mac, String ip, String ping) {
        this(mac, ip, ping, "");
    }

    public Node(String mac, String ip, String ping, String parent) {
        this.ip = ip;
        this.mac = mac;
        this.ping = ping;
        this.parent = parent;
    }
}
