package Project_2.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Project_2.AbstaractMethods.AbstractClass;


public class LandingPage extends AbstractClass  {
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className = "ico-login")
	WebElement login;
	
	@FindBy(className = "email")
	WebElement username;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(css = "button[class = 'button-1 login-button']")
	WebElement loginbutton;
	
	@FindBy(className = "ico-logout")
	WebElement logoutButton;
	
	
	
	public void login() {
		
		login.click();
		username.sendKeys("tubatihema@gmail.com");
		password.sendKeys("Asdf@1234");
		loginbutton.click();
	}
	
	public void logout() {
		
		logoutButton.click();
	}
	

}
