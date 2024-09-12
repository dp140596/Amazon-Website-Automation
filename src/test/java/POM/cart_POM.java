package POM;


import org.openqa.selenium.WebElement;



import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import amazonmainclass.MainClass;

public class cart_POM extends MainClass {

	
	
	@FindBy(id="twotabsearchtextbox") WebElement Search;
	@FindBy(id="nav-search-submit-button") WebElement submit; 
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/span/div/div/div[3]/div[1]/h2/a/span") WebElement Alchemist;
	@FindBy(name="submit.add-to-cart") WebElement addtocart;
	// Amazon.ca Shopping Cart 
	@FindBy(xpath="//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/h1") WebElement added; // gettext
	@FindBy(id="nav-cart") WebElement cart;
	@FindBy(xpath="//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-mini sc-info-block']") WebElement info; // isdisplayed
	@FindBy (name="quantity") WebElement selectbox;
	@FindBy (xpath="//*[@id=\"activeCartViewForm\"]/div[3]") WebElement gettext; 
	@FindBy (xpath="/html/body/div[1]/div[1]/div[4]/div[5]/div/div[2]/div[1]/div/form/div[3]") WebElement gettext5; 


	// do twice
	// gettext for selectbox
	// search adidas
	//@FindBy (xpath="//*[@id=\"quantity\"]") WebElement selectbox1;

	@FindBy (xpath="//span[@class='a-truncate-cut'][normalize-space()='The Alchemist']") WebElement gettext2;
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/span/div/div/div[2]/div[1]/h2/a/span") WebElement rado;
	@FindBy(xpath="//body/div[@id='a-page']/div[2]/div[3]/div[4]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[4]") WebElement display2;
	
	@FindBy(xpath="//input[@value='Delete'and@aria-label='Delete Rado DiaStar Original Swiss Automatic Watch with Stainless Steel Strap, Gold, 21 (Model: R12403633)']") WebElement delete;
	// gettext
	// delete
	@FindBy(xpath="//*[@id=\"sc-active-87c1b561-3af3-4d68-a0e9-918d9b50fad6\"]/div[4]/div/div[3]/div[1]/span[2]/span") WebElement delete1;

	@FindBy(xpath="//*[@id=\"sc-active-cart\"]/div/div/div/h2") WebElement cartempty; // gettext
	// gettext

	public cart_POM() {
		PageFactory.initElements(driver, this);
	}

	public void search(String name) {
		Search.sendKeys(name);
		submit.click();	
	}

	public void alclick() {
		Alchemist.click();
	}

	public void add() {
		addtocart.click();
		String actual=driver.getTitle();
		Assert.assertEquals(actual, "Amazon.ca Shopping Cart");
		System.out.println(actual);
		 String Actualtext = added.getText();
		  Assert.assertEquals(Actualtext, "Added to Cart");
		  System.out.println(Actualtext);
	}
	public void clickc() {
		cart.click();
	}
	////// another test
	// repeat clickc
	public void clickk() {
		String actual = gettext2.getText();
		Assert.assertTrue(actual.contains("The Alchemist"));
		System.out.println(actual);
	}
	public void quantity() throws InterruptedException {
	Select obj=new Select(selectbox);
	obj.selectByVisibleText("2");
	Thread.sleep(5000);
	String actual= gettext.getText();
	Assert.assertTrue(actual.contains("Subtotal (2 items): $43.98"));
	System.out.println(actual);
	}
	// repeat search rado
	public void clickr() {
		rado.click();
		// repeat click and add
	}
	public void verify() {
		String actual = gettext.getText();
		Assert.assertTrue(actual.contains("Subtotal (3 items): $1,670.48"));
		System.out.println(actual);
	}
	public void deleterado() throws InterruptedException  {
		Select obj=new Select(selectbox);
		obj.selectByVisibleText("0 (Delete)");
		Thread.sleep(5000);	
		String actual= gettext5.getText();
	//	Assert.assertTrue(actual.contains("Subtotal (2 items):$43.98"));
		System.out.println(actual);
	}
	public void deleteall() throws InterruptedException{
	 
		//delete1.click();
		Select obj=new Select(selectbox);
		obj.selectByVisibleText("0 (Delete)");
		Thread.sleep(5000);	
		String actual= gettext.getText();
		Assert.assertTrue(actual.contains("Subtotal (0 items):"));
		System.out.println(actual);
		//boolean result = cartempty.isDisplayed();
	    System.out.println(cartempty.getText());
		
	}
	
	
}




