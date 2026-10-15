package com.cinexpress.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cinexpress.pages.CitySelectPage;

public class CitySelectTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		CitySelectPage cityPage = new CitySelectPage(driver);
		
		cityPage.searchCity();
		cityPage.closeButton();
	}
}