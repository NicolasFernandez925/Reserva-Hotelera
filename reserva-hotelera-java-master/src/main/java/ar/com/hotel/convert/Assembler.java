package ar.com.hotel.convert;

import java.util.ArrayList;
import java.util.List;

import ar.com.hotel.dto.HotelDTO;
import ar.com.hotel.entities.Hotel;

public class Assembler {

	public static Hotel fromDTO(HotelDTO dto) {
		Hotel h = new Hotel();
		h.setId(dto.getId());
		h.setName(dto.getName());
		h.setPrice(dto.getPrice());
		h.setDescription(dto.getDescription());
		h.setReserved(dto.isReserved());
		h.setLocation(dto.getLocation());
		h.setStars(dto.getStars());
		h.setCategory(dto.getCategory());
		return h;
	}
	
	public static HotelDTO toDTO(Hotel hotel) {
		HotelDTO dto = new HotelDTO();
		dto.setId(hotel.getId());
		dto.setName(hotel.getName());
		dto.setStars(hotel.getStars());
		dto.setLocation(hotel.getLocation());
		dto.setPrice(hotel.getPrice());
		dto.setDescription(hotel.getDescription());
		dto.setReserved(hotel.isReserved());
		dto.setCategory(hotel.getCategory());
		dto.setImg(hotel.getName().substring(0, 3).toLowerCase());
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= 3; i++) {
			list.add("../resources/img/" + dto.getImg() + i + ".jpg");
		}
		dto.setImages(list);
		return dto;
	}

	public static List<HotelDTO> toDTO(List<Hotel> list) {
		List<HotelDTO> dto = new ArrayList<HotelDTO>();
		for (Hotel hotel : list) {
			dto.add(Assembler.toDTO(hotel));
		}
		return dto;
	}
	
}
