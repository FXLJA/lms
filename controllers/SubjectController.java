package controllers;

import java.util.List;
import java.util.Observable;
import daos.SubjectDAO;
import models.Subject;
import interfaces.SubjectInterface;
import models.OperasiCRUD;

public class SubjectController extends Observable{
    private SubjectInterface dao = new SubjectDAO();
    private OperasiCRUD crud;
    
    public void setDAO(SubjectInterface subject){
        dao = subject;
    }
    
    public void setDml(Subject subject, OperasiCRUD c){
        boolean hasil = false;
        this.crud = c;
        switch(c){
            case INSERT: hasil = dao.insert(subject); 
                break;
            case UPDATE: hasil = dao.update(subject); 
                break;
            case DELETE: hasil = dao.delete(subject); 
                break;
        }
        setChanged();
        
        if(hasil){
            notifyObservers(subject);
        }else{
            notifyObservers();
        }
    }
    
    public OperasiCRUD getCrudState(){
        return crud;
    }    
    
    public List<Subject> getAllSubject(){
        return dao.getAllSubject();
    }
    
    public Subject getBySubject_id(String subject_id){
        return dao.getBySubject_id(subject_id);
    }
}
