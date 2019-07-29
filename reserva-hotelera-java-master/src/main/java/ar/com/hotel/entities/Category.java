package ar.com.hotel.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private List<Benefit> benefits = new ArrayList<Benefit>();

	public abstract void update(Hotel hotel);

	public void addBenefit(Benefit benefit) {
		if (!this.getBenefits().contains(benefit)) {
			this.getBenefits().add(benefit);
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Benefit> getBenefits() {
		return benefits;
	}

	public void setBenefits(List<Benefit> benefits) {
		this.benefits = benefits;
	}
	
}
