package ar.com.hotel.entities;

import java.io.Serializable;

public class Popular extends Category implements Serializable {

	private static final long serialVersionUID = 1L;

	public Popular() {
		this.getBenefits().add(Benefit.TOP);
	}
	
	@Override
	public void update(Hotel hotel) {
		int value=0;
		for (Comment comment : hotel.getComments()) {
			switch (comment.getVote()) {
				case NEGATIVE: value--;
					break;
				case POSITIVE:value++;				
					break;
				default:
					break;
			}
		}
		if(value<=10){
			hotel.setCategory(new Neutral());
			hotel.updateCategory();
		}
	}

	
}
