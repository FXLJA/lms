package daos;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Subject;
import interfaces.SubjectInterface;

public class SubjectDAO implements SubjectInterface {
    @Override
    public boolean insert(Subject subject) {
        String sql = "INSERT INTO subject VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, subject.getSubject_id());
            statement.setString(2, subject.getSubject_name());
            statement.setString(3, subject.getSubject_major());
            statement.setInt(4, subject.getSubject_minute());
            
            int row = statement.executeUpdate();
            statement.close();
            
            if (row > 0) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(Subject.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean update(Subject subject) {
        String sql = "UPDATE subject SET subject.subject_name = ?, subject.subject_major = ?, subject.subject_minute = ? WHERE subject.subject_id = ?";
        try {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, subject.getSubject_name());
            statement.setString(2, subject.getSubject_major());
            statement.setInt(3, subject.getSubject_minute());
            statement.setString(4, subject.getSubject_id());

            int row = statement.executeUpdate();
            statement.close();
            
            if (row > 0) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(Subject.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean delete(Subject subject) {
        String sql = "DELETE FROM subject WHERE subject.subject_id = ?";
        try {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, subject.getSubject_id());

            int row = statement.executeUpdate();
            statement.close();
            
            if (row > 0) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(Subject.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public List<Subject> getAllSubject() {
        List<Subject> subjectList = new ArrayList<Subject>();
        String sql = "SELECT * FROM subject";
        try {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Subject subject = new Subject(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                subjectList.add(subject);
            }
            statement.close();
        } catch (Exception e) {
            Logger.getLogger(Subject.class.getName()).log(Level.SEVERE, null, e);
        }
        return subjectList;
    }

    @Override
    public Subject getBySubject_id(String subject_id) {
        Subject subject = null;
        String sql = "SELECT * FROM subject WHERE subject.subject_id = ?";
        try {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, subject_id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                subject = new Subject(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (Exception e) {
            Logger.getLogger(Subject.class.getName()).log(Level.SEVERE, null, e);
        }
        return subject;
    }
}

