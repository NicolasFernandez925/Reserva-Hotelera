package ar.com.hotel.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ar.com.hotel.dto.HotelDTO;
import ar.com.hotel.model.HotelModel;
import ar.com.hotel.service.HotelAdminService;

public class HotelAction extends ActionSupport implements ModelDriven<HotelModel>, SessionAware {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESSLIST = "list";
	private static final String DETAIL = "detail";
	@Autowired
	private HotelAdminService hotelService;
	private Map<String, Object> session;
	private HotelModel model;
	
	public HotelAction() {
		super();
	}
		
	/**
	 * Lista los hoteles.
	 * @return LIST
	 */
	public String list() {
		List<HotelDTO> list = hotelService.getAll();
		session.put("length", list.size());
		session.put("results", list);
		return SUCCESSLIST;
	}
	
	/**
	 * Muestra el detalle de un hotel.
	 * @return DETAIL
	 */
	public String detail() {
		model.setHotel(hotelService.getById(model.getId()));
		return DETAIL;
	}
	
	/**
	 * Reserva una habitación.
	 * @return SUCCESS
	 */
	public String reserve() {
		HotelDTO h = hotelService.getById(model.getId());
		h.setReserved(true);
		hotelService.update(h);
		return SUCCESS;
	}
	
	/**
	 * Búsqueda por nombre.
	 * @return SUCCESSLIST
	 */
	public String byName() {
		List<HotelDTO> list = hotelService.getByName(model.getName());
		session.put("length", list.size());
		session.put("results", list);
		return SUCCESSLIST;
	}
	
	public HotelAdminService getHotelService() {
		return hotelService;
	}
	
	public void setHotelService(HotelAdminService hotelService) {
		this.hotelService = hotelService;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
		model = (HotelModel) session.get("HOTEL_MODEL");
		if (model == null) {
			model = new HotelModel();
			session.put("HOTEL_MODEL", model);
		}
	}
	
	public HotelModel getModel() {
		return model;
	}
	
	public void setModel(HotelModel model) {
		this.model = model;
	}
}
