package org.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class Dao<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Class<T> classe;

	private final EntityManager em;

	public Dao(Class<T> classe, EntityManager em) {
		this.classe = classe;
		this.em = em;

	}

	public T create(T obj) {
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		em.close();
		return obj;
	}

	public boolean delete(T obj) {
		em.getTransaction().begin();
		obj = em.find(classe, PegarPkKeyTempoExecucao.getIdObjeto(obj));
		em.remove(obj);
		em.getTransaction().commit();
		em.close();
		return true;

	}

	public T update(T obj) {
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		em.close();
		return obj;
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
