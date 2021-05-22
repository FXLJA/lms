package interfaces;

import java.util.List;
import models.Teacher;

public interface TeacherInterface {
    public boolean insert(Teacher teacher);
    public boolean update(Teacher teacher);
    public boolean delete(Teacher teacher);

    public List<Teacher> getAllTeacher();
    public Teacher getByTeacher_id(String teacher_id);
}
