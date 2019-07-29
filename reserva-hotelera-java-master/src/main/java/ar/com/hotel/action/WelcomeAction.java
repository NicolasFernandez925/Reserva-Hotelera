package ar.com.hotel.action;

import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	public String welcome() {
		return "welcome";
	}

}
