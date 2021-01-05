package org.zhygalov.springcrud.service;
import org.zhygalov.springcrud.model.User;
import org.zhygalov.springcrud.dao.UserDao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
	@Autowired
	UserDao dao;
	public User findOne(long id) {
		return dao.findOne(id);
	}
    public List<User> findAll() {
		return dao.findAll();
	}
    public void create(User user) {
		dao.create(user);
	}
    public User update(User user) {
		return dao.update(user) ;
	}
    public void delete(User user) {
		 dao.delete(user);
	}
    public void deleteById(long userId) {
		dao.deleteById(userId);
	}
}