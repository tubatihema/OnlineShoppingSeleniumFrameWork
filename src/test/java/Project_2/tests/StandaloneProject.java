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

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class StandaloneProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver();
		WebDriver driver = new EdgeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/");
		//login into application
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.className("email")).sendKeys("tubatihema@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Asdf@1234");
		driver.findElement(By.cssSelector("button[class = 'button-1 login-button']")).click();
		
		//select the product
		driver.findElement(By.cssSelector("input[class = 'search-box-text ui-autocomplete-input']")).sendKeys("Cam");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> products = driver.findElements(By.cssSelector("li[class= 'ui-menu-item']"));
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("a[class='ui-menu-item-wrapper'] span")).getText()
		.equals("Leica T Mirrorless Digital Camera")).findFirst().orElse(null);
		prod.findElement(By.cssSelector("a[class='ui-menu-item-wrapper'] span")).click();
		//add item to cart
		driver.findElement(By.id("add-to-cart-button-16")).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("content"))));
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.className("ico-cart"))).build().perform();
		driver.findElement(By.cssSelector("button[class='button-1 cart-button']")).click();
		
		//Details page
		driver.findElement(By.id("termsofservice")).click();
		driver.findElement(By.id("checkout")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class='section ship-to-same-address'] label"))));
		//check out  billing page
		//driver.findElement(By.id("ShipToSameAddress")).click();
		WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
		Select s = new Select(country);
		s.selectByVisibleText("India");
		driver.findElement(By.id("BillingNewAddress_City")).sendKeys("chennai");
		driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("chennai");
		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("60090");
		driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("0987656734");
		driver.findElement(By.cssSelector("div[id='billing-buttons-container'] button:last-of-type")).click();
		//checkout shipping address
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class='section select-shipping-address'] label"))));
		//driver.findElement(By.cssSelector("span[id='edit-shipping-address-buttons'] button")).click();
		
		//check out shipping method
		driver.findElement(By.id("shippingoption_1")).click();
		driver.findElement(By.cssSelector("button[class='button-1 shipping-method-next-step-button']")).click();
		//check out payment methods
		driver.findElement(By.cssSelector("button[class='button-1 payment-method-next-step-button']")).click();
		driver.findElement(By.cssSelector("button[class='button-1 payment-info-next-step-button']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class='billing-info'] strong"))));
		//confirm order page
		driver.findElement(By.cssSelector("button[class='button-1 confirm-order-next-step-button']")).click();
		//order confirmed pa
		String cnfrm_Messsage = driver.findElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']")).getText();
		Assert.assertEquals(cnfrm_Messsage, "Your order has been successfully processed!");
		driver.findElement(By.cssSelector("button[class='button-1 order-completed-continue-button']")).click();
		//log out page
		driver.findElement(By.className("ico-logout")).click();
		
		
		
		
	}

}
