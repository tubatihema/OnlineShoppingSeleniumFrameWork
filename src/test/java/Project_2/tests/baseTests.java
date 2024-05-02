package Project_2.tests;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Project_2.PageObjects.LandingPage;
import Project_2.PageObjects.ProductPage;
import Project_2.PageObjects.addToCartPage;
import Project_2.PageObjects.billingPage;
import Project_2.PageObjects.confirmOrderAndConfirmationPage;
import Project_2.PageObjects.detailsPage;
import Project_2.PageObjects.shippingAndPaymentMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class baseTests {

	@Test
	public void MainPage() {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver();
		WebDriver driver = new EdgeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/");
		//login into application
		LandingPage landingPage = new LandingPage(driver);
		landingPage.login();
			
		//select the product
		ProductPage productPage = new ProductPage(driver);
		productPage.ProductSearch();
		
		//add item to cart
		addToCartPage cart = new addToCartPage(driver);
		cart.goToCart();
		
		//Details page
		detailsPage details = new detailsPage(driver);
		details.detailsPage();
		
		//check out  billing page
		billingPage billing = new billingPage(driver);
		billing.billingPage();
		
		//check out shipping method
		shippingAndPaymentMethods shipping= new shippingAndPaymentMethods(driver);
		shipping.shippingAndPaymentPage();
		//confirm order page
		confirmOrderAndConfirmationPage confirm = new confirmOrderAndConfirmationPage(driver);
		confirm.Confirm();
		String Cnfrm_String = confirm.getString();
		Assert.assertEquals(Cnfrm_String, "Your order has been successfully processed!");
		confirm.ConfirmationOfOrder();
		//log out page
		landingPage.logout();
		
		
		
		
	}

}
