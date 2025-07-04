package stepdef;

import org.openqa.selenium.WebDriver;

import com.factory.Base_driver;

import Pages.Home;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class home_stepdef {
	WebDriver driver;
	Base_driver base = new Base_driver();
	Home h = new Home(Base_driver.getdriver());



	@Given("I navigate to Entrata homepage")
	public void i_navigate_to_entrata_homepage() {
		h.i_navigate_to_entrata_homepage();
	}

	@Given("the main navigation menu should contain  {string} and {string}")
	public void the_main_navigation_menu_should_contain_and(String first_navigation, String second_navigation) {
		h.the_main_navigation_menu_should_contain_and(first_navigation, second_navigation);
	}

	@Given("{string} primary button should be visible and clickable")
	public void primary_button_should_be_visible_and_clickable(String second_navigation) {
		h.primary_button_should_be_visible_and_clickable(second_navigation);
	}

	@When("I am on Watch Demo page")
	public void i_am_on_watch_demo_page() {
		h.i_am_on_watch_demo_page();
	}

	@When("I enter all form field")
	public void i_enter_all_form_field() {
		h.i_enter_all_form_field();
	}

	@Then("watch demo button is clickable without interaction")
	public void watch_demo_button_is_clickable_without_interaction() {
		h.watch_demo_button_is_clickable_without_interaction();
	}

	@Then("the page title should contain {string}")
	public void the_page_title_should_contain(String title) {
		h.the_page_title_should_contain(title);

	}

}
