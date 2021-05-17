package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * OTP Page web objects and page methods 
 */
public class OTPPage {
    
   WebDriver driver;
   
   public OTPPage(WebDriver driver) {
	   this.driver = driver;
   }

   @FindBy(how=How.ID,using="PaRes")
   private WebElement otp_text_box;
   
   @FindBy(how=How.NAME,using="ok")
   private WebElement submit_button;
   
   public void switch_to_child_frame() {
	   driver.switchTo().defaultContent();
       driver.switchTo().frame("snap-midtrans").switchTo().frame(0);
   }
 
   public void enter_otp(String otp_number) throws InterruptedException {
	  WebDriverWait wait = new WebDriverWait(driver,40);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='PaRes']")));
	  otp_text_box.click();
	  otp_text_box.clear();
	  otp_text_box.sendKeys(otp_number);
   }
   public void click_continue() throws InterruptedException {
	   submit_button.click();
   }
   public void Proceed_from_otp_validation_page(String value) throws InterruptedException {
	   switch_to_child_frame();
	   enter_otp(value);
	   click_continue();
	   driver.switchTo().parentFrame();
	   
   }

	   
   
}
