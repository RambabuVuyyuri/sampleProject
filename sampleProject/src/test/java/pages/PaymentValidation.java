package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

/*
 * Payment validation page to verify success/failure messages , validation page web objects and page methods
 */
public class PaymentValidation {
    
   WebDriver driver;
   public PaymentValidation(WebDriver driver) {
	   this.driver = driver;
   }
   @FindBy(how=How.XPATH,using="//div[@class='text-failed text-bold']/span")
   private WebElement trans_failure_message;
   
   @FindBy(how=How.XPATH,using="//div[@class='trans-status trans-success']/span[1]")
   private WebElement order_success_message;
 
   public void validate_order_success_message(String Expected) throws InterruptedException {
	   driver.switchTo().defaultContent();
	   Thread.sleep(500);
	   String actual_message = order_success_message.getText().trim();
	   Assert.assertEquals(actual_message, Expected, "Verifyig success message after order placement");
   }
   
   public void validate_failure_transaction_message(String Expected) throws InterruptedException {
	   
	   String actual_message = trans_failure_message.getText().trim();
	   Assert.assertEquals(actual_message, Expected, "Verifyig success message after order placement");
   }
 
}