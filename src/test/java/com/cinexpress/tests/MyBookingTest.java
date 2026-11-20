package com.cinexpress.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cinexpress.pages.LoginPage;
import com.cinexpress.pages.MyBookingPage;
import com.cinexpress.pages.NavBarPage;
import com.cinexpress.pages.ProfilePage;

public class MyBookingTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String email    = "cinixpress@yopmail.com";
		String password = "cinixpress123";

		WebDriver driver = new ChromeDriver();
		
		try {
			driver.manage().window().maximize();
			driver.get("https://cine-xpress.vercel.app/");
			
			LoginPage loginPage = new LoginPage(driver);
			NavBarPage navBar = new NavBarPage(driver);
			ProfilePage profile = new ProfilePage(driver);
			MyBookingPage bookings = new MyBookingPage(driver);
			
			loginPage.enterEmail(email);
			loginPage.enterPassword(password);
			loginPage.clickSignIn();
			Thread.sleep(4000);
			
			navBar.clickProfile();
			Thread.sleep(2000);
			profile.clickMyBookings();
			Thread.sleep(3000);
			System.out.println("Bookings URL: " + driver.getCurrentUrl());
			
			System.out.println("Booking displayed: " + bookings.isBookingDisplayed());
			System.out.println("Booking confirmed: " + bookings.isBookingConfirmed());
			
			bookings.clickFirstBooking();
			Thread.sleep(3000);
			String url = driver.getCurrentUrl();
			System.out.println("After card click URL: " + url());
			System.out.println(url.contains("booking-success")
					? "PASS: booking details opened"
					: "FAIL: booking details did not open");
			System.out.println("Notice displayed: " + bookings.isNoticeDisplayed());
			
	
			navBar.clickProfile();
			Thread.sleep(2000);
			profile.clickLogout();
			Thread.sleep(3000);
			System.out.println("After logout URL: " + driver.getCurrentUrl());
			
			
		} finally {
			Thread.sleep(4000);
			driver.quit();
		}
	}

	private static String url() {
		// TODO Auto-generated method stub
		return null;
	}
}
