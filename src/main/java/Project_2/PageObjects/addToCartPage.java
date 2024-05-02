package Project_2.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Project_2.AbstaractMethods.AbstractClass;


public class addToCartPage extends AbstractClass {
	WebDriver driver;
	
	public addToCartPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "add-to-cart-button-16")
	WebElement addToCart;
	
	@FindBy(className = "content")
	WebElement waitFor;
	
	@FindBy(className="ico-cart")
	WebElement move;
	
	@FindBy(css="button[class='button-1 cart-button']")
	WebElement gotoCart;
	
	public void goToCart() {
		
		addToCart.click();
		WaitForElementToVisible(waitFor);
		Actions act = new Actions(driver);
		act.moveToElement(move).build().perform();
		gotoCart.click();
		
		
	}
	

}
