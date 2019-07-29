package ar.com.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.hotel.convert.Assembler;
import ar.com.hotel.dao.HotelDao;
import ar.com.hotel.dto.HotelDTO;
import ar.com.hotel.service.HotelAdminService;
@Service
public class HotelAdminServiceImpl implements HotelAdminService {

	private static final long serialVersionUID = 1L;
	@Autowired
	private HotelDao hotelDao;

	public HotelAdminServiceImpl() {
		
	}
	
	@Override
	public void create(HotelDTO dto) {
		hotelDao.save(Assembler.fromDTO(dto));
	}

	@Override
	public void update(HotelDTO dto) {
		hotelDao.update(Assembler.fromDTO(dto));
	}

	@Override
	public void delete(HotelDTO dto) {
		hotelDao.delete(Assembler.fromDTO(dto));
		
	}

	@Override
	public List<HotelDTO> getAll() {
		List<HotelDTO> list = Assembler.toDTO(hotelDao.getAll());
		return list;
	}

	@Override
	public HotelDTO getById(int id) {
		return Assembler.toDTO(hotelDao.getById(id));
	}
	
	public HotelDao getHotelDao() {
		return hotelDao;
	}

	public void setHotelDao(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	@Override
	public List<HotelDTO> getByName(String name) {
		return Assembler.toDTO(hotelDao.getByName(name));
	}
	
}
