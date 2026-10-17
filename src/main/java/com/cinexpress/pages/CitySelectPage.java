package com.cinexpress.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitySelectPage {
	WebDriver driver;
	WebDriverWait wait;
	
	By loadMoreButton = By.xpath("//button[normalize-space()='Load More']");
	By citySearchField = By.cssSelector("input[placeholder='Search city...']");
	
	public CitySelectPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void clickLoadMore() {
		wait.until(ExpectedConditions.elementToBeClickable(loadMoreButton)).click();
	}
	
	private By cityCard(String city) {
		return By.xpath("(//*[normalize-space()='" + city + "'])[1]");
	}
	
	public boolean isPopupDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(citySearchField)).isDisplayed();
	}
	
	public void searchCity(String city) {
		WebElement box = wait.until(ExpectedConditions.elementToBeClickable(citySearchField));
		box.click();
		box.clear();
		box.sendKeys(city);
	}
	
	public boolean isCityDisplayed(String city) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(cityCard(city))).isDisplayed();
	}
	
	public void selectCity(String city) {
		wait.until(ExpectedConditions.elementToBeClickable(cityCard(city))).click();
	}
}
