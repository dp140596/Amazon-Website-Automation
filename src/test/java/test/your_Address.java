package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.your_Address_POM;
import amazonmainclass.MainClass;

public class your_Address extends MainClass{

	your_Address_POM pom;
	your_Address_POM log;
	public your_Address() {
		super();
	}
	
	@BeforeMethod
	public void initiateelement() throws InterruptedException {
		MainClass.initiation();
		MainClass.login();
		pom= new your_Address_POM();
		pom.Click1();
		log=new your_Address_POM();
		
}
@Test(priority=1)
public void verifyaddress() {
	log.address();
}
@Test(priority=2)
public void verifyaadress() throws InterruptedException {
	log.clickaddress();
	log.aaddress();

}
@Test(priority=3)
public void verifycountry() throws InterruptedException {
	log.clickaddress();
	log.clickaadress();
	log.country();
}
@Test(priority=4)
public void verifyp() throws InterruptedException {
	log.clickaddress();
	log.clickaadress();
	Thread.sleep(5000);
	log.verifyprovince();
}

	@Test(priority=5,dataProviderClass=dataprovider.Dataproviderclass.class,dataProvider="Details2")
	public void address(String Condition, String Name, String Phone,String Address,String City, String Postal) throws InterruptedException {

if(Condition.equals("Iname")) {
	
	log.clickaddress();
	log.clickaadress();
	Thread.sleep(2000);
	log.Typename(Name);
	log.typephone(Phone);
	log.typeaddress(Address);
	log.typecity(City);
	log.province();
	log.Postalcode(Postal);
	log.submit();
	Thread.sleep(2000);
log.NameError();
}
if(Condition.equals("Iphone")) {
	log.clickaddress();
	log.clickaadress();
	Thread.sleep(2000);
	log.Typename(Name);
	log.typephone(Phone);
	log.typeaddress(Address);
	log.typecity(City);
	log.province();
	log.Postalcode(Postal);
	log.submit();
	Thread.sleep(2000);
log.phonerror();
}
if(Condition.equals("Iaddress")) {
	log.clickaddress();
	log.clickaadress();
	Thread.sleep(2000);
	log.Typename(Name);
	log.typephone(Phone);
	log.typeaddress(Address);
	log.typecity(City);
	log.province();
	log.Postalcode(Postal);
	log.submit();
	Thread.sleep(2000);
log.addresserror();
}
if(Condition.equals("Icity")) {
	log.clickaddress();
	log.clickaadress();
	Thread.sleep(2000);
	log.Typename(Name);
	log.typephone(Phone);
	log.typeaddress(Address);
	log.typecity(City);
	log.province();
	log.Postalcode(Postal);
	log.submit();
	Thread.sleep(2000);
log.cityerror();
}
if(Condition.equals("Ipostal")) {
	log.clickaddress();
	log.clickaadress();
	Thread.sleep(2000);
	log.Typename(Name);
	log.typephone(Phone);
	log.typeaddress(Address);
	log.typecity(City);
	log.province();
	log.Postalcode(Postal);
	log.submit();
	Thread.sleep(2000);
log.postalerror();
}

else if(Condition.equals("Invalidpro"))	{
	log.clickaddress();
	log.clickaadress();
	Thread.sleep(2000);
	log.Typename(Name);
	log.typephone(Phone);
	log.typeaddress(Address);
	log.typecity(City);
	log.Postalcode(Postal);
	log.submit();
	Thread.sleep(2000);
log.provinceerror();
}
else if (Condition.equals("Valid")) {
	Thread.sleep(2000);
	log.clickaddress();
	log.clickaadress();
	Thread.sleep(2000);
	log.Typename(Name);
	log.typephone(Phone);
	log.typeaddress(Address);
	log.typecity(City);
	log.province();
	log.Postalcode(Postal);
	log.check();
	//log.deliveryo();
Thread.sleep(2000);
	log.submit();
	log.click();
	Thread.sleep(2000);
	log.suggested();
	Thread.sleep(5000);
	log.saved();
	Thread.sleep(2000);
	log.defaultassert();
}
	}
	

@AfterMethod
public void close() {
driver.close();
}

}
