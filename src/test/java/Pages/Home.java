package Pages;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.junit.Test;

import com.factory.Base_driver;
import com.pages.config;

public class Home {
	WebDriver driver;

	Properties pro = config.getproperty();

	WebDriverWait dropdownWait = new WebDriverWait(Base_driver.driver, Duration.ofSeconds(4));

	String currenturl = "";
	String currenturl2 = "";

	By signin_button = By.xpath("(//a[contains(text(),'Sign in')])[2]");
	By Watch_demo = By.xpath("//a[contains(text(),'Watch demo')]");

	By Watch_Demo = By.xpath("//button[contains(text(),'Watch Demo')]");

	By F_Name = By.xpath("//input[@placeholder=\"First Name\"]");
	By L_Name = By.xpath("//input[@id=\"LastName\"]");
	By Email = By.xpath("//input[@class=\"mktoField mktoEmailField mktoHasWidth mktoRequired\"]");
	By C_name = By.xpath("//input[@id=\"Company\"]");
	By P_number = By.xpath("//input[@type=\"tel\"]");
	By T_units = By.xpath("//select[@id=\"Unit_Count__c\"]");
	By J_title = By.xpath("//input[@placeholder=\"Job Title\"]");
	By I_am = By.xpath("//select[@id=\"demoRequest\"]");

	public Home(WebDriver driver) {
		this.driver = driver;
	}

	public void i_navigate_to_entrata_homepage() {
		String actualtitle = Base_driver.driver.getTitle();
		System.out.println(actualtitle);
	}

	public void the_page_title_should_contain(String title) {
		String actualtitle = Base_driver.driver.getTitle();

		Assert.assertTrue(actualtitle.contains(title));
	}

	public void the_main_navigation_menu_should_contain_and(String first_navigation, String second_navigation) {
		Base_driver.driver.findElement(signin_button).click();
		currenturl = Base_driver.driver.getCurrentUrl();
		System.out.println(currenturl + "123");
		Assert.assertTrue(currenturl.contains(first_navigation));
		Base_driver.driver.navigate().back();

		Base_driver.driver.findElement(Watch_demo).click();
		currenturl2 = Base_driver.driver.getCurrentUrl();
		System.out.println(currenturl2 + "cuur 2");
		Assert.assertTrue(currenturl2.contains(second_navigation));
		Base_driver.driver.navigate().back();
	}

	public void primary_button_should_be_visible_and_clickable(String second_navigation) {

		WebElement watchdemo_button = Base_driver.driver.findElement(Watch_demo);
		if (watchdemo_button.isDisplayed()) {
			System.out.println("Button is visible");
			if (watchdemo_button.isEnabled()) {
				System.out.println("Button is clickable");
				watchdemo_button.click();
				System.out.println("Button clicked successfully");
			} else {
				System.out.println("Button is visible but not clickable");
			}
		} else {
			System.out.println("Button is not visible");
		}
	}

	public void i_am_on_watch_demo_page() {
		Base_driver.driver.findElement(Watch_demo).click();
	}

	public void watch_demo_button_is_clickable_without_interaction() {

		WebElement button = dropdownWait.until(ExpectedConditions.elementToBeClickable(Watch_Demo));
//		WebElement button = Base_driver.driver.findElement(Watch_Demo);
		// Check if the button is visible
		  Assert.assertTrue (button.isDisplayed());
		// Check if the button is enabled
		  Assert.assertTrue(button.isEnabled());
	}

	public void i_enter_all_form_field() {

		Base_driver.driver.findElement(F_Name).sendKeys(pro.getProperty("First_name"));
		Base_driver.driver.findElement(L_Name).sendKeys(pro.getProperty("Last_name"));
		Base_driver.driver.findElement(Email).sendKeys(pro.getProperty("Email_address"));
		Base_driver.driver.findElement(C_name).sendKeys(pro.getProperty("Company_Name"));
		Base_driver.driver.findElement(P_number).sendKeys(pro.getProperty("Phone_Number"));

		String total_unit = pro.getProperty("Total_unit");

		// basically is string so need to convert in integer
		int Total_unit = Integer.valueOf(total_unit);

		WebElement selectElement = Base_driver.driver.findElement(T_units);
		Select dropdown = new Select(selectElement);
		String optionValue;

		// if dyanmic value is enter then proceed with it
		// use Testing technique (use boundry value analysis)
		// if the value in between- 1-100 then select first dropdown option like this

		if (Total_unit >= 1 && Total_unit <= 100) {
			optionValue = "1 - 100";
		} else if (Total_unit >= 101 && Total_unit <= 300) {
			optionValue = "101 - 300";
		} else if (Total_unit >= 301 && Total_unit <= 2000) {
			optionValue = "301 - 2000";
		} else {
			optionValue = "2000+";
		}

		if (!optionValue.isEmpty()) {
			dropdown.selectByValue(optionValue);
			System.out.println("Selected option: " + optionValue);
		} else {
			System.out.println("No valid option selected for Total_unit: " + Total_unit);
		}

		Base_driver.driver.findElement(J_title).sendKeys(pro.getProperty("Job_title"));

		WebElement dropdownElement = dropdownWait.until(ExpectedConditions.elementToBeClickable(I_am));
		Select dropdownSelect = new Select(dropdownElement);

		List<WebElement> dropdownOptions = Base_driver.driver
				.findElements(By.xpath("//select[@id=\"demoRequest\"]/option"));
		String textstring = pro.getProperty("I_Am_text");

		for (WebElement option : dropdownOptions) {
			String optionText = option.getText().trim();
			if (optionText.contains(textstring)) {
				dropdownSelect.selectByVisibleText(optionText);
				System.out.println("optionText :" + optionText);
				break; // Exit the loop after selecting the matching option
			}
		}
		System.out.println("option is select : ");

	}

}
