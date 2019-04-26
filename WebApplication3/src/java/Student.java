/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NancyAlarabawy
 */
public class Student {

    private int ID, GradYear;
    float GPA;
    private String Name, Department;

    public void setID(int id) {
        this.ID = id;
    }

    public int getID() {
        return ID;
    }
    
    public void setGPA(float gpa) {
        this.GPA = gpa;
    }

    public float getGPA() {
        return GPA;
    }
    
    public void setName(String name) {
        this.Name = name;
    }

    public String getName() {
        return Name;
    }
    
     public void setDpt(String dpt) {
        this.Department = dpt;
    }

    public String getDpt() {
        return Department;
    }
    
     public void setGradYear(int gradyear) {
        this.GradYear = gradyear;
    }

    public int getGradYear() {
        return GradYear;
    }
    
    


}

