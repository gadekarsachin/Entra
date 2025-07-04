package Hooks;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.factory.Base_driver;
import com.pages.config;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApplicationHooks {

	WebDriver driver;
	Base_driver basedriver = new Base_driver();

	Properties pro = config.getproperty();
	By x_mark = By.xpath("//button[@class=\" osano-cm-dialog__close osano-cm-close \"]");

	@Before
	public void launch_browser() {
		basedriver.initializationDriver(pro.getProperty("browser"));
		Base_driver.driver.get(pro.getProperty("weburl"));
		Base_driver.driver.findElement(x_mark).click();
		System.out.println("mark is trigger...");
	}

	@After
	public void close() {
		Base_driver.driver.close();
	}

}
