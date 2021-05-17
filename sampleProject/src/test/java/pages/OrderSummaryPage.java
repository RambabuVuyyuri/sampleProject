package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/*
 * Order Summary Page objects and page methods
 */
public class OrderSummaryPage {
    
   WebDriver driver;
   public OrderSummaryPage(WebDriver driver) {
	   this.driver = driver;
   }
   @FindBy(how=How.ID,using="snap-midtrans")
   private WebElement frame_id;

   @FindBy(how=How.XPATH,using="//span[@class='text-amount-amount']")
   private WebElement order_amount;
   
   @FindBy(how=How.XPATH,using="//div[@class='text-button-main']/span")
   private WebElement order_continue;
 
   public void swith_to_frame()
   {
	   //WebDriverWait wait=new WebDriverWait(driver, 20);
	   //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame_id));
	   driver.switchTo().frame("snap-midtrans");
   }
   public void Validate_amount(String Expected) {
	   String actual_amount = order_amount.getText();
	   Assert.assertEquals(actual_amount.trim(),Expected, "Order amount check");
	   System.out.println("Assertion success");
   }
   public void click_continue() {
	   WebDriverWait wait=new WebDriverWait(driver, 20);
	   wait.until(ExpectedConditions.elementToBeClickable(order_continue));
	   JavascriptExecutor jse = (JavascriptExecutor)driver;
	   jse.executeScript("arguments[0].click()", order_continue);
   }
   public void order_summary_page_continue(String value) {
	   swith_to_frame();
	   Validate_amount(value);
	   click_continue();
   }
	   
   
}
