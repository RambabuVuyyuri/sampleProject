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

public class TC2_failure_test {
	
	/*
	 * Test case 2 : Ordering “Pillow”
       using Credit Card as payment method. This should be FAILED payment flow
	 */
	
	@Test
	@Parameters({"browser","url"})
	public void t_01_payment_success(String browser,String url) throws InterruptedException {
		// Creating object for BrowserManager file where is driver is initializes 
		WebDriver driver = BrowserManager.getDriver(browser,url);
		driver.get(url);
		
		/*
		 Creating Objects for Pages and calling respective methods
		 * */
		 
		HomePage page = PageFactory.initElements(driver,HomePage.class);
		page.click_buy_button();
		page.shopping_cart_checkout();
		
		OrderSummaryPage order =  PageFactory.initElements(driver,OrderSummaryPage.class);
		order.order_summary_page_continue("20,000");
		PaymentPage payment =  PageFactory.initElements(driver,PaymentPage.class);
		payment.credit_card_details_page("Credit/Debit Card","4911 1111 1111 1113", "12/21", "123");
		OTPPage otp_page =  PageFactory.initElements(driver,OTPPage.class);
		otp_page.Proceed_from_otp_validation_page("112233");
		PaymentValidation validation =  PageFactory.initElements(driver,PaymentValidation.class);
		validation.validate_failure_transaction_message("Transaction failed");
		driver.quit();
		
	}

}
