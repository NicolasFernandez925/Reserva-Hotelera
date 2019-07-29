package ar.com.hotel.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T> {
		
		public void save(T entity);
		
		public T getById(Serializable id);
		
		public void delete(T entity);
		
		public List<T> getAll();

		public void update(T entity);

}
