package controllers;

import java.util.List;
import java.util.Observable;
import daos.AdminDAO;
import models.Admin;
import interfaces.AdminInterface;
import models.OperasiCRUD;

public class AdminController extends Observable{
    private AdminInterface dao = new AdminDAO();
    private OperasiCRUD crud;
    
    public void setDAO(AdminInterface admin){
        dao = admin;
    }
    
    public void setDml(Admin admin, OperasiCRUD c){
        boolean hasil = false;
        this.crud = c;
        switch(c){
            case INSERT: hasil = dao.insert(admin); 
                break;
            case UPDATE: hasil = dao.update(admin); 
                break;
            case DELETE: hasil = dao.delete(admin); 
                break;
        }
        setChanged();
        
        if(hasil){
            notifyObservers(admin);
        }else{
            notifyObservers();
        }
    }
    
    public OperasiCRUD getCrudState(){
        return crud;
    }    
    
    public List<Admin> getAllAdmin(){
        return dao.getAllAdmin();
    }
    
    public Admin getByAdmin_id(String admin_id){
        return dao.getByAdmin_id(admin_id);
    }
}
