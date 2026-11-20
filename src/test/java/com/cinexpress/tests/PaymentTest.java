package com.cinexpress.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cinexpress.pages.BookingPage;
import com.cinexpress.pages.LoginPage;
import com.cinexpress.pages.PaymentPage;

public class PaymentTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String email    = "cinixpress@yopmail.com";
		String password = "cinixpress123";
		String day      = "24";
		String time     = "11:00 PM";
		String seat1    = "G7";    
		String seat2    = "H18";
		String mobile = "9048671615";
		
		WebDriver driver = new ChromeDriver();
		try {
			driver.manage().window().maximize();
			driver.get("https://cine-xpress.vercel.app/");

			LoginPage loginPage = new LoginPage(driver);
			BookingPage booking = new BookingPage(driver);
			PaymentPage payment = new PaymentPage(driver);
			
//			Signin
			loginPage.enterEmail(email);
			loginPage.enterPassword(password);
			loginPage.clickSignIn();
			Thread.sleep(4000);
			
//			Steps of booking ticket
			booking.clickBookTickets();
			Thread.sleep(3000);
			booking.selectDate(day);
			Thread.sleep(2000);
			booking.selectShow(time);
			Thread.sleep(3000);
			booking.selectSeat(seat1);
			Thread.sleep(1000);
			booking.selectSeat(seat2);
			Thread.sleep(2000);
			
			String mainWindow = driver.getWindowHandle();
			booking.clickPayNow();
			Thread.sleep(4000);
			
//			Payment popup
			payment.switchToPaymentFrame();
			payment.switchToPaymentFrame();
			payment.enterContactIfAsked(mobile);      
			Thread.sleep(2000);
			payment.clickWallet();
			payment.clickWallet();
			Thread.sleep(1500);
			payment.clickNetbanking();
			Thread.sleep(2000);
			payment.selectCanaraBank();
			
//			Bank Window
			payment.switchToBankWindow(mainWindow);
			Thread.sleep(2000);
			payment.clickSuccess();
			Thread.sleep(3000);

			
//			Back to main window
			payment.switchToMainWindow(mainWindow);
			Thread.sleep(5000);
			String url = driver.getCurrentUrl();
			System.out.println("After payment URL: " + url);
			System.out.println(url.contains("booking-success")
					? "PASS: payment success, booking confirmed"
					: "CHECK: booking-success page vannilla");
		} finally {
			Thread.sleep(8000);
			driver.quit();
		}
	}

}
