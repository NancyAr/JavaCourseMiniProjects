/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author NancyAlarabawy
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class server {

    public static List<String> arrayList = new ArrayList<String>(10);
    public static int size = 0;

    public static void main(String[] args) throws Exception {
        System.out.println("The server is running.");
        int clientNumber = 0;
        ServerSocket listener = new ServerSocket(9898);
        ServerSocket listener2 = new ServerSocket(9899);
        try {
            while (true) {
                new Pusher(listener.accept(), clientNumber++).start();
                new Puller(listener2.accept(), clientNumber++).start();
            }

        } finally {
            listener.close();
            listener2.close();
        }

    }

    private static class Pusher extends Thread {

        private Socket socket;
        private int clientNumber;

        public Pusher(Socket socket, int clientNumber) {
            this.socket = socket;
            this.clientNumber = clientNumber;
            System.out.println("New connection with client# " + clientNumber + " at " + socket);
        }

        public void run() {

            try {

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Send a welcome message to the client.
                out.println("Hello, you are client #" + clientNumber + ".");

                // Get messages from the client, line by line
                while (true) {
                    String input = in.readLine();
                    if (input == null || input.equals(".")) {
                        break;
                    }
                    if (size < 10) {
                        arrayList.add(input);
                        size++;
                        out.println("Message added successfully");
                    } else {
                        out.println("Message wasn't added successfully, memory FULL!");
                    }
                }

            } catch (IOException e) {
                System.out.println("Error handling client# " + clientNumber + ": " + e);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Couldn't close a socket, what's going on?");
                }
                System.out.println("Connection with client# " + clientNumber + " closed");
            }
        }

    }

    private static class Puller extends Thread {

        private Socket socket;
        private int clientNumber;

        public Puller(Socket socket, int clientNumber) {
            this.socket = socket;
            this.clientNumber = clientNumber;
            System.out.println("New connection with client# " + clientNumber + " at " + socket);
        }

        public void run() {
            try {

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Send a welcome message to the client.
                out.println("Hello, you are client #" + clientNumber + ".");

                // Get messages from the client, line by line
                while (true) {
                    String input = in.readLine();
                    if (input == null || input.equals(".")) {
                        break;
                    }
                    if (size > 0) {
                        int idx = Integer.parseInt(input);
                        out.println("Message:" + arrayList.get(idx));
                        arrayList.remove(idx);
                        size--;
                    } else {
                        out.println("Message not found, memory is EMPTY");
                    }
                }

            } catch (IOException e) {
                System.out.println("Error handling client# " + clientNumber + ": " + e);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Couldn't close a socket, what's going on?");
                }
                System.out.println("Connection with client# " + clientNumber + " closed");
            }
        }

    }
}
