package controllers;

import java.util.List;
import java.util.Observable;
import daos.TeacherDAO;
import models.Teacher;
import interfaces.TeacherInterface;
import models.OperasiCRUD;

public class TeacherController extends Observable{
    private TeacherInterface dao = new TeacherDAO();
    private OperasiCRUD crud;
    
    public void setDAO(TeacherInterface teacher){
        dao = teacher;
    }
    
    public void setDml(Teacher teacher, OperasiCRUD c){
        boolean hasil = false;
        this.crud = c;
        switch(c){
            case INSERT: hasil = dao.insert(teacher); 
                break;
            case UPDATE: hasil = dao.update(teacher); 
                break;
            case DELETE: hasil = dao.delete(teacher); 
                break;
        }
        setChanged();
        
        if(hasil){
            notifyObservers(teacher);
        }else{
            notifyObservers();
        }
    }
    
    public OperasiCRUD getCrudState(){
        return crud;
    }    
    
    public List<Teacher> getAllTeacher(){
        return dao.getAllTeacher();
    }
    
    public Teacher getByTeacher_id(String teacher_id){
        return dao.getByTeacher_id(teacher_id);
    }
}
