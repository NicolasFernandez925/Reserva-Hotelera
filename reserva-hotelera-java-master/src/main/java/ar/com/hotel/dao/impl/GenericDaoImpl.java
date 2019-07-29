package ar.com.hotel.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.hotel.dao.GenericDao;
@Component
public abstract class GenericDaoImpl<T> implements GenericDao<T>{
	
	private Class<T> persistentClass;
	@Autowired
	private SessionFactory sessionFactory;
	
	public GenericDaoImpl(Class<T> c){
		persistentClass = c;
	}
	public Class<T> getPersistentClass(){
		return persistentClass;
	}
	public void setPersistentClass(Class<T> persistentClass){
		this.persistentClass = persistentClass;
	}	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return getSessionFactory().getCurrentSession();
	}
	@Override
	public void save(T entity){
		getSession().save(entity);				
	}
	@SuppressWarnings("unchecked")
	@Override
	public T getById(Serializable id){
		return (T)getSession().get(getPersistentClass(), id);
	}
	@Override
	public void update(T entity){
		getSession().update(entity);
	}
	@Override
	public void delete(T entity){
		getSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(){
		return getSession().createQuery("from "+getPersistentClass().getSimpleName()).list();		
	}

}
