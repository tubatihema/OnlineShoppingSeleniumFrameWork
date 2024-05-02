package Project_2.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Project_2.AbstaractMethods.AbstractClass;


public class detailsPage extends AbstractClass  {
	WebDriver driver;
	
	public detailsPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "termsofservice")
	WebElement termsAndConditions;
	
	@FindBy(id = "checkout")
	WebElement checkOut;
	
	@FindBy(css = "div[class='section ship-to-same-address'] label")
	WebElement wait;
	
	//driver.findElement(By.id("termsofservice")).click();
	//driver.findElement(By.id("checkout")).click();
	//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class='section ship-to-same-address'] label"))));
	
	
	public void detailsPage() {
		
		termsAndConditions.click();
		checkOut.click();
		WaitForElementToVisible(wait);
		
		
	}
	

}
