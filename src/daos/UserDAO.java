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
        String sql = "INSERT INTO user VALUES(?, ?, ?)";
        try {
            int row;
            try (PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql)) {
                statement.setString(1, user.getId());
                statement.setString(2, user.getPassword());
                statement.setString(3, user.getRole());
                row = statement.executeUpdate();
            }
            
            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        String sql = "UPDATE user SET user.password = ?, user.role = ? WHERE user.id = ?";
        try {
            int row;
            try (PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql)) {
                statement.setString(1, user.getPassword());
                statement.setString(2, user.getRole());
                statement.setString(3, user.getId());
                row = statement.executeUpdate();
            }
            
            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        String sql = "DELETE FROM user WHERE user.id = ?";
        try {
            int row;
            try (PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql)) {
                statement.setString(1, user.getId());
                row = statement.executeUpdate();
            }
            
            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try {
            try (PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql)) {
                ResultSet rs = statement.executeQuery();
                
                while (rs.next()) {
                    User user = new User(rs.getString(1), rs.getString(2), rs.getString(3));
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
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
                user = new User(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        return user;
    }
}

