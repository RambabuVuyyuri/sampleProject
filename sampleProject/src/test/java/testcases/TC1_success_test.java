package testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.OTPPage;
import pages.OrderSummaryPage;
import pages.PaymentPage;
import pages.PaymentValidation;
import utilities.BrowserManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

  /*
   *  Create an automation test script to test end to end checkout flow for purchasing
    “Pillow” using Credit Card as payment method. This should be a SUCCESSFUL
     payment flow. 
   */
public class TC1_success_test {
	
	@Test
	@Parameters({"browser","url"})
	public void t_01_payment_success(String browser,String url) throws InterruptedException {
		WebDriver driver = BrowserManager.getDriver(browser,url);
		driver.get(url);
		HomePage page = PageFactory.initElements(driver,HomePage.class);
		page.click_buy_button();
		page.shopping_cart_checkout();
		
		OrderSummaryPage order =  PageFactory.initElements(driver,OrderSummaryPage.class);
		order.order_summary_page_continue("20,000");
		PaymentPage payment =  PageFactory.initElements(driver,PaymentPage.class);
		payment.credit_card_details_page("Credit/Debit Card","4811 1111 1111 1114", "12/24", "123");
		OTPPage otp_page =  PageFactory.initElements(driver,OTPPage.class);
		otp_page.Proceed_from_otp_validation_page("112233");
		PaymentValidation validation =  PageFactory.initElements(driver,PaymentValidation.class);
		validation.validate_order_success_message("Thank you for your purchase.");
		driver.quit();
	}

}
