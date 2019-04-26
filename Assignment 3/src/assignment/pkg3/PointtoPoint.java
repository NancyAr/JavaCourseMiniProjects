/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg3;

/**
 *
 * @author NancyAlarabawy
 */

import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.concurrent.TimeUnit;
import mpi.*;

public class PointtoPoint {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        MPI.Init(args);
        int myrank = MPI.COMM_WORLD.Rank();
        //System.out.println("My Rank: "+myrank);
        if (myrank == 0) {
            File f1 = new File("file1.txt");
            String[] words = null;
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            String s;
            String input = "Nanoos";
            int LineCount = 0;
            int LineIdx = 0;
            int count = 0;
            char[] message = "0".toCharArray();

            long StartTime = System.currentTimeMillis();
            while ((s = br.readLine()) != null) //Reading Content from the file
            {
                words = s.split(" ");  //Split the word using space
                LineCount++;
                for (String word : words) {
                    if (word.equals(input)) //Search for the given word
                    {
                        count++;
                        LineIdx = LineCount;
                    }
                }
            }
            if (count != 0) {
                System.out.println("The given word is present at Line " + LineIdx + " of file1.txt");
                message = "1".toCharArray();
            } else {
                message = "-1".toCharArray();
            }

            System.out.println("will send:" + new String(message) + ":");
            try {
                Thread.sleep(10000);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            MPI.COMM_WORLD.Send(message, 0, message.length, MPI.CHAR, 1, 99);
           
            
            long EndTime = System.currentTimeMillis();
            System.out.println("Time elapsed in Process0 = "+(EndTime - StartTime)+" milliseconds." );
            
             fr.close();
        } else {
            File f1 = new File("file2.txt");
            String[] words = null;
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            String s;
            String input = "Nanoos";
            int LineCount = 0;
            int LineIdx = 0;
            int count = 0;
            long StartTime = System.currentTimeMillis();
             
            while ((s = br.readLine()) != null) //Reading Content from the file
            {
                words = s.split(" ");  //Split the word using space
                LineCount++;
                for (String word : words) {
                    if (word.equals(input)) //Search for the given word
                    {
                        count++;
                        LineIdx = LineCount;
                    }

                }
            }
            if (count != 0) {
                System.out.println("The given word is present at Line " + LineIdx + " of file2.txt");
                char[] message = new char[20];
                System.out.println("will receive:" + new String(message));
                Request req = MPI.COMM_WORLD.Irecv(message, 0, 20, MPI.CHAR, 0, 99);
                req.Wait();

            } else {
                char[] message = new char[20];
                System.out.println("will receive:" + new String(message));
                Request req = MPI.COMM_WORLD.Irecv(message, 0, 20, MPI.CHAR, 0, 99);
                req.Wait();
                System.out.println("received after waiting:" + new String(message));
                char[] ar = "-1".toCharArray();
                if (message[0] == ar[0]) {
                    System.out.println("Word not found");
                }
          
            }
            long EndTime = System.currentTimeMillis();
            System.out.println("Time elapsed in Process1 = "+(EndTime - StartTime)+" milliseconds." );
            fr.close();
        }
        MPI.Finalize();
    }
}
