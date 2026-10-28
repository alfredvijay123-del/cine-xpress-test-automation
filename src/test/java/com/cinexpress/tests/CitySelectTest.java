package com.cinexpress.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cinexpress.pages.CitySelectPage;
import com.cinexpress.pages.LoginPage;

public class CitySelectTest {

	public static void main(String[] args) throws InterruptedException {
		
		String cityName = "Kozhikode";
		String name     = "AlfredVijay";
		String email    = "user" + System.currentTimeMillis() + "@yopmail.com";
		String password = "KL52C1680";
		
		
		WebDriver driver = new ChromeDriver();
		try {
			driver.manage().window().maximize();
			driver.get("https://cine-xpress.vercel.app/");
			
			LoginPage loginPage = new LoginPage(driver);
			CitySelectPage cityPage = new CitySelectPage(driver);
			
			loginPage.clickSignuplinks();
			loginPage.enterName(name);
			loginPage.enterEmail(email);
			loginPage.enterPassword(password);
			loginPage.clickCreateAccount();
			
			Thread.sleep(2000);
			System.out.println("Popup displayed:" + driver.getCurrentUrl());
			cityPage.clickClose();
			Thread.sleep(3000);
//			System.out.println("Popup displayed:" + cityPage.isPopupDisplayed());
//			cityPage.clickLoadMore();
//			Thread.sleep(1500);
//			cityPage.searchCity(cityName);
//			System.out.println("City visible: " + cityPage.isCityDisplayed(cityName));
//			cityPage.selectCity(cityName);
			
			Thread.sleep(3000);
			System.out.println("URL after city select: " + driver.getCurrentUrl());
		} finally {
			driver.quit();
			
		}
				
	}
}