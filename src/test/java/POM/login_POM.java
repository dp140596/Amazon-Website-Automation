package POM;

import org.openqa.selenium.By;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import amazonmainclass.MainClass;

public class login_POM extends MainClass{

	@FindBy (xpath="//div[@id='nav-al-signin']/div//a//span[contains(text(),'Sign in')]") WebElement Signin;
    @FindBy(id="ap_email") WebElement Email;
    @FindBy (id="continue") WebElement SigninCnt;
    @FindBy(id="ap_password") WebElement password;
    @FindBy(id="signInSubmit") WebElement submit;
    //@FindBy(xpath="//input[@type='checkbox']") WebElement KeepLoggedin;
    @FindBy(xpath="//div[contains(text(),'Enter your e-mail address or mobile phone number')]") WebElement EmailError;
    @FindBy (xpath="//div[contains(text(),'Enter your password')]") WebElement Ipass;
    @FindBy(xpath="//span[contains(text(),' Your password is incorrect')]") WebElement Inpass;
    @FindBy(xpath="//*[@id=\"nav-link-accountList-nav-line-1\"]") WebElement Dixit;
 
public login_POM() {
	PageFactory.initElements(driver, this);
}

//nav-link-accountList-nav-line-1
public void Signinbutton() throws InterruptedException {
	Actions action=new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
	Thread.sleep(2000);
	
String actualresult= Signin.getText();
String expectedresult= "Sign in";
System.out.println(actualresult);
Assert.assertEquals(actualresult, expectedresult);
Signin.click();

}
public void typeemail(String name) {
	Email.sendKeys(name);
}
public void Clickbutton() {
	SigninCnt.click();
}
public void typepassword(String name) {
	password.sendKeys(name);
}
/*public void remember() {
	KeepLoggedin.click();
	
}*/
public void clicksubmit() {
	submit.click();
}
public void emailerror() {
String actualerror=EmailError.getText();
String expectederror= "Enter your e-mail address or mobile phone number";
Assert.assertEquals(actualerror, expectederror);
System.out.println(actualerror);
}

public void Loginemialerror() {
	String actualerror =driver.findElement(By.className("a-list-item")).getText();
	String expectederror="We cannot find an account with that e-mail address";
	Assert.assertEquals(actualerror, expectederror);
	System.out.println(actualerror);
}
public void Loginmobileerror() {
	String actualerror =driver.findElement(By.className("a-list-item")).getText();
	String expectederror="We cannot find an account with that mobile number";
	Assert.assertEquals(actualerror, expectederror);
	System.out.println(actualerror);
}
public void passerror() {
	String actual= Ipass.getText();
	String Expected= "Enter your password";
	Assert.assertEquals(actual, Expected);
	System.out.println(actual);
}


public void Inpasserror() {
	String actual= Inpass.getText();
	String Expected= "Your password is incorrect";
	Assert.assertEquals(actual, Expected);
	System.out.println(actual);
}


public void verifytitle() {
	String actual=driver.getTitle();
	if(actual.equals("Amazon Sign In")) {
		Assert.assertEquals(actual, "Amazon Sign In");
		System.out.println(actual);
	}
	else if (actual.equals("amazon.ca")) {
		Assert.assertEquals(actual, "Amazon.ca");	
		System.out.println(actual);
	}
	else if (actual.equals("Authentication required")) {
		Assert.assertEquals(actual, "Authentication required");
		System.out.println(actual);
	}
}
public void loggedin() {
	String actual = Dixit.getText();
	String expected = "Hello, Dixit";
	Assert.assertEquals(actual, expected);
	System.out.println(actual);
}


}
