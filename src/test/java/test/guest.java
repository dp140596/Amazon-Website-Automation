package test;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.search_POM;
import amazonmainclass.MainClass;

public class guest extends MainClass{

	search_POM log;
	public guest() {
		super();
	}
	
	@BeforeMethod
	public void initiateelement() throws InterruptedException {
		MainClass.initiation();
	log=new search_POM();
}

	@Test(priority=4,dataProviderClass=dataprovider.Dataproviderclass.class,dataProvider="Details3")
	public void searchbox(String Keywords) throws InterruptedException {
		log.search(Keywords);
		Thread.sleep(5000);
		log.assert1();	
		}

	@Test(priority=5)
	public void partialitem() throws InterruptedException {
		log.search("B0BZ5RMXFH");
		Thread.sleep(5000);
		//String actual=
	}
	@Test(priority=3)
	public void assert2() throws InterruptedException {
		log.search("adidas");
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Amazon.ca : adidas");
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		log.verifyimage();
		System.out.println("Image is Displayed");
		Thread.sleep(5000);
		log.verifyname();
		System.out.println("Name is Displayed");
		Thread.sleep(5000);
		log.verifyrating();
		System.out.println("Rating is Displayed");
		Thread.sleep(5000);
		log.verifyprice();
		System.out.println("Price is Displayed");
		Thread.sleep(5000);
		log.verifyreview();
		System.out.println("Review is Displayed");
		driver.navigate().back();
		log.navigatenext();
		Thread.sleep(5000);
		log.navigateprev();
	}
	
@AfterMethod
public void closebrowser() {	
driver.close();
}

}
