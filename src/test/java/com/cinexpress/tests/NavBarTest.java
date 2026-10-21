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
			
//			CitySelectPage cityPage = new CitySelectPage(driver);
//			cityPage.clickLoadMore();
//			Thread.sleep(1500);
//			cityPage.selectCity("Kozhikode");
//			cityPage.selectCity(movie);  // search box-il "Kozhikode" type cheyyunnu
//			cityPage.selectCity("Kozhikode");  //list-il vanna Kozhikode card-il click cheyyunnu
//			Thread.sleep(3000);
			
			System.out.println("Search bar displayed : " + navBar.isSearchBarDisplayed());
			navBar.enterSearch(movie);
			navBar.selectMovie();
//			navBar.pressEnter();
			
			Thread.sleep(5000);
			System.out.println("URL after search:" + driver.getCurrentUrl());
			
		}finally {
			Thread.sleep(15000);     // 15 second
			driver.quit();
		}
	}

}
