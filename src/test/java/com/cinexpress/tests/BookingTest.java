package com.cinexpress.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cinexpress.pages.BookingPage;
import com.cinexpress.pages.LoginPage;

public class BookingTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String email    = "cinixpress@yopmail.com";
		String password = "cinixpress123";
		String day      = "24";
		String time     = "11:00 PM";
		String seat1    = "H7";
		String seat2    = "P18";
		
		WebDriver driver = new ChromeDriver();
		try {
			driver.manage().window().maximize();
			driver.get("https://cine-xpress.vercel.app/");

			LoginPage loginPage = new LoginPage(driver);
			BookingPage booking = new BookingPage(driver);
			
//			sign in
			loginPage.enterEmail(email);
			loginPage.enterPassword(password);
			loginPage.clickSignIn();
			Thread.sleep(4000);

//			Book Ticket
			booking.clickBookTickets();
			Thread.sleep(3000);
			System.out.println("Shows URL: " + driver.getCurrentUrl());
			
//			Selecting Date
			booking.selectDate(day);
			Thread.sleep(2000);
			
//			Selecting Time
			booking.selectShow(time);
			Thread.sleep(3000);
			System.out.println("Seat page URL: " + driver.getCurrentUrl());
			
//			Selecting Seat
//			Seat 1
			booking.selectSeat(seat1);
			Thread.sleep(1000);
//			Seat 2
			booking.selectSeat(seat2);
			Thread.sleep(2000);
			
//			Payment Portion
			booking.clickPayNow();
			Thread.sleep(5000);
			System.out.println("After Pay Now URL: " + driver.getCurrentUrl());
		} finally {
			Thread.sleep(8000);
			driver.quit();
		}
	}

}
