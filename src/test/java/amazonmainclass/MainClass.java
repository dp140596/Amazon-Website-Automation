package amazonmainclass;

import java.io.FileInputStream;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Utilize.time;

public class MainClass {

	public static Properties prop=new Properties();// to use method from Config.prperties
	public static WebDriver driver;

	//Step 1: Create constructor
	public MainClass() {
		try {
		FileInputStream file=new FileInputStream("C:\\Users\\dixit\\eclipse-workspace\\Amazon\\src\\test\\java\\properties\\properties.properties");
		prop.load(file);
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
		catch(IOException a) {
			a.printStackTrace();
		}
	}
		//Step 2 Create  method under which we will store all common commands which all child classes will be using
		
		public static void initiation() throws InterruptedException {
		//Browser independent
			
		String browsername=prop.getProperty("Browser");   // Using if_else for using either of "Chrome" or "Firefox" driver
		if(browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
			driver=new FirefoxDriver();
		}
			else if(browsername.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				
				driver=new ChromeDriver();
		}
		driver.manage().window().maximize();                                         //maximize window
	driver.manage().timeouts().pageLoadTimeout(time.Timeunit,TimeUnit.SECONDS);      // pageload and time out
		driver.get(prop.getProperty("Url"));                                         // Getting URL
		driver.manage().timeouts().implicitlyWait(time.Timeunit,TimeUnit.SECONDS);   // Implicitly wait time
		Thread.sleep(2000);
		driver.manage().deleteAllCookies(); // Clear all Cookies
}
		
public static void login() throws InterruptedException {
	Actions action=new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath(prop.getProperty("Hello")))).build().perform();
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("Signin"))).click();
	driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys(prop.getProperty("Username"));
	driver.findElement(By.id(prop.getProperty("Button"))).click();
	driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys(prop.getProperty("Password"));
	driver.findElement(By.id(prop.getProperty("submit"))).click();
	Thread.sleep(5000);
}

}


