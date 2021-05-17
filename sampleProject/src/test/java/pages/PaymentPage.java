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
 * Payment page web objects and page methods
 */
public class PaymentPage {
    
   WebDriver driver;
   
   public PaymentPage(WebDriver driver) {
	   this.driver = driver;
   }
   @FindBy(how=How.XPATH,using="//a[@href='#/credit-card']")
   private WebElement credit_card_type;

   @FindBy(how=How.XPATH,using="//p[@class='text-page-title-content']")
   private WebElement credit_page_title;
   
   @FindBy(how=How.NAME,using="cardnumber")
   private WebElement card_number;
   
   @FindBy(how=How.XPATH,using="//input[@placeholder='MM / YY']")
   private WebElement expiray_month;
   
   @FindBy(how=How.XPATH,using="//input[@placeholder='123']")
   private WebElement cvv_number;
   
   @FindBy(how=How.XPATH,using = "//div[normalize-space()='Pay Now']/span")
   private WebElement pay_now_button;
 
   public void click_credit_and_debit_card() {
	   WebDriverWait wait = new WebDriverWait(driver,20);
	   wait.until(ExpectedConditions.elementToBeClickable(credit_card_type));
	   JavascriptExecutor jse = (JavascriptExecutor)driver;
	   jse.executeScript("arguments[0].click()", credit_card_type);
	   
   }
   
   public void validate_payment_method(String method) {
	   String actual_text = credit_page_title.getText().trim();
	   Assert.assertEquals(actual_text, method, "Selected Credit card and Debit card payment method");
	   System.out.println("payment method");
   }
   
   public void enter_card_number(String number)
   {
	   card_number.click();
	   card_number.clear();
	   card_number.sendKeys(number);
   }
   public void enter_card_expiryDate(String date) {
	   expiray_month.click();
	   expiray_month.clear();
	   expiray_month.sendKeys(date);
   }
   
   public void enter_cvv_number(String CVV) {
	   cvv_number.click();
	   cvv_number.clear();
	   cvv_number.sendKeys(CVV);
	   }
   public void click_pay_now_button() {
	   WebDriverWait wait = new WebDriverWait(driver,20);
	   wait.until(ExpectedConditions.elementToBeClickable(pay_now_button));
	   JavascriptExecutor jse = (JavascriptExecutor)driver;
	   jse.executeScript("arguments[0].click()", pay_now_button);
   }
   
   public void credit_card_details_page(String Method,String number,String date,String CVV) {
	   click_credit_and_debit_card();
	   validate_payment_method(Method);
	   enter_card_number(number);
	   enter_card_expiryDate(date);
	   enter_cvv_number(CVV);
	   click_pay_now_button();
	   
   }
}
