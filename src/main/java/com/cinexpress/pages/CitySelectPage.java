package com.cinexpress.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitySelectPage {
	WebDriver driver;
	WebDriverWait wait;
	
	By citySearchField = By.cssSelector("input[placeholder='Search city...']");
	
	public CitySelectPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void closeButton() {
		driver.findElement(citySearchField).click();
		
	}
	public void searchCity() {
		driver.findElement(citySearchField).sendKeys("Kochi");
	}
	
	
}
