package com.cinexpress.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyBookingPage {

	WebDriver driver;
	WebDriverWait wait;
	
	By FirstBookingCard = By.cssSelector("div.cursor-pointer.rounded-3xl");
	By confirmedStatus = By.xpath("//*[contains(normalize-space(),'CONFIRMED')]");
	By importantNotice  = By.xpath("//*[contains(normalize-space(),'Important Notice')]");
	
	public  MyBookingPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public  boolean isBookingDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(FirstBookingCard)).isDisplayed();
		
	}
	
	public  boolean isBookingConfirmed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmedStatus)).isDisplayed();
	}
	
	public void clickFirstBooking() {
		WebElement card = wait.until(ExpectedConditions.visibilityOfElementLocated(FirstBookingCard));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", card);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", card);
	}
		
	public boolean isNoticeDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(importantNotice)).isDisplayed();
	}
	}

