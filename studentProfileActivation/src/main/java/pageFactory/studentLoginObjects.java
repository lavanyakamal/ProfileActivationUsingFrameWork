package pageFactory;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseFunctions.BaseClass;

public class studentLoginObjects {
	public studentLoginObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login-student-id")
	public WebElement studentid;
	
	public void userName(String username) {
		studentid.sendKeys(username);
	}
	
	@FindBy(id="login-mobile")
	public WebElement passWord;
	
	public void passWord(String password) {
		passWord.sendKeys(password);
	}	
	
	@FindBy(xpath="//*[text()='Log in']")
	public WebElement log_in;
	
	public void loginButton() {
		log_in.click();
	}		
	
	@FindBy(xpath="//*[@id='test_otp']")
	public WebElement otp_read;
	
	public String otpRead() {
		return BaseClass.visibilityWait(otp_read).getText();
	}		
	
	@FindBy(id="login-otp")
	public WebElement otp_write;
	
	public void otpWrite() {
		BaseClass.visibilityWait(otp_write).sendKeys(otpRead());
	}		
	
	@FindBy(xpath="//*[text()='Submit']")
	public WebElement submit;
	
	public void submitButton() {
		BaseClass.elementClickableWait(submit).click();
	}		
	
	public void stuentLogin(String username,String password) throws IOException, InterruptedException, AWTException {    
	    studentid.sendKeys(username);
	    passWord.sendKeys(password);
	    log_in.click();
	    otpWrite();
	    submitButton();    
	}
}
