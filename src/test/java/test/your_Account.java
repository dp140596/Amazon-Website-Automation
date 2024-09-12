package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.login_POM;
import POM.your_Account_POM;
import amazonmainclass.MainClass;

public class your_Account extends MainClass{
	login_POM pom;
	your_Account_POM log;
		public your_Account() {
			super();
		}
		
		@BeforeMethod
		public void initiateelement() throws InterruptedException {
			MainClass.initiation();
			MainClass.login();
			pom= new login_POM();
			log = new your_Account_POM();
		}
		@Test(priority=1)
		public void Yaccount() {
			pom.loggedin();
			log.mousehover();
		
		}
		@Test(priority=2)
		public void account() {
			pom.loggedin();
			log.click();
		}
		
		@AfterMethod
		public void close() {
			driver.close();
		}

}
