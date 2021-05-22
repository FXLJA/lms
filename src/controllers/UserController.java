package controllers;

import java.util.List;
import java.util.Observable;
import daos.UserDAO;
import models.User;
import interfaces.UserInterface;
import models.OperasiCRUD;

public class UserController extends Observable{
    private UserInterface dao = new UserDAO();
    private OperasiCRUD crud;
    
    public void setDAO(UserInterface user){
        dao = user;
    }
    
    public void setDml(User user, OperasiCRUD c){
        boolean hasil = false;
        this.crud = c;
        switch(c){
            case INSERT: hasil = dao.insert(user); 
                break;
            case UPDATE: hasil = dao.update(user); 
                break;
            case DELETE: hasil = dao.delete(user); 
                break;
        }
        setChanged();
        
        if(hasil){
            notifyObservers(user);
        }else{
            notifyObservers();
        }
    }
    
    public OperasiCRUD getCrudState(){
        return crud;
    }    
    
    public List<User> getAllUser(){
        return dao.getAllUser();
    }
    
    public User getById(String id){
        return dao.getById(id);
    }
}
