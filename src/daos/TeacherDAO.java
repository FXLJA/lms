package daos;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Teacher;
import interfaces.TeacherInterface;

public class TeacherDAO implements TeacherInterface {
    @Override
    public boolean insert(Teacher teacher) {
        String sql = "INSERT INTO teacher VALUES(?, ?, ?)";
        try {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, teacher.getTeacher_id());
            statement.setString(2, teacher.getTeacher_name());
            statement.setString(3, teacher.getTeacher_subject());
            
            int row = statement.executeUpdate();
            statement.close();
            
            if (row > 0) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean update(Teacher teacher) {
        String sql = "UPDATE teacher SET teacher.teacher_name = ?, teacher.teacher_subject = ? WHERE teacher.teacher_id = ?";
        try {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, teacher.getTeacher_name());
            statement.setString(2, teacher.getTeacher_subject());
            statement.setString(3, teacher.getTeacher_id());

            int row = statement.executeUpdate();
            statement.close();
            
            if (row > 0) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean delete(Teacher teacher) {
        String sql = "DELETE FROM teacher WHERE teacher.teacher_id = ?";
        try {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, teacher.getTeacher_id());

            int row = statement.executeUpdate();
            statement.close();
            
            if (row > 0) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public List<Teacher> getAllTeacher() {
        List<Teacher> teacherList = new ArrayList<Teacher>();
        String sql = "SELECT * FROM teacher";
        try {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Teacher teacher = new Teacher(rs.getString(1), rs.getString(2), rs.getString(3));
                teacherList.add(teacher);
            }
            statement.close();
        } catch (Exception e) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, e);
        }
        return teacherList;
    }

    @Override
    public Teacher getByTeacher_id(String teacher_id) {
        Teacher teacher = null;
        String sql = "SELECT * FROM teacher WHERE teacher.teacher_id = ?";
        try {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, teacher_id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                teacher = new Teacher(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (Exception e) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, e);
        }
        return teacher;
    }
}

