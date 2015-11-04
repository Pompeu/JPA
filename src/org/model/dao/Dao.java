package org.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import org.model.util.JPAUtil;

public class Dao<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Class<T> classe;

	private final EntityManager em;

	public Dao(Class<T> classe, EntityManager em) {
		this.classe = classe;
		this.em = em;

	}
	public Dao(Class<T> classe) {
		this.classe = classe;
		this.em = new JPAUtil().getManager();

	}
	public T save(T obj) {
		em.getTransaction().begin();
		
		if (GetValuePrimaryKey.getID(obj) != null) {
			em.merge(obj);
		} else {
			em.persist(obj);
		}
		em.getTransaction().commit();
		em.close();
		return obj;
	}

	public boolean delete(T obj) {
		em.getTransaction().begin();
		obj = em.find(classe, GetValuePrimaryKey.getID(obj));
		em.remove(obj);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	public List<T> retrivetAll() {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.from(classe);
		return em.createQuery(query).getResultList();
	}

	public T retrivetbyId(Integer id) {
		return em.find(classe, id);
	}

}
