package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
 
		features = "./src/test/resources/Feature/home.feature",
		glue = {"stepdef" ,"Hooks"},
		plugin = {"pretty" , "html:testoutput/test-report"},
		monochrome = true
		)
 

public class run {

}
