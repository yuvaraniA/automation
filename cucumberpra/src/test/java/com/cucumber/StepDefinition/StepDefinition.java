package com.cucumber.StepDefinition;

import org.openqa.selenium.WebDriver;

import com.cucumber.TestRunner.TestRunner;
import com.cucumber.baseclass.BaseClass;
import com.cucumber.helper.ConfigurationReader;
import com.cucumber.helper.POM_Manager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends BaseClass {
	public static WebDriver driver = TestRunner.driver;
	public static POM_Manager po = new POM_Manager();

	@Given("^User Launch the Hotel Application$")
	public void user_Launch_the_Hotel_Application() throws Throwable {
		ConfigurationReader cr=new ConfigurationReader();
		getUrl("https://www.adactin.com/HotelApp/");
	}

	@When("^User Enter The \"([^\"]*)\" in UserName Field$")
	public void user_Enter_The_in_UserName_Field(String arg1) throws Throwable {
		inputValuestoElement(po.adactinLogin().getUsername(), arg1);
	}

	@When("^User Enter The \"([^\"]*)\" in Password Field$")
	public void user_Enter_The_in_Password_Field(String arg1) throws Throwable {
		inputValuestoElement(po.adactinLogin().getPassword(), arg1);
	}

	@When("^User click the Login button$")
	public void user_click_the_Login_button() throws Throwable {
		clickOntheElement(po.adactinLogin().getLogin());
	}

	@When("^User select the Location to book hotel$")
	public void user_select_the_Location_to_book_hotel() throws Throwable {
		DropDown(po.reserveTheRoom().getLocation(), "visibletext", "Sydney");
	}

	@When("^User Select the Hotel to book$")
	public void user_Select_the_Hotel_to_book() throws Throwable {
		DropDown(po.reserveTheRoom().getHotels(), "visibletext", "Hotel Creek");
	}

	@When("^User Select the Room Type to book$")
	public void user_Select_the_Room_Type_to_book() throws Throwable {
		DropDown(po.reserveTheRoom().getRoomtype(), "visibletext", "Standard");
	}

	@When("^User Select the Number of Rooms to book$")
	public void user_Select_the_Number_of_Rooms_to_book() throws Throwable {
		DropDown(po.reserveTheRoom().getRooms(), "visibletext", "1 - One");
	}

	@When("^User Select the \"([^\"]*)\" Check-in to book$")
	public void user_Select_the_Check_in_to_book(String arg1) throws Throwable {
		inputValuestoElement(po.reserveTheRoom().getCheckin(), arg1);
	}

	@When("^User Select the \"([^\"]*)\" Check-out to book$")
	public void user_Select_the_Check_out_to_book(String arg1) throws Throwable {
		inputValuestoElement(po.reserveTheRoom().getCheckout(), arg1);
	}

	@When("^User Select the number of Adults$")
	public void user_Select_the_number_of_Adults() throws Throwable {
		DropDown(po.reserveTheRoom().getAdult(), "visibletext", "1 - One");
	}

	@When("^User Select the number of children$")
	public void user_Select_the_number_of_children() throws Throwable {
		DropDown(po.reserveTheRoom().getChild(), "visibletext", "- Select Children per Room -");
	}

	@When("^User Search the hotel to book$")
	public void user_Search_the_hotel_to_book() throws Throwable {
		clickOntheElement(po.reserveTheRoom().getSubmit());
	}

	@Then("^User verify the error message Check-in date should not be later than check-out  date$")
	public void user_verify_the_error_message_Check_in_date_should_not_be_later_than_check_out_date() throws Throwable {
		try {
			if (po.reserveTheRoom().getErrorcheckin().isDisplayed()) {
				System.out.println(po.reserveTheRoom().getErrorcheckin().getText());
			}

		} catch (Exception e) {

			System.out.println("your have done booking");
		}
	}

	/*@Then("^User choose the selected room to book$")
	public void user_choose_the_selected_room_to_book() throws Throwable {
		try {
			if (po.reserveTheRoom().getRadio().isEnabled()) {
				clickOntheElement(po.reserveTheRoom().getRadio());
			}
		} catch (Exception e) {
			System.out.println("radio button is not enabled");
		}

	}

	@Then("^User Click continue button$")
	public void user_Click_continue_button() throws Throwable {
		try {
			if (po.reserveTheRoom().getContibu().isEnabled()) {
				clickOntheElement(po.reserveTheRoom().getContibu());
			}
		} catch (Exception e) {
			System.out.println("continue button is not present");
		}

	}*/

	@Then("^User Verify the Location Displayed is same as hotel search form$")
	public void user_Verify_the_Location_Displayed_is_same_as_hotel_search_form() throws Throwable {
		highlightElement(po.bookRoom().getLocationdis());
		if (po.bookRoom().getLocationdis().getAttribute("value").equalsIgnoreCase("Sydney")) {
			System.out.println("Both locations are same");
		}else {
			System.out.println("Location is Wrong");
		}
	}

	@Then("^User verify the number of days booked is same as hotel search form$")
	public void user_verify_the_number_of_days_booked_is_same_as_hotel_search_form() throws Throwable {
		highlightElement(po.bookRoom().getCheckindatedis());
		if (po.bookRoom().getCheckindatedis().getAttribute("value").equalsIgnoreCase("20/02/2020")) {
			System.out.println("check-in date is corrcet what User books");
		}
		highlightElement(po.bookRoom().getCheckoutdatedis());
		if (po.bookRoom().getCheckoutdatedis().getAttribute("value").equalsIgnoreCase("22/02/2020")) {
			System.out.println("check-out date is corrcet what User books");
		}else {
			System.out.println("Total days are incorrect");
		}
	}

	@Then("^User Verify the number of rooms booked is same as hotel search form$")
	public void user_Verify_the_number_of_rooms_booked_is_same_as_hotel_search_form() throws Throwable {
		highlightElement(po.bookRoom().getNumberofRooms());
		if (po.bookRoom().getNumberofRooms().getAttribute("Value").equalsIgnoreCase("1 Rooms")) {
			System.out.println("Number of Rooms are correct");
		}else {
			System.out.println("Total Rooms are incorrect");
		}
	}

	@Then("^User Verify the Room Type is same or nor$")
	public void user_Verify_the_Room_Type_is_same_or_nor() throws Throwable {
	highlightElement(po.bookRoom().getRoomtypeDis());
	if (po.bookRoom().getRoomtypeDis().getAttribute("value").equalsIgnoreCase("Standard")) {
		System.out.println("the room type is same as given by user");
	}else {
		System.out.println("The room type is not same");
	}
	}

	@Then("^User Verify the Total Price is same or not$")
	public void user_Verify_the_Total_Price_is_same_or_not() throws Throwable {
		int pricepernight = getValuesText(po.bookRoom().getPricepernightDis());
		int noofrooms = getValuesText(po.bookRoom().getNumberofRooms());
		int noofDays = getValuesText(po.bookRoom().getCheckindatedis());
		int Total=pricepernight*noofrooms*noofDays;
		System.out.println("Total price is: "+Total);
	}

	@When("^User close the Browser$")
	public void user_close_the_Browser() throws Throwable {

	}

}
