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
public abstract class Car implements java.io.Serializable{
    int _carNo;
    int _horsePower;
    public float _RentValue;
    boolean _IsAvailable;
    
    Car(int carNo, int horsePower, float RentValue, boolean IsAvailable){
        this._carNo = carNo;
        this._horsePower = horsePower;
        this._RentValue = RentValue;
	this._IsAvailable = IsAvailable;
    }
    
    abstract void setIsAvailable(boolean IsAvailable);
    abstract boolean getIsAvailable();
    abstract void setRentValue(float RV);
    abstract float getRentValue();
    abstract float CalcRentValue();
    abstract void printInfo();
}
