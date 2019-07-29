package ar.com.hotel.dto;

import java.io.Serializable;
import java.util.Date;

import ar.com.hotel.entities.Vote;

public class CommentDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String description;
	private Date date;
	private String user;
	private HotelDTO hotel;
	private Vote vote;
	
	public CommentDTO() {
		super();
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public HotelDTO getHotel() {
		return hotel;
	}
	
	public void setHotel(HotelDTO hotel) {
		this.hotel = hotel;
	}

	public Vote getVote() {
		return vote;
	}

	public void setVote(Vote vote) {
		this.vote = vote;
	}
	
}
