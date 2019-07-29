package ar.com.hotel.entities;

import java.io.Serializable;

public class Neutral extends Category implements Serializable {

	private static final long serialVersionUID = 1L;

	public Neutral() {
		
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
		if(value>10){
			hotel.setCategory(new Popular());
			hotel.updateCategory();
		}else {
			if (value<-10) {
				hotel.setCategory(new NonPopular());
				hotel.updateCategory();
			}
		}
	}

}
