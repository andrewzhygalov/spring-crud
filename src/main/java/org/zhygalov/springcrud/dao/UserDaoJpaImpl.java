package org.zhygalov.springcrud.dao;
import org.zhygalov.springcrud.model.User;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoJpaImpl implements UserDao {
	@PersistenceContext
    private EntityManager entityManager;
	
	public User findOne(long id) {
		return entityManager.find(User.class, id);
	}
    public List<User> findAll() {
		return entityManager.createQuery("from User", User.class).getResultList();
	}
    public void create(User user) {
		entityManager.persist(user);
	}
    public User update(User user) {
		return entityManager.merge(user);
	}
    public void delete(User user) {
		 entityManager.remove(entityManager.contains(user) ? user : update(user));
	}
    public void deleteById(long userId) {
		User user = findOne(userId);
        delete(user);
	}
}