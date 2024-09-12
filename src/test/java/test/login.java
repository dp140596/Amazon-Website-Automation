package test;

import org.testng.Assert;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.login_POM;
import amazonmainclass.MainClass;

public class login extends MainClass{
	login_POM pom;
	public login() {
		super();
	}
	
	@BeforeMethod
public void openbrowser() throws InterruptedException {
 MainClass.initiation();
 pom= new login_POM();
 Thread.sleep(5000);
pom.Signinbutton();
}
	
	@Test(priority=1,dataProviderClass=dataprovider.Dataproviderclass.class,dataProvider="Details1")
	public void Login(String Condition, String Email, String Password) throws InterruptedException {
		if(Condition.equals("VEmail")||Condition.equals("Vnumber") ) {
		
		pom.typeemail(Email);
		pom.Clickbutton();
		Thread.sleep(2000);
		String actualURL = driver.getCurrentUrl();
		String expectedURL = prop.getProperty("LoginURL");
		Assert.assertEquals(actualURL, expectedURL, "Assertion Failed");
	}
		
		else if (Condition.equals("InEmail/mobile")) {
			
			pom.typeemail(Email);
			pom.Clickbutton();
			Thread.sleep(2000);
			pom.emailerror();
		}
		
		
        else if (Condition.equals("Inmobile")) {
        
			pom.typeemail(Email);
			pom.Clickbutton();	
			pom.Loginmobileerror();
		}
        else if(Condition.equals("Inemail")) {
        	
        	pom.typeemail(Email);
			pom.Clickbutton();	
			pom.Loginemialerror();	
        }
		else if (Condition.equals("Invalidpass")) {
			
			pom.typeemail(Email);
			pom.Clickbutton();	
			pom.typepassword(Password);
			//pom.remember();
			pom.clicksubmit();
			pom.passerror();
		}
		else if (Condition.equals("Incorrectpass")) {
		
		    pom.typeemail(Email);
			pom.Clickbutton();	
			pom.typepassword(Password);
			//pom.remember();
			pom.clicksubmit();
			pom.Inpasserror();
		}
		else if (Condition.equals("Vcase")) {
			
			pom.typeemail(Email);
			pom.Clickbutton();	
			pom.typepassword(Password);
			//pom.remember();
			pom.clicksubmit();
			Thread.sleep(2000);
			String CurrentURL= driver.getCurrentUrl();
			String ExpectedURL = "https://www.amazon.ca/?ref_=nav_signin&";
			String ExpectedURL1="https://www.amazon.ca/ap/cvf/request?arb=a0ba831d-a99f-46ed-8f26-3406e84236a1";
			if(CurrentURL.equals(ExpectedURL)) {
				Assert.assertEquals(CurrentURL, ExpectedURL);	
				System.out.println(CurrentURL);
			}
			else if(CurrentURL.equals(ExpectedURL1)) {
			Assert.assertEquals(CurrentURL, ExpectedURL1);
			System.out.println(CurrentURL);
		}
	
		pom.loggedin();
		driver.get("https://www.amazon.ca/");
		pom.loggedin();
		}

	}


	@AfterMethod
	public void close() {
		driver.close();
	}
	

}
