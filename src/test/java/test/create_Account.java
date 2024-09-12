package test;


import org.testng.Assert;
import org.apache.logging.log4j.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.create_Account_POM;
import amazonmainclass.MainClass;

public class create_Account extends MainClass {

	create_Account_POM pom;

	public create_Account() {
		super();
	}
	

	@BeforeMethod
	public void initelement() throws InterruptedException {
		MainClass.initiation();
		pom=new create_Account_POM();
		pom.click();
		Thread.sleep(2000);
	}
    
	@ Test (priority=1,dataProviderClass=dataprovider.Dataproviderclass.class  ,dataProvider="Details")
	public void Yourname(String Condition, String name, String Email, String Password, String PasswordAgain) throws InterruptedException {
	if(Condition.equals("Invalid")) {	
		pom.typename(name);
		pom.typeemail(Email);
		pom.typepassword(Password);
		pom.typepasswordagain(PasswordAgain);
		pom.clickk();
		pom.verifyError();
		pom.verifybutton();
		}
	
	else if (Condition.equals("newcx")|| Condition.equals("Inphone")) {
		pom.typename(name);
		pom.typeemail(Email);
		pom.typepassword(Password);
		pom.typepasswordagain(PasswordAgain);
		Thread.sleep(5000);
		pom.verifybutton();
		pom.clickk();
		String CurrentURL= driver.getCurrentUrl();
		String ExpectedURL = "https://www.amazon.ca/ap/register";
		String ExpectedURL1="https://www.amazon.ca/ap/cvf/request?arb=a0ba831d-a99f-46ed-8f26-3406e84236a1";
		if(CurrentURL.equals(ExpectedURL)) {
			Assert.assertEquals(CurrentURL, ExpectedURL);	
			System.out.println(CurrentURL);
		}
		else if(CurrentURL.equals(ExpectedURL1)) {
		Assert.assertEquals(CurrentURL, ExpectedURL1);
		System.out.println(CurrentURL);

	}}
	else if(Condition.equals("Alreadyregd")) {
		pom.typename(name);
		pom.typeemail(Email);
		pom.typepassword(Password);
		pom.typepasswordagain(PasswordAgain);
		pom.clickk();
		pom.returningcx();
	}
	}
	
	
@AfterMethod
public void close() {
	driver.close();
}

	

}
