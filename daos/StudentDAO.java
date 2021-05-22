package daos;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Student;
import interfaces.StudentInterface;

public class StudentDAO implements StudentInterface {
    @Override
    public boolean insert(Student student) {
        String sql = "INSERT INTO student VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, student.getStudent_id());
            statement.setString(2, student.getStudent_name());
            statement.setString(3, student.getStudent_class());
            statement.setString(4, student.getStudent_major());
            
            int row = statement.executeUpdate();
            statement.close();
            
            if (row > 0) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean update(Student student) {
        String sql = "UPDATE student SET student.student_name = ?, student.student_class = ?, student.student_major = ? WHERE student.student_id = ?";
        try {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, student.getStudent_name());
            statement.setString(2, student.getStudent_class());
            statement.setString(3, student.getStudent_major());
            statement.setString(4, student.getStudent_id());

            int row = statement.executeUpdate();
            statement.close();
            
            if (row > 0) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean delete(Student student) {
        String sql = "DELETE FROM student WHERE student.student_id = ?";
        try {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, student.getStudent_id());

            int row = statement.executeUpdate();
            statement.close();
            
            if (row > 0) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> studentList = new ArrayList<Student>();
        String sql = "SELECT * FROM student";
        try {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                studentList.add(student);
            }
            statement.close();
        } catch (Exception e) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, e);
        }
        return studentList;
    }

    @Override
    public Student getByStudent_id(String student_id) {
        Student student = null;
        String sql = "SELECT * FROM student WHERE student.student_id = ?";
        try {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, student_id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (Exception e) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, e);
        }
        return student;
    }
}

