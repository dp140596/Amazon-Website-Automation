package POM;

import org.openqa.selenium.By;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import amazonmainclass.MainClass;

public class create_Account_POM extends MainClass{
	
@FindBy(linkText="Start here.") WebElement button;
@FindBy(id="ap_customer_name") WebElement yourname;
@FindBy(id="ap_email") WebElement email;
@FindBy(id="ap_password") WebElement password;
@FindBy(id="ap_password_check") WebElement passwordagain;
@FindBy(id="continue") WebElement cntbutton;
@FindBy(xpath ="//div[contains(text(),'Enter your name')]") WebElement Error1;
@FindBy(xpath ="//div[contains(text(),'Enter your e-mail address or mobile phone number')]") WebElement Error2;
@FindBy(xpath ="//div[contains(text(),'Minimum 6 characters required')]") WebElement Error3;
@FindBy(xpath ="//div[contains(text(),'Passwords do not match')]") WebElement Error4;
@FindBy(xpath ="//div[contains(text(),'Type your password again')]") WebElement Error5;
@FindBy(xpath ="//div[contains(text(),'Wrong or invalid e-mail address or mobile phone number. Please correct it and try again.')]") WebElement Error6;
@FindBy(xpath = "//span[@id='auth-continue-announce']//span[text()='Continue']") WebElement Continue;
@FindBy(xpath= "//span[@id='auth-continue-announce']//span[text()='Verify mobile number']") WebElement mnumber;
@FindBy(xpath= "//span[@id='auth-continue-announce']//span[text()='Verify email']") WebElement Email;
@FindBy(xpath="//span[@id='auth-continue-announce']/span") WebElement Buttons;
@FindBy(xpath="//*[@id=\"register-mase-inlineerror\"]/div/div") WebElement returning;


public create_Account_POM() {
	PageFactory.initElements(driver, this);
}

public void click() {
	Actions action=new Actions(driver);
	action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
	button.click();
}
public void typename(String name) {
	yourname.sendKeys(name);
}
public void typeemail(String name) {
	email.sendKeys(name);
}
public void typepassword(String name) {
password.sendKeys(name);	
}

public void typepasswordagain(String name) {
	passwordagain.sendKeys(name);
}

public void clickk() {
	cntbutton.click();
	
}

public void verifyError() {
	if(Error1.getText().equals("Enter your name")) {
		Assert.assertEquals(Error1.getText(), "Enter your name");
		System.out.println(Error1.getText());
	}
	else if(Error2.getText().equals("Enter your e-mail address or mobile phone number")) {
		Assert.assertEquals(Error2.getText(), "Enter your e-mail address or mobile phone number");
		System.out.println(Error2.getText());
	
}
	else if(Error3.getText().equals("Minimum 6 characters required")) {
		Assert.assertEquals(Error3.getText(), "Minimum 6 characters required");
		System.out.println(Error3.getText());
	
}
	else if(Error4.getText().equals("Passwords do not match")) {
		Assert.assertEquals(Error4.getText(), "Passwords do not match");
		System.out.println(Error4.getText());
	
}
	else if(Error5.getText().equals("Type your password again")) {
		Assert.assertEquals(Error5.getText(), "Type your password again");
		System.out.println(Error5.getText());
	
}
	else if(Error6.getText().equals("Wrong or invalid e-mail address or mobile phone number. Please correct it and try again.")) {
		Assert.assertEquals(Error6.getText(), "Wrong or invalid e-mail address or mobile phone number. Please correct it and try again.");
		System.out.println(Error6.getText());
}}

public void verifybutton() {
	if (mnumber.getText().equals("Verify mobile number")) {
		Assert.assertEquals(mnumber.getText(), "Verify mobile number", "Test failed");
		System.out.println(mnumber.getText());
		
	}
	else if (Email.getText().equals("Verify email")) {
			Assert.assertEquals(Email.getText(), "Verify email","Test Failed");
			System.out.println(Email.getText());	
		}
	else if (Continue.getText().equals("Continue")) {
		Assert.assertEquals(Continue.getText(), "Continue","Test Failed");
		System.out.println(Continue.getText());
	}
	}
public void returningcx() {
	String actual=returning.getText();
	String expected = "There is already an account with this email. Sign in or learn more.";
	Assert.assertEquals(actual, expected);
	System.out.println(actual);
	
}

}
