package de.sfn_kassel;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by anselm on 24.06.16.
 */
public class NetBackend implements Runnable {

    private final File cPath;

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    public NetBackend(File cPath) throws IOException {
        this.cPath = cPath;
    }

    @Override
    public void run() {
    }

    public String getJsonTree() throws IOException {
        Collection<Node> nodes = getNodes().values();
        String ret = "";
        nodes.parallelStream().filter(n -> n.parentNode == null).forEach(n -> {
            n.children
        });
    }

    private String node2Json(Node n) {
        if(n.children.isEmpty())
            return;

        StringBuilder json = new StringBuilder();
        json.append("{");
        for(Node child : n.children){
            json.append(node2Json(child));

        }
    }

    private HashMap<String, Node> getNodes() throws IOException {
        Scanner robIN;
        String line;
        Process cProcess = Runtime.getRuntime().exec(cPath.getAbsolutePath());
        robIN = new Scanner(cProcess.getInputStream());
        HashMap<String, Node> knownNodes = new HashMap<>();
        while ((line = robIN.nextLine()) != null) {
            Node n = parseLine(line);
            knownNodes.put(n.mac, n);
        }
        knownNodes.values().stream().filter(n -> knownNodes.containsKey(n.parent)).forEach(n -> n.parentNode = knownNodes.get(n.parent));

        knownNodes.values().stream().filter(n -> n.parentNode != null).forEach(n -> n.parentNode.children.add(n));

        return knownNodes;
    }

    private Node parseLine(String line) {
        String[] cols = line.split(",");

        if (cols.length < 4)
            throw new IllegalArgumentException(line);

        return new Node(cols[0], cols[1], cols[2], cols[3]);
    }
}
