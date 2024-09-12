package test;


import org.testng.annotations.AfterMethod;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.cart_POM;
import amazonmainclass.MainClass;

public class cart extends MainClass {
	cart_POM pom;
	public cart() {
		super();
	}
	
	
	@BeforeMethod
	public void initiateelement() throws InterruptedException {
		MainClass.initiation();
		MainClass.login();
	pom= new cart_POM();
}
	@Test (priority=1)
	public void search() {
		pom.search("alchemist");
		pom.alclick();
		pom.add();
		pom.clickc();
		pom.clickk();
	}
	@Test (priority=2)
	public void  cart() throws Exception {
		pom.clickc();
		pom.clickk();
		pom.quantity();
		pom.search("rado");
		pom.clickr();
		pom.add();
		pom.clickc();
		pom.verify();
		pom.deleterado();
		pom.deleteall();
	

	}
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}

}
