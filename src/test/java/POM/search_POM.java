package POM;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import amazonmainclass.MainClass;

public class search_POM extends MainClass{

	@FindBy(id="twotabsearchtextbox") WebElement Search;
	@FindBy(id="nav-search-submit-button") WebElement submit; // Optional
	@FindBy(xpath="//span[contains(text(),'adidas')]") WebElement assertelement;
	@FindBy(xpath="//img[@alt='adidas unisex-child Grand Court 2.0 Elastic Lace and Top Strap Shoes SHOES']") WebElement image1;
	@FindBy(xpath="//span[contains(text(),'unisex-child Grand Court 2.0 Elastic Lace and Top Strap Shoes SHOES')]") WebElement productname; // click
    @FindBy(xpath="//span[contains(text(),'4.6 out of 5 stars')]") WebElement rating;
    @FindBy(xpath="//span[@class='a-price']//span[contains(text(),'$62.99')]") WebElement price;
	@FindBy(xpath="//div[@id=\"averageCustomerReviews\"]//span[@id=\"acrCustomerReviewText\"]") WebElement review;
	@FindBy(linkText="Next") WebElement next;
	@FindBy(linkText="Previous") WebElement previous;
	 @FindBy(xpath="//span[@class='s-pagination-item s-pagination-selected'and@aria-label='Current page, page 2']") WebElement page2;
	 @FindBy(xpath="//span[@class='s-pagination-item s-pagination-selected'and@aria-label='Current page, page 1']") WebElement page1;
	//@FindBy(xpath="//div[@class='s-card-container s-overflow-hidden aok-relative s-expand-height s-include-content-margin s-latency-cf-section s-card-border']//span[@class='a-offscreen']") WebElement sorting;
	 
	 
	 public search_POM () {
		PageFactory.initElements(driver, this);
	}
	public void assert1() {
		String actual= assertelement.getText();
		Assert.assertTrue(actual.contains("adidas"));
		System.out.println(actual);
	}
	public void search(String name) {
		Search.sendKeys(name);
		submit.click();	;
	}
	public boolean verifyimage() {
		boolean result=image1.isDisplayed();
		return result;
		
	}
	public boolean verifyname() {
		boolean result=productname.isDisplayed();
		return result;
		
	}
	public boolean verifyrating() {
		boolean result = rating.isDisplayed();
		return result;
	}
	public boolean verifyprice() {
		boolean result= price.isDisplayed();
		return result;
	}
	public boolean verifyreview() {
		productname.click();
		boolean result=review.isDisplayed();
		return result;
	}
	public boolean navigatenext() throws InterruptedException {
		next.click();
		Thread.sleep(5000);
		boolean result=page2.isDisplayed();
	return result;
	}
	public boolean navigateprev() throws InterruptedException {
		previous.click();
		Thread.sleep(5000);
		boolean result=page1.isDisplayed();
		return result;

	}
public void items() {
	int pageitems= driver.findElements(By.xpath("//div[@class='sg-col-4-of-24 sg-col-4-of-12 s-result-item s-asin sg-col-4-of-16 sg-col s-widget-spacing-small sg-col-4-of-20']")).size();
	Assert.assertEquals(pageitems, 48);
	System.out.println(pageitems);
}
public void pagination() throws InterruptedException {
	 List<WebElement> list = driver.findElements(By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]"));
	 WebElement Nextbutton= driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
	List<String> Totalitems= new ArrayList<String>();
	 for( WebElement item:list) {	 
	 Totalitems.add(item.getText());	 
	 System.out.println(item.getText());
	 }
System.out.println("------------------>");
while(true) {
	        Thread.sleep(3000);
	        Nextbutton.click();
	        Thread.sleep(5000);
	        //base.Baseclass_amazon.Javaexecutor(2000);
	        list = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	       
	        for( WebElement item:list) {
	       
	        String Actual= item.getText();
	            Totalitems.add(Actual);
	  	   
	    //System.out.println(Totalitems.size());
	   
	    if(!(Actual.equals("Womens TIRO23 League Pants WOMENPants"))) {
	    System.out.println(Actual);
	    continue;
	    }
	    else {
	   
	    Assert.assertNotSame(Actual, "Womens TIRO23 League Pants WOMENPants", "Items can not be repeated");
	   
	    } }

	        System.out.println("------------->");
	        try {
	        Nextbutton= driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
	       
	        }
	        catch(Exception e) {
	        System.out.println("No more product left");
	        break;
	}

}}

public void sortingLTH() throws InterruptedException {

	
	List<WebElement> beforeFilter= driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	List<Double> beforefilterprice =new ArrayList<>();
	
	for(WebElement p: beforeFilter) {
		String price = (StringUtils.isEmpty(p.getText()))?"0":p.getText();
		price = price.replace("$","");
		price = price.replace(",","");
	beforefilterprice.add(Double.valueOf(price));
	//System.out.println(beforefilterprice);
	}
	Select obj=new Select(driver.findElement(By.id("s-result-sort-select")));
	obj.selectByValue("price-asc-rank");
	List<WebElement> afterFilter= driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	List<Double> afterfilterprice =new ArrayList<>();
	for(WebElement q: afterFilter) {
	//Thread.sleep(5000);
	String price1 = (StringUtils.isEmpty(q.getText()))?"0":q.getText();
	price1 = price1.replace("$","");
	price1 = price1.replace(",","");
	afterfilterprice.add(Double.valueOf(price1)) ;
	//System.out.println("Before"+ afterfilterprice);
	}
	
	//Collections.sort(afterfilterprice,Collections.reverseOrder());
	System.out.println("Before" + beforefilterprice);
	System.out.println("After" + afterfilterprice);
	Assert.assertTrue((afterfilterprice.get(0)<= beforefilterprice.get(0)),"After filter price should be always less than/equal before filter price.");
	//System.out.println("After" + afterfilterprice);
//Assert.assertNotEquals(afterfilterprice, beforefilterprice);
	
}


public void sortingHTL() throws InterruptedException {
	
	List<WebElement> beforeFilter= driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	List<Double> beforefilterprice =new ArrayList<>();
	
	for(WebElement p: beforeFilter) {
		String price = (StringUtils.isEmpty(p.getText()))?"0":p.getText();
		price = price.replace("$","");
		price = price.replace(",","");
	beforefilterprice.add(Double.valueOf(price));
	//System.out.println(beforefilterprice);
	}
	Select obj=new Select(driver.findElement(By.id("s-result-sort-select")));
	obj.selectByValue("price-desc-rank");
	List<WebElement> afterFilter= driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	List<Double> afterfilterprice =new ArrayList<>();
	for(WebElement q: afterFilter) {
	//Thread.sleep(5000);
	
	String price1 = (StringUtils.isEmpty(q.getText()))?"0":q.getText();
	price1 = price1.replace("$","");
	price1 = price1.replace(",","");
	afterfilterprice.add(Double.valueOf(price1)) ;
	//System.out.println("Before"+ afterfilterprice);
	}
	
	Collections.sort(afterfilterprice,Collections.reverseOrder());
	System.out.println("Before" + beforefilterprice);
	System.out.println("After" + afterfilterprice);
	Assert.assertTrue((afterfilterprice.get(0)>= beforefilterprice.get(0)),"After filter price should be always greater/equal than before filter price.");
//Assert.assertNotEquals(afterfilterprice, beforefilterprice);
	
}
}

