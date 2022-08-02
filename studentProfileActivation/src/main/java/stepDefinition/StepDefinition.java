package stepDefinition;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import baseFunctions.BaseClass;
import io.cucumber.java.en.Given;
import pageFactory.profileActivationObjects;
import pageFactory.studentLoginObjects;

public class StepDefinition extends BaseClass {
	@Test
	@Given("each student logs into student login with valid {string} and {string} does payment to activate their profile")
	public void loginAndProfileActivation(String uname,String pword) throws IOException, InterruptedException, AWTException {
		openBrowser_student();
		studentLoginObjects login=new studentLoginObjects(driver);
		login.stuentLogin(uname,pword);
		try {
			profileActivationObjects activation=new profileActivationObjects(driver);
			activation.activateProfile();
		    screenshot("successfully registered "+uname);
		    System.out.println(uname+" profile activated successfully");
		}
		catch(Exception e){
			screenshot("already registered "+uname);
			System.out.println(e);
			Assert.fail("oops!!! "+uname+" profile already activated");		
		}
	}
}
