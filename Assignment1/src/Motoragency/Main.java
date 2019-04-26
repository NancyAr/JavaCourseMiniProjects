/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Motoragency;

/**
 *
 * @author NancyAlarabawy
 */
import java.io.*;
public class Main implements Serializable {
    public static void main(String[] args)
    {
        String filename = "file2.ser"; 
          
        MotorAgency m = new MotorAgency();
        Coupe c1 = new Coupe(111555, 200, true, 2,0);
        Coupe c2 = new Coupe(999333, 210, true, 2,0);
        MotorCycle m1 = new MotorCycle(666888, 12, true, 300);
        m.AddMotor(c1);
        m.AddMotor(c2);
        m.AddMotor(m1);
        m.PrintAll();
        m.RentMotor(2);
        m.PrintAll();
        m.RentMotor(1);
        m.PrintAll();
        
        // Serialization  
        try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(filename); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(m); 
              
            out.close(); 
            file.close(); 
              
            System.out.println("Motor Agency object has been serialized\n"); 
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
  
      
        MotorAgency mA = null;
    

// Deserialization 
        try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(filename); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
            mA = (MotorAgency)in.readObject(); 
              
            in.close(); 
            file.close(); 
              
            System.out.println("Motor Agency object has been deserialized \n"); 
            System.out.println("Deserialized output: "); 
             
            mA.PrintAll();
            
            
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
    }
} 
