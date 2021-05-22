package interfaces;

import java.util.List;
import models.Student;

public interface StudentInterface {
    public boolean insert(Student student);
    public boolean update(Student student);
    public boolean delete(Student student);

    public List<Student> getAllStudent();
    public Student getByStudent_id(String student_id);
}
