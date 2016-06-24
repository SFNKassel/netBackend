package de.sfn_kassel;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by anselm on 24.06.16.
 */
public class NetBackend implements  Runnable {

    private final Scanner robIN;

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    public NetBackend(File cPath) throws IOException {
        Process cProcess = Runtime.getRuntime().exec(cPath.getAbsolutePath());
        robIN = new Scanner(cProcess.getInputStream());
    }

    @Override
    public void run() {
        String line;
        while ((line = robIN.nextLine()) != null) {
            parseLine(line);
        }
    }

    private void parseLine(String line) {

    }
}
