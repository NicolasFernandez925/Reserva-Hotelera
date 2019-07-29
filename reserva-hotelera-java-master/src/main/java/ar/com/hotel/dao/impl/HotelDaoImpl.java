package ar.com.hotel.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;
import ar.com.hotel.dao.HotelDao;
import ar.com.hotel.entities.Hotel;

@Repository
public class HotelDaoImpl extends GenericDaoImpl<Hotel> implements HotelDao {

//	private SessionFactory sessionFactory;
	
	public HotelDaoImpl() {
		super(Hotel.class);
	}
	
	public void save(Hotel hotel) {
		super.save(hotel);
	}

	public void update(Hotel hotel) {
		super.update(hotel);
	}

	public void delete(Hotel hotel) {
//		super.delete(hotel);
	}

	public List<Hotel> getAll() {
		return super.getAll();
	}

	public Hotel getById(Serializable id) {
		return super.getById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hotel> getByName(String name) {
		System.out.println("DAO" + name);
		List<Hotel> l = getSession().createQuery("from Hotel where name LIKE :name").setParameter("name", "%"+name+"%").list();
		return l;
	}

//	public SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//
//	public void setSessiponFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}

}
