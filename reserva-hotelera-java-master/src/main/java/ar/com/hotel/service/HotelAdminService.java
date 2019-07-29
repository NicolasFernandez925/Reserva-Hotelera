package ar.com.hotel.service;

import java.util.List;
import org.hibernate.service.Service;

import ar.com.hotel.dto.HotelDTO;

public interface HotelAdminService extends Service {
	
	void create(HotelDTO dto);
	
	void update(HotelDTO dto);

	void delete(HotelDTO dto);
	
	List<HotelDTO> getAll();

	HotelDTO getById(int id);

	List<HotelDTO> getByName(String name);
}
