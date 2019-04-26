/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author NancyAlarabawy
 */
import java.io.*;
import java.net.*;
import java.util.*;

/**
 * A simple client for the capitalization server.
 */
public class client {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 1 && choice != 2) {
            System.out.println("What service do you need please choose 1 for push or 2 for pull");
            choice = input.nextInt();
        }
        int port = 9899;
        // In case of push
        if (choice == 1) {
            port = 9898;
            //Connect to server
            Socket socket = new Socket("localhost", 9898);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Consume the initial welcoming messages from the server
            System.out.println(in.readLine());

            BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
            String message = "";
            while (true) {

                System.out.println("Enter message or a period '.' to quit");

                message = consolereader.readLine();
                out.println(message); //send message to server
                if (message.equals(".")) {
                    break;
                }
                 try {
                    Thread.sleep((new Random()).nextInt(5000));
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                String response = in.readLine();
                System.out.println(response + "\n");
            }
            socket.close();
        } else if (choice == 2) {
            port = 9899;
            //Connect to server
            Socket socket = new Socket("localhost", 9899);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Consume the initial welcoming messages from the server
            System.out.println(in.readLine());

            BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
            String message = "";
            while (true) {

                System.out.println("Enter index of message to pull or a period '.' to quit");

                message = consolereader.readLine();
                out.println(message); //send message to server
                if (message.equals(".")) {
                    break;
                }
                try {
                    Thread.sleep((new Random()).nextInt(10000));
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                String response = in.readLine();
                System.out.println("Pulled message = " + response + "\n");
            }
            socket.close();
        }
    }
}
