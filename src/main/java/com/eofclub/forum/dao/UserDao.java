package com.eofclub.forum.dao;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.eofclub.forum.model.User;

@Stateless
public class UserDao {
	@PersistenceContext(unitName = "ForumPU")
	private EntityManager em;

	public void create(User entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Optional<User> user = Optional.of(em.find(User.class, id));
		if (user.isPresent())
			em.remove(user.get());
		
	}

	public User findById(Long id) {
		return em.find(User.class, id);
	}

	public User update(User entity) {
		return em.merge(entity);
	}

	public List<User> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<User> findAllQuery = em.createQuery(
				"SELECT DISTINCT u FROM User u ORDER BY u.id", User.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
	
	public Optional<User> checkLogin(String email,String password){
		TypedQuery<User> getUser = em.createNamedQuery("check.auth",User.class);
		getUser.setParameter("email", email);
		getUser.setParameter("password", password);
	    Optional<User> user = Optional.of(getUser.getSingleResult());
		return user;
	}
}
