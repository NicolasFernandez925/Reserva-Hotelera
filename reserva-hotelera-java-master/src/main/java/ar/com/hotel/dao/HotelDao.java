package ar.com.hotel.dao;

import java.io.Serializable;
import java.util.List;

import ar.com.hotel.entities.Hotel;

public interface HotelDao {

	void save(Hotel hotel);
	
	void update(Hotel hotel);
	
	void delete(Hotel hotel);
	
	List<Hotel> getAll();
	
	Hotel getById(Serializable id);

	List<Hotel> getByName(String name);
	
	
}
