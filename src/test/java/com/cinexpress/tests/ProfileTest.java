package com.cinexpress.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cinexpress.pages.LoginPage;
import com.cinexpress.pages.NavBarPage;
import com.cinexpress.pages.ProfilePage;

public class ProfileTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String email = "cinixpress@yopmail.com";
		String password = "cinixpress123";
		String newName = "CiniXpress Test";
		String phone = "9048671615";
		
		WebDriver driver = new ChromeDriver();
		try {
			driver.manage().window().maximize();
			driver.get("https://cine-xpress.vercel.app/");
			
			LoginPage loginPage = new LoginPage(driver);
			NavBarPage navBarPage = new NavBarPage(driver);
			ProfilePage profile = new ProfilePage(driver);
			
			
			loginPage.enterEmail("cinixpress@yopmail.com");
			loginPage.enterPassword("cinixpress123");
			loginPage.clickSignIn();
			Thread.sleep(4000);
			
			navBarPage.clickProfile();
			Thread.sleep(2000);
			System.out.println("Profile URL: " + driver.getCurrentUrl());
			
			profile.clickBackHome();
			Thread.sleep(2000);
			System.out.println("Home URL: " + driver.getCurrentUrl());
			
			
			navBarPage.clickProfile();
			Thread.sleep(3000);
			
			profile.changeName(newName);
			profile.enterPhone(phone);
			Thread.sleep(2000);
			
//			String imgPath = "C:\\Users\\ALFRED\\Pictures\\CAR\\IMG-20261025-WA0064.jpg";
//			profile.uploadProfileImg(imgPath);
//			Thread.sleep(2000);
//			
			profile.clickSaveChanges();
			
			profile.clickMyBookings();
			Thread.sleep(2000);
			System.out.println("Booking URL: " + driver.getCurrentUrl());
			Thread.sleep(5000);
			navBarPage.ciniXperssLogo();
			Thread.sleep(2000);
			
			navBarPage.clickProfile();
			Thread.sleep(2000);
			
			profile.clickLogout();
			Thread.sleep(2000);
			System.out.println("After logout URL: " + driver.getCurrentUrl());
			
			Thread.sleep(3000);
			System.out.println("Saved URL: " + driver.getCurrentUrl());
			
		}finally {
			Thread.sleep(4000);
			driver.quit();
		}  
	}

}
