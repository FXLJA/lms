package models;
import java.sql.*;

public class Student {
    private String student_id;
    private String student_name;
    private String student_class;
    private String student_major;
    
    public Student(String student_id, String student_name, String student_class, String student_major){
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_class = student_class;
        this.student_major = student_major;
    }
    
    public String getStudent_id(){
        return student_id;
    }
    
    public void setStudent_id(String student_id){
        this.student_id = student_id;
    }
    
    public String getStudent_name(){
        return student_name;
    }
    
    public void setStudent_name(String student_name){
        this.student_name = student_name;
    }
    
    public String getStudent_class(){
        return student_class;
    }
    
    public void setStudent_class(String student_class){
        this.student_class = student_class;
    }
    
    public String getStudent_major(){
        return student_major;
    }
    
    public void setStudent_major(String student_major){
        this.student_major = student_major;
    }
}
