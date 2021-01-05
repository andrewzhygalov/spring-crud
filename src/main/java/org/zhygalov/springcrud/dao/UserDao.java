package org.zhygalov.springcrud.dao;
import org.zhygalov.springcrud.model.User;
import java.util.List;
public interface UserDao {
	public User findOne(long id);
    public List<User> findAll();
    public void create(User user);
    public User update(User user);
    public void delete(User user);
    public void deleteById(long userId);
}