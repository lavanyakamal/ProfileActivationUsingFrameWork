package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import baseFunctions.BaseClass;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {
	@AfterStep
	public void reportScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshot=((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.BYTES); 
			scenario.attach(screenshot, "image/png", "error_screen");
			BaseClass.driver.close();
		}
		else {
			byte[] screenshot=((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.BYTES); 
			scenario.attach(screenshot, "image/png", "success_screen");
			BaseClass.driver.close();
		}
		
	}
}
