package Project_2.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import Project_2.AbstaractMethods.AbstractClass;


public class confirmOrderAndConfirmationPage extends AbstractClass  {
	WebDriver driver;
	
	public confirmOrderAndConfirmationPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "button[class='button-1 confirm-order-next-step-button']")
	WebElement confirmorder;
	
	@FindBy(xpath = "//strong[normalize-space()='Your order has been successfully processed!']")
	WebElement confirmText;

	@FindBy(css = "button[class='button-1 order-completed-continue-button']")
	WebElement orderConfirmed;

	public String getString() {
		String cnfrm_Message = confirmText.getText();
		return cnfrm_Message;
		
	}
	
	public void Confirm() {
		confirmorder.click();
	}
	
	public void ConfirmationOfOrder() {
		
		orderConfirmed.click();
	}
	
	

}
