package dataprovider;

import org.testng.annotations.DataProvider;


import test_Data.excell_sheet_info;

public class Dataproviderclass {

	
	@DataProvider
	public Object[][] Details(){
	Object result [][]=excell_sheet_info.readdata("Create Account");
	return result;
	}
	@DataProvider
	public Object[][] Details1(){
	Object result [][]=excell_sheet_info.readdata("Login");
	return result;
	}
	
	@DataProvider
	public Object[][] Details2(){
		Object result[][]= excell_sheet_info.readdata("Your Address");
		return result;
	}
	@DataProvider
	public Object[][] Details3(){
		return new Object[][] {{"adidas"},{"adidas shoes"},{"B0BZ5RMXFH"},{"shoes"},{"adid"},{"shoe"}};
	}
}
