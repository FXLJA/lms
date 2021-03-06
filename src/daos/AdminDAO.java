package daos;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Admin;
import interfaces.AdminInterface;

public class AdminDAO implements AdminInterface {
    @Override
    public boolean insert(Admin admin) {
        String sql = "INSERT INTO admin VALUES(?, ?, ?)";
        try {
            int row;
            try (PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql)) {
                statement.setString(1, admin.getAdmin_id());
                statement.setString(2, admin.getAdmin_name());
                statement.setString(3, admin.getAdmin_contact());
                row = statement.executeUpdate();
            }
            
            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean update(Admin admin) {
        String sql = "UPDATE admin SET admin.admin_name = ?, admin.admin_contact = ? WHERE admin.admin_id = ?";
        try {
            int row;
            try (PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql)) {
                statement.setString(1, admin.getAdmin_name());
                statement.setString(2, admin.getAdmin_contact());
                statement.setString(3, admin.getAdmin_id());
                row = statement.executeUpdate();
            }
            
            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean delete(Admin admin) {
        String sql = "DELETE FROM admin WHERE admin.admin_id = ?";
        try {
            int row;
            try (PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql)) {
                statement.setString(1, admin.getAdmin_id());
                row = statement.executeUpdate();
            }
            
            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public List<Admin> getAllAdmin() {
        List<Admin> adminList = new ArrayList<>();
        String sql = "SELECT * FROM admin";
        try {
            try (PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql)) {
                ResultSet rs = statement.executeQuery();
                
                while (rs.next()) {
                    Admin admin = new Admin(rs.getString(1), rs.getString(2), rs.getString(3));
                    adminList.add(admin);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, e);
        }
        return adminList;
    }

    @Override
    public Admin getByAdmin_id(String admin_id) {
        Admin admin = null;
        String sql = "SELECT * FROM admin WHERE admin.admin_id = ?";
        try {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, admin_id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                admin = new Admin(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, e);
        }
        return admin;
    }
}

