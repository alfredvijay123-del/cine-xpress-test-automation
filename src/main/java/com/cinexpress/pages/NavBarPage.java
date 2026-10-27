package com.cinexpress.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavBarPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	By searchField = By.cssSelector("input[placeholder='Search movies...']");
	
	By firstMovieResult = By.cssSelector("div.absolute.overflow-y-auto div.cursor-pointer");
	
	By ciniXpressButton = By.cssSelector("header div.shrink-0.cursor-pointer");
	
	public NavBarPage (WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public boolean isSearchBarDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(searchField)).isDisplayed();
	}
	
	public void enterSearch(String movie) {
		WebElement box = wait.until(ExpectedConditions.elementToBeClickable(searchField));
		box.click();
		box.sendKeys(movie);
	}
	
//	public void pressEnter() {
//		driver.findElement(searchField).sendKeys(Keys.ENTER);
//		
//	}
	public void selectMovie() {
		wait.until(ExpectedConditions.elementToBeClickable(firstMovieResult)).click();
	}
	
	public void ciniXperssLogo() {
		wait.until(ExpectedConditions.elementToBeClickable(ciniXpressButton)).click();
	}
	}

