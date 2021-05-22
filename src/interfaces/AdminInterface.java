package interfaces;

import java.util.List;
import models.Admin;

public interface AdminInterface {
    public boolean insert(Admin admin);
    public boolean update(Admin admin);
    public boolean delete(Admin admin);

    public List<Admin> getAllAdmin();
    public Admin getByAdmin_id(String admin_id);
}
