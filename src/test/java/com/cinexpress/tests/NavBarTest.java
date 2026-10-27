package com.cinexpress.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.cinexpress.pages.CitySelectPage;
import com.cinexpress.pages.LoginPage;
import com.cinexpress.pages.NavBarPage;

public class NavBarTest {
	
	public static void main(String[] args) throws InterruptedException{
		
		String email = "cinixpress@yopmail.com";
		String passWord = "cinixpress123";
		String movie = "Vaazha";
		
		WebDriver driver = new ChromeDriver();
		try {
			driver.manage().window().maximize();
			driver.get("https://cine-xpress.vercel.app/");
			
			LoginPage loginPage = new LoginPage(driver);
			NavBarPage navBar = new NavBarPage(driver);
			
			loginPage.enterEmail("cinixpress@yopmail.com");
			loginPage.enterPassword("cinixpress123");
			loginPage.clickSignIn();
			

			
			System.out.println("Search bar displayed : " + navBar.isSearchBarDisplayed());
			navBar.enterSearch(movie);
			navBar.selectMovie();
			Thread.sleep(3000);
			navBar.ciniXperssLogo();
//			navBar.pressEnter();
			
			Thread.sleep(5000);
			System.out.println("URL after search:" + driver.getCurrentUrl());
			
		}finally {
			Thread.sleep(5000);     // 15 second
			driver.quit();
		}
	}

}
