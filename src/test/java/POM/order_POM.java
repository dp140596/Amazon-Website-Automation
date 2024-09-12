package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import amazonmainclass.MainClass;

public class order_POM extends MainClass {
	
	@FindBy(linkText="Your Orders") WebElement Orderbtn;
	@FindBy(xpath="//*[@id=\"time-filter\"]") WebElement Orderdd;
	@FindBy(xpath="//*[@id=\"a-autoid-1-announce\"]")WebElement History;
	@FindBy(xpath="//*[@id=\"a-page\"]/section/div/div[4]/form/label") WebElement order;
	@FindBy(linkText="Buy Again") WebElement BuyAgain;
	@FindBy(linkText="Not Yet Shipped") WebElement Notyetshipped;
	@FindBy(linkText="Cancelled Orders") WebElement Cancelled;
	@FindBy (linkText="Buy Again") WebElement Buy;
	@FindBy(xpath="//*[@id=\"ordersContainer\"]/div[1]/div") WebElement shipped;
	
	public order_POM() {
		PageFactory.initElements(driver, this);
	}
	public void Obutton() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(prop.getProperty("Hello")))).build().perform();
		Orderbtn.click();
	}
	public void History1() throws InterruptedException{
		Select obj=new Select(Orderdd);
		obj.selectByVisibleText("the past 30 days");
		String actualresult = History.getText();
		System.out.println(actualresult);
		String expectedresult = "the past 30 days";
		Assert.assertEquals(actualresult, expectedresult);
		
		Thread.sleep(2000);		
		String actual= order.getText();
		if(actual.contains("order placed")) {
		Assert.assertTrue(actual.contains("order placed"));
		System.out.println(actual);
		}
		else {
			String orders=order.getText();
			System.out.println(orders);
		}

		
	}
	
	public void History2() throws InterruptedException{
		Select obj=new Select(Orderdd);
		obj.selectByVisibleText("past 3 months");
		String actualresult1=History.getText();
		System.out.println(actualresult1);
		String expectedresult1 = "past 3 months";
		Assert.assertEquals(actualresult1, expectedresult1);
		Thread.sleep(2000);	
		String actual= order.getText();
		if(actual.contains("order placed")) {
		Assert.assertTrue(actual.contains("order placed"));
		System.out.println(actual);
		}
		else {
			String orders=order.getText();
			System.out.println(orders);
		}
	}
	
	public void History3() throws InterruptedException{
		Select obj=new Select(Orderdd);
		obj.selectByVisibleText("2024");
		String actualresult2=History.getText();
		System.out.println(actualresult2);
		String expectedresult2="2024";
		Assert.assertEquals(actualresult2, expectedresult2);
		Thread.sleep(2000);
		String actual= order.getText();
		if(actual.contains("order placed")) {
		Assert.assertTrue(actual.contains("order placed"));
		System.out.println(actual);
		}
		else {
			String orders=order.getText();
			System.out.println(orders);
		}}
	
		public void BuyaOrders() throws InterruptedException {
			Thread.sleep(5000);
			boolean verifybutton= BuyAgain.isDisplayed();
			String abc= BuyAgain.getText();
			System.out.println(abc);
			BuyAgain.click();	
			Thread.sleep(2000);
			String actual= Buy.getText();
			if(actual.contains("Buy Again")) {
			Assert.assertTrue(actual.contains("Buy Again"));
			System.out.println(actual);
			}
			else {
				System.out.println(actual);
			}}
		public void NYSOrders() throws InterruptedException {
			boolean verifybutton= Notyetshipped.isDisplayed();
			String abc= Notyetshipped.getText();
			System.out.println(abc);
			Notyetshipped.click();	
			Thread.sleep(2000);
			String actual= shipped.getText();
			if(actual.contains("Arriving")) {
			Assert.assertTrue(actual.contains("Arriving"));
			System.out.println(actual);
			}
			else {
				System.out.println(actual);
			}}

		
		public void CancelledO() throws InterruptedException {
			boolean verifybutton= Cancelled.isDisplayed();
			String abc= Cancelled.getText();
			System.out.println(abc);
			Cancelled.click();	
			Thread.sleep(2000);
			String actual= shipped.getText();
			if(actual.contains("Cancelled")) {
			Assert.assertTrue(actual.contains("Cancelled"));
			System.out.println(actual);
			}
			else {
				System.out.println(actual);
			}}


}
