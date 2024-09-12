package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import amazonmainclass.MainClass;

public class your_Address_POM extends MainClass{

	
	@FindBy(id="nav-link-accountList") WebElement HelloDixit;
	@FindBy(xpath="//h2[contains(text(),'Your Addresses')]") WebElement Youraddress; // Get text
	// https://www.amazon.ca/a/addresses?ref_=ya_d_c_addr
	@FindBy(xpath="//*[@id=\"ya-myab-address-add-link\"]/div") WebElement Addaddress; // gettext
	//id = ya-myab-plus-address-icon //  https://www.amazon.ca/a/addresses/add?ref=ya_address_book_add_button
	@FindBy(xpath="//*[@id=\"address-ui-widgets-countryCode\"]/span/span/span") WebElement Canada;
//@FindBy(name="address-ui-widgets-countryCode") WebElement CountryDrop;
//@FindBy(xpath="//*[@id=\"address-ui-widgets-enterAddressFormContainer\"]/div[1]/div/div[1]") WebElement Canada1;	
	@FindBy(name="address-ui-widgets-enterAddressFullName") WebElement name;
@FindBy(name="address-ui-widgets-enterAddressPhoneNumber") WebElement phone;
@FindBy(name="address-ui-widgets-enterAddressLine1") WebElement address;
@FindBy(name="address-ui-widgets-enterAddressCity") WebElement City;
@FindBy(xpath="//span[contains(text(),'Province/Territory')]") WebElement Province; // Gettext
@FindBy(name="address-ui-widgets-enterAddressStateOrRegion") WebElement Pterritory;
@FindBy(id="address-ui-widgets-enterAddressPostalCode") WebElement postal;
@FindBy(id="address-ui-widgets-use-as-my-default") WebElement checkbox;
@FindBy(name="address-ui-widgets-addr-details-business-hours") WebElement delivery;
@FindBy(xpath="//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input") WebElement useaddress;
@FindBy(xpath="//*[@id=\"address-ui-widgets-enterAddressFormContainer\"]/p") WebElement radio;
@FindBy(name="address-ui-widgets-saveOriginalOrSuggestedAddress") WebElement Suggest;
@FindBy(xpath="//div[contains(text(),'Please enter a name.')]") WebElement Error1;
@FindBy(xpath="//div[contains(text(),'Please enter a phone number so we can call if there are any issues with delivery.')]") WebElement Error2;
@FindBy(xpath="//div[contains(text(),'Please enter an address.')]") WebElement Error3;
@FindBy(xpath="//*[@id=\"address-ui-widgets-enterAddressCity-full-validation-alerts\"]/div/div/div/div") WebElement Error4;;
@FindBy(xpath="//*[@id=\"address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId-full-validation-alerts\"]/div/div/div/div") WebElement Error5;
@FindBy(xpath="//div[contains(text(),'Please enter a postal code.')]") WebElement Error6;;
@FindBy(xpath="//span[contains(text(),'Default:')]") WebElement verifydefault; //gettext;
@FindBy(xpath="//p[contains(text(),\"There's a problem with the address provided - we'v\")]") WebElement saddress;
//Don't deliver on weekends
@FindBy(xpath="//h4[contains(text(),'Address saved')]") WebElement addresssaved;



public your_Address_POM() {
	PageFactory.initElements(driver, this);
}

public void Click1() throws InterruptedException {
	HelloDixit.click();
}
public void address() {
	String actual=Youraddress.getText();
	String expected= "Your Addresses";
	Assert.assertEquals(actual, expected);
	System.out.println(actual);
	Youraddress.click();
	String actualurl=driver.getCurrentUrl();
	String expectedurl="https://www.amazon.ca/a/addresses?ref_=ya_d_c_addr";
	Assert.assertEquals(actualurl, expectedurl);
	System.out.println(actualurl);
}
public void clickaddress() {
	Youraddress.click();	
}
public void aaddress() {
	String actual=Addaddress.getText();
	String expected = "Add Address";
	Assert.assertEquals(actual, expected);
	System.out.println(actual);
	Addaddress.click();
	String actualurl=driver.getCurrentUrl();
	String expectedurl="https://www.amazon.ca/a/addresses/add?ref=ya_address_book_add_button";
	Assert.assertEquals(actualurl, expectedurl);
	System.out.println(actualurl);
}
public void clickaadress() {
	Addaddress.click();	
}
public void country() throws InterruptedException {
	String actual=Canada.getText();
	String expected="Canada";
	Assert.assertEquals(actual, expected);
	System.out.println(actual);
	/*Select obj=new Select(CountryDrop);
	obj.selectByVisibleText("Canada");
	Thread.sleep(5000);
	String actual_ = Canada1.getText();
	String expected_="Canada";
	Assert.assertEquals(actual_, expected_);
	System.out.println(actual_);*/
	Thread.sleep(2000);
	//obj.selectByVisibleText("Canada");
}
public void Typename(String Name) {
	name.sendKeys(Name);
}
public void typephone(String Phone) {
	phone.sendKeys(Phone);
}
public void typeaddress(String Address) {
	address.sendKeys(Address);
}

public void typecity(String city) {
	City.sendKeys(city);
}
public void province() {
	Select obj=new Select(Pterritory);
	obj.selectByVisibleText("Nova Scotia");	
}
public void verifyprovince() {
	String actual=Province.getText();
	String expected="Province/Territory";
	Assert.assertEquals(actual, expected);
	}
public void Postalcode(String code) {
	postal.sendKeys(code);
}
public void check() {
	checkbox.click();
}
public void deliveryo() throws InterruptedException {
	Select obj= new Select(delivery);
	//obj.selectByValue("Don't deliver on weekends");
	//obj.selectByVisibleText("Don't deliver on weekends");
	Thread.sleep(2000);
	obj.selectByIndex(1);
}
public void submit() {
	useaddress.click();
}
public void click() {
radio.click();	
String actual=saddress.getText();
String expected ="There's a problem with the address provided - we've marked our suggestions in red below. Please choose or edit which version of the address you want to use.";
Assert.assertEquals(actual, expected);
System.out.println(actual);
}
public void suggested() {
	Suggest.click();
}
public void saved() {
	String actual=addresssaved.getText();
	String expected= "Address saved";
	Assert.assertEquals(actual, expected);
	System.out.println(actual);
}
public void defaultassert() {
	String actual= verifydefault.getText();
	String expected="Default:  ";
	Assert.assertEquals(actual, expected);
	System.out.println(actual);
}
public void NameError() {
	Assert.assertEquals(Error1.getText(), "Please enter a name.");
	System.out.println(Error1.getText());
	}
public void phonerror() {
	Assert.assertEquals(Error2.getText(), "Please enter a phone number so we can call if there are any issues with delivery.");	
	System.out.println(Error2.getText());
	}
public void addresserror() {
		Assert.assertEquals(Error3.getText(), "Please enter an address.");
		System.out.println(Error3.getText());
	}
public void cityerror() {
		Assert.assertEquals(Error4.getText(), "Please enter a city name.");
		System.out.println(Error4.getText());
	}

public void provinceerror() {
		Assert.assertEquals(Error5.getText(), "Please enter a province/territory.");
		System.out.println(Error5.getText());
	}

public void postalerror() {
		Assert.assertEquals(Error6.getText(), "Please enter a postal code.");
		System.out.println(Error6.getText());
	}

}
