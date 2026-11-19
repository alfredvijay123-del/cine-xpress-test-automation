package com.cinexpress.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cinexpress.pages.CitySelectPage;
//import com.cinexpress.pages.CitySelectPage;
import com.cinexpress.pages.LoginPage;
import com.cinexpress.pages.NavBarPage;

public class NavBarTest {
	
	public static void main(String[] args) throws InterruptedException{
		
		String email = "cinixpress@yopmail.com";
		String passWord = "cinixpress123";
		String movie = "Vaazha";
		String newCity = "Kochi";
		
		WebDriver driver = new ChromeDriver();
		try {
			driver.manage().window().maximize();
			driver.get("https://cine-xpress.vercel.app/");
			
			LoginPage loginPage = new LoginPage(driver);
			
			NavBarPage navBar = new NavBarPage(driver);
			
			CitySelectPage citypage = new CitySelectPage(driver);
			
//			Login
			loginPage.enterEmail("cinixpress@yopmail.com");
			loginPage.enterPassword("cinixpress123");
			loginPage.clickSignIn();
			Thread.sleep(3000);
			
//			citypage.clickClose();
//			Thread.sleep(1500);
			
//			Movie Searching
			System.out.println("Search bar displayed : " + navBar.isSearchBarDisplayed());
			navBar.enterSearch(movie);
			navBar.selectMovie();
			Thread.sleep(3000);
			
			navBar.ciniXperssLogo();  //Back To home page
			
			
//			Changing City
			navBar.clickCityButton();
			navBar.clickMoreCities();
			citypage.clickLoadMore();
			Thread.sleep(1500);
			citypage.searchCity("Kochi");    //city type
			citypage.selectCity("Kochi");    //city click
			
			
//			Clicking Profile
			Thread.sleep(4000);
			navBar.clickProfile();
			
			Thread.sleep(5000);
			System.out.println("URL after search:" + driver.getCurrentUrl());
			
		}finally {
			Thread.sleep(5000);     // 15 second
			driver.quit();
		}
	}

}
