package Project_2.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import Project_2.AbstaractMethods.AbstractClass;


public class billingPage extends AbstractClass  {
	WebDriver driver;
	
	public billingPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement country;
	
	@FindBy(id = "BillingNewAddress_City")
	WebElement city;

	@FindBy(id = "BillingNewAddress_Address1")
	WebElement address;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement zipcode;
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phonenumber;
	
	@FindBy(css = "div[id='billing-buttons-container'] button:last-of-type")
	WebElement submit;
	
	public void billingPage() {
		
		Select s = new Select(country);
		s.selectByVisibleText("India");
		city.sendKeys("chennai");
		address.sendKeys("chennai");
		zipcode.sendKeys("60090");
		phonenumber.sendKeys("0987656734");
		submit.click();
		
		
	}
	

}
