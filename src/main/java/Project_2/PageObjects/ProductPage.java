package Project_2.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Project_2.AbstaractMethods.AbstractClass;
	

public class ProductPage extends AbstractClass {
	WebDriver driver;
	String ProductName = "Leica T Mirrorless Digital Camera";
	
	public ProductPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "input[class = 'search-box-text ui-autocomplete-input']")
	WebElement search;
	
	@FindBy(css = "li[class='ui-menu-item']")
	List<WebElement> products;
	

	By getProduct = By.cssSelector("a[class='ui-menu-item-wrapper'] span");
	//By productTir = By.cssSelector("a[class='ui-menu-item-wrapper'] span");
	
	public WebElement getProductByName(String ProductName) {
		WebElement prod = products.stream().filter(product->
		product.findElement(getProduct).getText()
		.equals(ProductName)).findFirst().orElse(null);
		return prod;
	}
			

	public void ProductSearch() {
		
		search.sendKeys("Cam");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement prod = getProductByName(ProductName);
		prod.findElement(getProduct).click();
	}
	

}
