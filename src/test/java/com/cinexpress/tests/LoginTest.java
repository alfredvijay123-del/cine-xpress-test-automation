package com.cinexpress.tests;

import org.openqa.selenium.By;
import com.cinexpress.pages.CitySelectPage;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cinexpress.pages.LoginPage;

public class LoginTest {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver Driver = new ChromeDriver();
				
		Driver.get("https://cine-xpress.vercel.app/");
		
		LoginPage loginpage = new LoginPage(Driver);  // Driverine LoginPage.java yilott Access cheyyunnu
		 
//		Login page(sign up)
		loginpage.clickSignuplinks(); 
		loginpage.enterName("AlfredVijay");
		loginpage.enterEmail("signup@yopmail.com");
		loginpage.enterPassword("KL52C1680");
		
		loginpage.clickEyeButton();
		Thread.sleep(2000);
		loginpage.clickEyeButton();
		
		loginpage.clickCreateAccount();  //Click Signup
//		
		
//		Login page(Sign in)
		
//		loginpage.enterEmail("cinixpress@yopmail.com");
//		loginpage.enterPassword("cinixpress123");
//		loginpage.clickSignIn();
		
		CitySelectPage citypage = new CitySelectPage(Driver);
		citypage.clickLoadMore();    //Select city pop-up
		Thread.sleep(1500);
		
//		CitySelectPage citypage = new CitySelectPage(Driver);
		citypage.searchCity("Kozhikode");
		citypage.selectCity("Kozhikode");
//		
		
		Thread.sleep(3000);
		Driver.quit();
	}
}
