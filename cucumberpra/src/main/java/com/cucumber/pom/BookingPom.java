package com.cucumber.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.baseclass.BaseClass;

public class BookingPom extends BaseClass
{
	@FindBy(id="location_0")
	private WebElement locationdis;
	
	@FindBy(id="arr_date_0")
	private WebElement checkindatedis;
	
	@FindBy(id="dep_date_0")
	private WebElement checkoutdatedis;
	
	
	@FindBy(id="rooms_0")
	private WebElement numberofRooms;
	
	@FindBy(id="room_type_0")
	private WebElement RoomtypeDis;
	
	@FindBy(id="price_night_0")
	private WebElement pricepernightDis;
	
	@FindBy(id="total_price_0")
	private WebElement totalpriceDis;

	public WebElement getCheckoutdatedis() {
		return checkoutdatedis;
	}

	public WebElement getLocationdis() {
		return locationdis;
	}

	public WebElement getCheckindatedis() {
		return checkindatedis;
	}

	public WebElement getNumberofRooms() {
		return numberofRooms;
	}

	public WebElement getRoomtypeDis() {
		return RoomtypeDis;
	}

	public WebElement getPricepernightDis() {
		return pricepernightDis;
	}

	public WebElement getTotalpriceDis() {
		return totalpriceDis;
	}
	public BookingPom() {
		PageFactory.initElements(driver, this);
	}
	
	

}
