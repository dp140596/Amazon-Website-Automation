package test;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.order_POM;
import amazonmainclass.MainClass;

public class order extends MainClass {
	order_POM pom;
	public order() {
	super();
	}

	@BeforeMethod	
	public void openbrowser() throws InterruptedException {
		MainClass.initiation();
		MainClass.login();
		pom= new order_POM();
		pom.Obutton();
}
	
	@Test(priority=2)
	public void order() throws InterruptedException {
	pom.History1();
	pom.History2();
	pom.History3();
	}
	
	@Test(priority=1)
	public void order1() throws InterruptedException {
		pom.BuyaOrders();
		pom.NYSOrders();
		pom.CancelledO();
	}
	
@AfterMethod
public void closebrowser() {
	driver.close();
}

}
