package com.cinexpress.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cinexpress.pages.LoginPage;
import com.cinexpress.pages.TrailerPage;

public class TrailerTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String email    = "cinixpress@yopmail.com";
		String password = "cinixpress123";


		WebDriver driver = new ChromeDriver();
		try {
			driver.manage().window().maximize();
			driver.get("https://cine-xpress.vercel.app/");
			
			LoginPage loginPage = new LoginPage(driver);
			TrailerPage trailer = new TrailerPage(driver);
			
			loginPage.enterEmail(email);
			loginPage.enterPassword(password);
			loginPage.clickSignIn();
			Thread.sleep(4000);
			
			trailer.clickWatchTrailer();
			Thread.sleep(3000);
			System.out.println("Trailer URL: " + driver.getCurrentUrl());
			

			trailer.clickPlay();
			Thread.sleep(3000);
			
			trailer.clickFullscreen();		//FullScreen
			Thread.sleep(3000);
			trailer.clickFullscreen();		//FullScreen Exit
			Thread.sleep(2000);
			
			
			trailer.clickBackToMovie();
			Thread.sleep(3000);
			System.out.println("After back URL: " + driver.getCurrentUrl());
			
		} finally {
			Thread.sleep(4000);
			driver.quit();
		}
	}

}
