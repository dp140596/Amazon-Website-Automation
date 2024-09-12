package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import amazonmainclass.MainClass;

public class login_and_security_POM extends MainClass {

	@FindBy(id="nav-link-accountList") WebElement HelloDixit;
	@FindBy (xpath="//h2[contains(text(),'Login & security')]") WebElement Login; // is displayed
	@FindBy(xpath="//div[normalize-space()='Dixit']")  WebElement Dixit;
	@FindBy (xpath="//*[@id=\"NAME_BUTTON\"]/span/a") WebElement Edit;
	@FindBy (name ="customerName") WebElement namebox; // clear // send keys
	@FindBy (xpath="//input[@id='cnep_1C_submit_button']") WebElement button;
	@FindBy (xpath ="//*[@id=\"SUCCESS_MESSAGES\"]/div/div") WebElement Success;
	@FindBy (xpath="//*[@id=\"NAME_SUBTITLE\"]") WebElement text;
	@FindBy (xpath="//*[@id=\"MOBILE_NUMBER_BUTTON\"]/span/a") WebElement button2;
	@FindBy (id="MOBILE_NUMBER_BUTTON") WebElement button6;
	@FindBy (name="newMobilePhoneNumber") WebElement add; // send keyys
	@FindBy (xpath="//input[@id='auth-continue']") WebElement button3;
	@FindBy (xpath="//*[@id=\"SUCCESS_MESSAGES\"]/div/div") WebElement text6;

	
	//Frame document.querySelector("#auth-verification-ok-announce")
	@FindBy (css="#auth-verification-ok-announce") WebElement Button4;
	@FindBy (xpath="//h4[contains(text(),'Mobile number already in use')]") WebElement Error;
	@FindBy (xpath="//a[@id='auth-account-conflict-continue-verify-url']") WebElement Yes;
	//@FindBy (xpath="//h1[contains(text(),'Verify mobile number')]") WebElement Verify;// GetText
	// Title Amazon Phone Verification
	//Update87
	@FindBy (xpath="//*[@id=\"MOBILE_NUMBER_BUTTON\"]/span/a") WebElement button5;
	@FindBy (xpath="//button[contains(text(),'Delete')]") WebElement delete;
	@FindBy (xpath="//*[@id=\"ap-remove-mobile-claim-submit-button\"]") WebElement yesdelete;
	@FindBy (xpath="//a[@id='phoneModalLink']") WebElement text2;


public login_and_security_POM() {
	PageFactory.initElements(driver, this);
}

public void Click1() throws InterruptedException {
	HelloDixit.click();
}
public void loginn() {
	boolean result =Login.isDisplayed();
	System.out.println(result);
	Login.click();
}
public void updatename() {
	//oreo.getText();
	Edit.click();
}

public void typename(String name) {
	namebox.clear();
	namebox.sendKeys(name);
}
public void Clickb() {
	button.click();
	
	String actual= Success.getText();
	String expected= "Name updated.";
	Assert.assertEquals(actual, expected);
	System.out.println(actual);
	String result= text.getText();
	Assert.assertEquals(result, "Dixitp");
	System.out.println(result);
}
public void addphone() {
	button2.click();
}
public void Typephone(String number) {
	add.sendKeys(number);
}
public void Clickbutton() {
	button3.click();

}
public void framep() throws InterruptedException {
	Button4.click();
	

		String actual1=driver.getTitle();
		String expected1= "Amazon Phone Verification";
		Assert.assertEquals(actual1, expected1);
		System.out.println(actual1);
	
}
public void deletemobile() throws InterruptedException {
	Thread.sleep(5000);
	button5.click();	
	
}
public void deletebutton() {
	delete.click();
}

public void confirmdelete() {
	yesdelete.clear();
	
}
public void verify() {
	
	String result= text6.getText();
	Assert.assertEquals(result, "Mobile number deleted.");
	System.out.println(result);
	//Login.click();
	//boolean stringg = button6.isDisplayed();
	//System.out.println(stringg);
}



}
