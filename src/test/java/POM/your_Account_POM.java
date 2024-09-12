package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import amazonmainclass.MainClass;

public class your_Account_POM extends MainClass{

	@FindBy(id="nav-link-accountList") WebElement HelloDixit;
	@FindBy(xpath="//span[contains(text(),'Your Account')]") WebElement Youraccount;
	@FindBy(xpath="//h1[contains(text(),'Your Account')]") WebElement Account;

	
	public your_Account_POM() {
		PageFactory.initElements(driver, this);
	}
	
	public void mousehover() {
		Actions action= new Actions(driver);
		action.moveToElement(HelloDixit).build().perform();
		Youraccount.click();
		String actual=Account.getText();
		String expected = "Your Account";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		
	}
	public void click() {
		HelloDixit.click();
		String actual=Account.getText();
		String expected = "Your Account";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
	}

}
