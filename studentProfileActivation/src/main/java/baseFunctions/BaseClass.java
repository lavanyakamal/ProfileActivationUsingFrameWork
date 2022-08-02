package baseFunctions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {	
    public static Properties properties=null;
	public static WebDriver driver;
	public static WebDriverWait wait;
	static int waitInSec=30;

	    public static WebElement visibilityWait(WebElement element) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(waitInSec));
		return wait.until(ExpectedConditions.visibilityOf(element));
	    }

	    public static WebElement elementClickableWait(WebElement element) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(waitInSec));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
     	}
			
		public static void scroll() {
			JavascriptExecutor executor=(JavascriptExecutor)driver;
			executor.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
		}
		
		public static void zoomOut() throws AWTException, InterruptedException {
			Robot robot=new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		
		public static Properties loadProperties() throws IOException {
			FileInputStream input=new FileInputStream("C:\\Users\\Lavanya\\eclipse-workspace\\studentProfileActivation\\src\\main\\java\\baseFunctions\\studentProfile.properties");
			properties=new Properties();
			properties.load(input);
			return properties;
		}

		public static void openBrowser_student() throws IOException {	
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lavanya\\chromedriver\\chromedriver\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://maplogik.com/index.php/student/login");
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
	//		driver.manage().deleteAllCookies();
		}
		
		public static void screenshot(String string) throws IOException,InterruptedException {
			TakesScreenshot screenshot=(TakesScreenshot)driver;
			File source=screenshot.getScreenshotAs(OutputType.FILE);
			File destination=new File("D:\\MapLogiK\\new scenario\\screenshots\\"+string+".png");
			FileHandler.copy(source,destination);
			Thread.sleep(2000);
		}

}
