package models;
import java.sql.*;

public class Teacher {
    private String teacher_id;
    private String teacher_name;
    private String teacher_subject;
    
    public Teacher(String teacher_id, String teacher_name, String teacher_subject){
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.teacher_subject = teacher_subject;
    }
    
    public String getTeacher_id(){
        return teacher_id;
    }
    
    public void setTeacher_id(String teacher_id){
        this.teacher_id = teacher_id;
    }
    
    public String getTeacher_name(){
        return teacher_name;
    }
    
    public void setTeacher_name(String teacher_name){
        this.teacher_name = teacher_name;
    }
    
    public String getTeacher_subject(){
        return teacher_subject;
    }
    
    public void setTeacher_subject(String teacher_subject){
        this.teacher_subject = teacher_subject;
    }
}
