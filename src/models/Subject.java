package models;
import java.sql.*;

public class Subject {
    private String subject_id;
    private String subject_name;
    private String subject_major;
    private int subject_minute;
    
    public Subject(String subject_id, String subject_name, String subject_major, int subject_minute){
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.subject_major = subject_major;
        this.subject_minute = subject_minute;
    }
    
    public String getSubject_id(){
        return subject_id;
    }
    
    public void setSubject_id(String subject_id){
        this.subject_id = subject_id;
    }
    
    public String getSubject_name(){
        return subject_name;
    }
    
    public void setSubject_name(String subject_name){
        this.subject_name = subject_name;
    }
    
    public String getSubject_major(){
        return subject_major;
    }
    
    public void setSubject_major(String subject_major){
        this.subject_major = subject_major;
    }
    
    public int getSubject_minute(){
        return subject_minute;
    }
    
    public void setSubject_minute(int subject_minute){
        this.subject_minute = subject_minute;
    }

    @Override
    public String toString() {
        return this.subject_name;
    }
}
