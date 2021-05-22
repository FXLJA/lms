package interfaces;

import java.util.List;
import models.User;

public interface UserInterface {
    public boolean insert(User user);
    public boolean update(User user);
    public boolean delete(User user);

    public List<User> getAllUser();
    public User getById(String id);
}
