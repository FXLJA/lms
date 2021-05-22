package daos;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;
import interfaces.UserInterface;

public class UserDAO implements UserInterface {
    @Override
    public boolean insert(User user) {
        String sql = "INSERT INTO user VALUES(?, ?)";
        try {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, user.getId());
            statement.setString(2, user.getRole());
            
            int row = statement.executeUpdate();
            statement.close();
            
            if (row > 0) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        String sql = "UPDATE user SET user.role = ? WHERE user.id = ?";
        try {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, user.getRole());
            statement.setString(2, user.getId());

            int row = statement.executeUpdate();
            statement.close();
            
            if (row > 0) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        String sql = "DELETE FROM user WHERE user.id = ?";
        try {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, user.getId());

            int row = statement.executeUpdate();
            statement.close();
            
            if (row > 0) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<User>();
        String sql = "SELECT * FROM user";
        try {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                User user = new User(rs.getString(1), rs.getString(2));
                userList.add(user);
            }
            statement.close();
        } catch (Exception e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        return userList;
    }

    @Override
    public User getById(String id) {
        User user = null;
        String sql = "SELECT * FROM user WHERE user.id = ?";
        try {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                user = new User(rs.getString(1), rs.getString(2));
            }
        } catch (Exception e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        return user;
    }
}

