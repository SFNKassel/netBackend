package de.sfn_kassel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anselm on 24.06.16.
 */
public class Node {
    String ip, mac, ping, parentIP;
    Node parentNode;
    List<Node> children = new ArrayList<>();

    public Node(String mac, String ip, String ping) {
        this(mac, ip, ping, "");
    }

    public Node(String mac, String ip, String ping, String parent) {
        this.ip = ip;
        this.mac = mac;
        this.ping = ping;
        this.parentIP = parent;
    }

    @Override
    public String toString() {
        return "Node{" +
                "ip='" + ip + '\'' +
                ", mac='" + mac + '\'' +
                ", ping='" + ping + '\'' +
                ", parentIP='" + parentIP + '\'' +
                ", children=" + children +
                '}';
    }

    //    @Override
//    public String toString() {
//        return super.toString()+"["+ip+","+;
//    }
}
