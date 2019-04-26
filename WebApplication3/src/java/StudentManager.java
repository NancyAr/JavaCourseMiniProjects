
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NancyAlarabawy
 */
import java.util.List;
import java.util.ArrayList;
public class StudentManager {
    public static ArrayList<Student> students = new ArrayList<Student>(10);
    public void Addstudent(Student s){
        students.add(s);
    }
    public Student getstudent(){
        ArrayList<Student> temp = new ArrayList<Student>(10);
        temp = students;
        int size = temp.size();
        return temp.get(size-1);
        
    }
    public ArrayList getstudents(){
        //ArrayList<Student> temp = new ArrayList<Student>(10);
        //temp = students;
        return students;
    }
    
    
}
