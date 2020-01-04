package com.cucumber.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.baseclass.BaseClass;

public class ReservationPom extends BaseClass
{
	@FindBy(xpath="//select[@id='location']")
	private WebElement location;
	
	@FindBy(xpath="//select[@id='hotels']")
	private WebElement hotels;
	
	@FindBy(xpath="//select[@id='room_type']")
	private WebElement roomtype;
	
	@FindBy(xpath="//select[@id='room_nos']")
	private WebElement rooms;
	
	@FindBy(id="datepick_in")
	private WebElement checkin;
	
	@FindBy(id="datepick_out")
	private WebElement checkout;
	
	@FindBy(xpath="//select[@id='adult_room']")
	private WebElement adult;
	
	@FindBy(xpath="//select[@id='child_room']")
	private WebElement child;
	
	@FindBy(xpath="//input[@id='Submit']")
	private WebElement submit;
	
	@FindBy(id="checkin_span")
	private WebElement errorcheckin;
	
	@FindBy(id="checkout_span")
	private WebElement errorcheckout;
	
	@FindBy(xpath="//input[@type='radio']")
	private WebElement radio;
	
	@FindBy(id="continue")
	private WebElement contibu;

	
	public WebElement getRadio() {
		return radio;
	}

	public WebElement getContibu() {
		return contibu;
	}

	public WebElement getRoomtype() {
		return roomtype;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRooms() {
		return rooms;
	}

	public WebElement getCheckin() {
		return checkin;
	}

	public WebElement getCheckout() {
		return checkout;
	}

	public WebElement getAdult() {
		return adult;
	}

	public WebElement getChild() {
		return child;
	}

	public WebElement getSubmit() {
		return submit;
	}

	
	public WebElement getErrorcheckin() {
		return errorcheckin;
	}

	public WebElement getErrorcheckout() {
		return errorcheckout;
	}

	public ReservationPom() {
		PageFactory.initElements(driver, this);
	}
}
