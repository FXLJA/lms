package interfaces;

import java.util.List;
import models.Subject;

public interface SubjectInterface {
    public boolean insert(Subject subject);
    public boolean update(Subject subject);
    public boolean delete(Subject subject);

    public List<Subject> getAllSubject();
    public Subject getBySubject_id(String subject_id);
}
