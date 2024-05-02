package Project_2.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import Project_2.AbstaractMethods.AbstractClass;


public class shippingAndPaymentMethods extends AbstractClass  {
	WebDriver driver;
	
	public shippingAndPaymentMethods(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "shippingoption_1")
	WebElement shippingOptions;
	
	@FindBy(css = "button[class='button-1 shipping-method-next-step-button']")
	WebElement shippingMethods;

	@FindBy(css = "button[class='button-1 payment-method-next-step-button']")
	WebElement paymentMethod;
	
	@FindBy(css = "button[class='button-1 payment-info-next-step-button']")
	WebElement paymentInfo;
	
	@FindBy(css = "div[class='billing-info'] strong")
	WebElement wait;
	
	
	public void shippingAndPaymentPage() {
		
		shippingOptions.click();
		shippingMethods.click();
		//check out payment methods
		paymentMethod.click();
		paymentInfo.click();
		WaitForElementToVisible(wait);
		
		
	}
	

}
