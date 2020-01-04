package com.cucumber.helper;
import com.cucumber.pom.BookingPom;
import com.cucumber.pom.HomepagePom;
import com.cucumber.pom.ReservationPom;

public class POM_Manager {
	private HomepagePom login;
	private ReservationPom reserveTheRoom;
	private BookingPom bookNow;
	
	public  HomepagePom adactinLogin() 
	{
		if (login==null) 
		{
			login =new HomepagePom();	
		}
		return login;
	}
	public ReservationPom reserveTheRoom() {
		if (reserveTheRoom==null) 
		{
			reserveTheRoom=new ReservationPom();
		}
		return reserveTheRoom;
		
	}
	 public BookingPom bookRoom() {
		 if (bookNow==null) {
			 bookNow=new BookingPom();
		}
		 return bookNow;
	}
	
}
