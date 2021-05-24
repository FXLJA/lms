package models;
import java.sql.*;

public class Admin {
    private String admin_id;
    private String admin_name;
    private String admin_contact;
    
    public Admin(String admin_id, String admin_name, String admin_contact, String admin_password){
        this.admin_id = admin_id;
        this.admin_name = admin_name;
        this.admin_contact = admin_contact;
    }
    
    public String getAdmin_id(){
        return admin_id;
    }
    
    public void setAdmin_id(String admin_id){
        this.admin_id = admin_id;
    }
    
    public String getAdmin_name(){
        return admin_name;
    }
    
    public void setAdmin_name(String admin_name){
        this.admin_name = admin_name;
    }
    
    public String getAdmin_contact(){
        return admin_contact;
    }
    
    public void setAdmin_contact(String admin_contact){
        this.admin_contact = admin_contact;
    }
}
