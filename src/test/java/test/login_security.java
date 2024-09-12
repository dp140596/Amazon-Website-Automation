package test;


import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.login_and_security_POM;
import amazonmainclass.MainClass;

public class login_security extends MainClass {
	login_and_security_POM pom;
	login_and_security_POM log;
	public login_security() {
		super();
	}
	
	@BeforeMethod
	public void initiateelement() throws InterruptedException {
		MainClass.initiation();
		MainClass.login();
		pom= new login_and_security_POM();
		pom.Click1();
	log= new login_and_security_POM();
	log.loginn();
}
@Test(priority=3)
public void name() {
	log.updatename();
	log.typename("Dixitp");
	log.Clickb();
	
}
@Test(priority=2)
public void phone() throws InterruptedException {
	log.addphone();
	log.Typephone("5142351626");
	log.Clickbutton();
	Thread.sleep(2000);
	//driver.switchTo().frame(0);
	//driver.switchTo().frame(driver.findElement(By.id("a-popover-content-1")));
	Thread.sleep(5000);
	log.framep();
}	

	@Test(priority=1)
	public void delete() throws InterruptedException {
	log.deletemobile();
	log.deletebutton();
	//Thread.sleep(5000);
	driver.findElement(By.id("ap-remove-mobile-claim-submit-button")).click();
	log.verify();
}
	
@AfterMethod
public void closebrowser() {
	driver.close();
}

}
