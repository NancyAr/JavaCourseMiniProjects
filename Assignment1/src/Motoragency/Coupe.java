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
public class Coupe extends Car implements java.io.Serializable{
    private int _doors;
    
    public Coupe(int carNo, int horsePower, boolean IsAvailable, int doors, float RentValue) {
        super(carNo, horsePower, RentValue, IsAvailable);
        this._doors = doors;
    }
    @Override
    void setIsAvailable(boolean IsAvailable){ this._IsAvailable = IsAvailable; }
    @Override
    boolean getIsAvailable(){  return _IsAvailable; };
   
    @Override
    void setRentValue(float RV){ this._RentValue = RV; }
    @Override
    float getRentValue(){  return _RentValue; };
   
    @Override
    float CalcRentValue()
    {
        setRentValue((_horsePower*5)); 
        return _RentValue;
    }

    @Override
    void printInfo() {
       
        System.out.println("Car #: " + _carNo);
		System.out.println("Car has " + _doors + " doors and has " + _horsePower + " horsePower!");
		System.out.println("It's Rent costs " + CalcRentValue() + " LE.");
		boolean Available;
		Available = getIsAvailable();
		if(Available) System.out.println("and it is available");
		else
			System.out.println("but unfortunately it's not available. ");
		
	}

}