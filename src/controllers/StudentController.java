package controllers;

import java.util.List;
import java.util.Observable;
import daos.StudentDAO;
import models.Student;
import interfaces.StudentInterface;
import models.OperasiCRUD;

public class StudentController extends Observable{
    private StudentInterface dao = new StudentDAO();
    private OperasiCRUD crud;
    
    public void setDAO(StudentInterface student){
        dao = student;
    }
    
    public void setDml(Student student, OperasiCRUD c){
        boolean hasil = false;
        this.crud = c;
        switch(c){
            case INSERT: hasil = dao.insert(student); 
                break;
            case UPDATE: hasil = dao.update(student); 
                break;
            case DELETE: hasil = dao.delete(student); 
                break;
        }
        setChanged();
        
        if(hasil){
            notifyObservers(student);
        }else{
            notifyObservers();
        }
    }
    
    public OperasiCRUD getCrudState(){
        return crud;
    }    
    
    public List<Student> getAllStudent(){
        return dao.getAllStudent();
    }
    
    public Student getByStudent_id(String student_id){
        return dao.getByStudent_id(student_id);
    }
}
