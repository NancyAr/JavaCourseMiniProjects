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
public class MotorAgency implements java.io.Serializable{
    Car[] MotorArr = new Car[3];
    int i = 0;
    MotorAgency(){}
    void AddMotor(Car c)
    {
       MotorArr[i] = c;
       i++;
    }
    void RentMotor(int r)
    {
        if(r == 1)
        {
            for(int j = 0; j < i; j++)
            {
                //if((MotorArr[j]._carNo % 2) != 0 && MotorArr[j]._IsAvailable == true) //i.e. is a car
                if((MotorArr[j] instanceof Coupe) && MotorArr[j]._IsAvailable == true)
                {
                    System.out.println("Car #: " + MotorArr[j]._carNo + " is rented!");
                    System.out.println("\n "); 
                    MotorArr[j].setIsAvailable(false);
                    break;
                }
            }
        }
        else {
            for(int j = 0; j < i; j++)
            {
                //if((MotorArr[j]._carNo % 2) == 0 && MotorArr[j]._IsAvailable == true) //i.e. is a motorcycle
                if((MotorArr[j] instanceof MotorCycle) && MotorArr[j]._IsAvailable == true)
                {
                    System.out.println("Motorcycle #: " + MotorArr[j]._carNo + "is rented!");
                    System.out.println("\n "); 
                    MotorArr[j].setIsAvailable(false);
                }
                
            }
        }
    }
    void PrintAll()
    {
        for(int j = 0; j < i; j++)
            {
                MotorArr[j].printInfo();
                System.out.println("                 ");
            }
    }
}
