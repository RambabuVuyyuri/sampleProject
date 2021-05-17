package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

/*
 *  Home Page objects and Methods
 */
public class HomePage {
    
   WebDriver driver;
   public HomePage(WebDriver driver) {
	   this.driver = driver;
   }
   @FindBy(how=How.XPATH,using="//a[@class='btn buy']")
   private WebElement buy_button;
   
   @FindBy(how=How.XPATH,using="//div[@class='cart-head']/span")
   private WebElement shopping_cart_name;
   
   @FindBy(how=How.CLASS_NAME,using="cart-checkout")
   private WebElement cart_checkout_button;
   
 
   public void click_buy_button() throws InterruptedException 
   {
	   Thread.sleep(100);
	   buy_button.click();
	   Reporter.log("sdfdg");
       }
   public void shopping_cart_checkout() {
	   WebElement cart_element = new WebDriverWait(driver,10)
		        .until(ExpectedConditions.elementToBeClickable(cart_checkout_button));
	   
	   String Actual_text = shopping_cart_name.getText();
	   String Expected_text = "Shopping Cart";
	   Assert.assertEquals(Expected_text, Actual_text.trim());
	   cart_element.click();
	   

   }
}
