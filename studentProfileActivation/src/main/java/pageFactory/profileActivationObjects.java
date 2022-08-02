package pageFactory;

import java.awt.AWTException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseFunctions.BaseClass;

public class profileActivationObjects {
	public profileActivationObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()='Activate your Account']")
	public WebElement activate_account;
	
	public void accountActivatonButton() {
		BaseClass.elementClickableWait(activate_account).click();
	}
	
	@FindBy(xpath="//*[@id='rzp-button1']")
	public WebElement pay_now;
	
	public void payNowButton() {
		Actions action=new Actions(BaseClass.driver);
		action.moveToElement(BaseClass.elementClickableWait(pay_now)).click().build().perform();
	}
	
	@FindBy(xpath="//*[@method='netbanking']")//iframe
	public WebElement payment;
	
	public void netBankingButton() {
		BaseClass.elementClickableWait(payment).click();
	}	
	
	@FindBy(id="bank-item-ICIC")//iframe
	public WebElement icici;
	
	public void iciciButton() {
		BaseClass.elementClickableWait(icici).click();
	}	
	
	@FindBy(xpath="//*[text()='Pay ₹ 100'][2]")//iframe
	public WebElement pay;
	
	public void payButton() {
		BaseClass.elementClickableWait(pay).click();
	}	
	
	@FindBy(xpath="//*[text()='Success']")//new window
	public WebElement success;
	
	public void successButton() {
		BaseClass.elementClickableWait(success).click();
	}	
	
	@FindBy(xpath="//*[text()='Dashboards']")
	public WebElement dashboard;
	
	public void dashboardButton() {
		BaseClass.elementClickableWait(dashboard).click();
	}
	
	public void activateProfile() throws InterruptedException, AWTException {	
		Thread.sleep(2000);
		BaseClass.zoomOut();
		String current_window=BaseClass.driver.getWindowHandle();		
		BaseClass.scroll();
		Thread.sleep(2000);
		payNowButton();
		Thread.sleep(2000);
		BaseClass.driver.switchTo().frame(0);
		Thread.sleep(2000);
		BaseClass.scroll();
		Thread.sleep(2000);
		netBankingButton();
		iciciButton();
		payButton();
		Thread.sleep(2000);
		Set<String> windows=BaseClass.driver.getWindowHandles();   
		for(String new_window:windows) {
		if(!windows.equals(current_window)) {
			BaseClass.driver.switchTo().window(new_window);
		}
		}		
		Thread.sleep(2000);
	//	successButton();
		Thread.sleep(1000);
		BaseClass.driver.switchTo().window(current_window);
		BaseClass.driver.switchTo().defaultContent();
		Thread.sleep(2000);		
	//	dashboardButton();
	//	Thread.sleep(2000);		
	}
}
