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
public class MotorCycle extends Car implements java.io.Serializable {
    private int _fuelCapacity;
    
    public MotorCycle(int bikeNo, int fuelCapacity, boolean IsAvailable, float RentValue) {
        super(bikeNo, 0, RentValue ,IsAvailable);
        this._fuelCapacity = fuelCapacity;
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
    float CalcRentValue(){
        return 100;
    }
    @Override
    void printInfo() {
        System.out.println("Motorcycle No.: " + _carNo );
	System.out.println("It has " + _fuelCapacity + " fuel capacity");
	System.out.println("It's Rent costs " + _RentValue + " LE.");		
        boolean Available;
	Available = getIsAvailable();
	if(Available) System.out.println("and it is available");
            else
		System.out.println("but unfortunately it's not available. ");
		
	}

}