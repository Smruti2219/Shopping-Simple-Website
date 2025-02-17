package smrutisamal.pageObjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import smrutisamal.AbsractClass.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy (css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy (css=".totalRow button")
	WebElement checkOut;
	
	@FindBy (css="[placeholder='Select Country']")
	WebElement countrySelected;
	
	@FindBy (xpath="//div/section/button[2]")
	WebElement dropDownElement;
	
	@FindBy (css=".action__submit")
	WebElement placeOrder;
	
	@FindBy (className="hero-primary")
	WebElement successFullText;
	
	By cartProdBy= By.cssSelector(".cartSection h3");
	
	public List<WebElement> getProductListinCart() {
		waitForElementToApprove(cartProdBy);
		return cartProducts;
	}
	public Boolean checkProductByName(String productName) { 
		
	Boolean match= getProductListinCart().stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
	return(match);
	}
	
	public void clicktheCheckOutButton() {
		
	    // Use JavaScript to click the element
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("arguments[0].click();", checkOut);
	}
	public void selectCountry(String countryName) {
		countrySelected.sendKeys(countryName);
	}
	public void dropDownElement() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("arguments[0].click();", dropDownElement);
	}
	public void checkOrderPlace() {
		JavascriptExecutor jse= (JavascriptExecutor)driver;
	    jse.executeScript("arguments[0].click();", placeOrder);
	}
	public String finalTextConfirmation() {
		String confirmation= successFullText.getText();
		return(confirmation);
	}
	
	

}
