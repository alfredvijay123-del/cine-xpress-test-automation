package com.cinexpress.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingPage {
	WebDriver driver;
	WebDriverWait wait;


	By bookTicketsBtn = By.xpath("//button[normalize-space()='Book Tickets']");
	By payNowBtn      = By.xpath("//button[contains(normalize-space(),'Pay Now')]");
	
	public BookingPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
//	Fixingthe date as 24
	private By dateButton(String day) {
		return By.xpath("//button[.//*[normalize-space()='" + day + "']]");
	}
	
//	Fixing the time as 11pm
	private By showButton(String time) {
		return By.xpath("//button[.//h3[normalize-space()='" + time + "']]");
	}

//	Selecting the seat is D10
	private By seatButton(String seat) {
		return By.cssSelector("button[aria-label^='Seat " + seat + "']");
	}
	

	public void clickBookTickets() {
		wait.until(ExpectedConditions.elementToBeClickable(bookTicketsBtn)).click();
	}
	
	public void selectDate(String day) {
		wait.until(ExpectedConditions.elementToBeClickable(dateButton(day))).click();
	}
	
	public void selectShow(String time) {
		WebElement show = wait.until(ExpectedConditions.visibilityOfElementLocated(showButton(time)));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", show);
		wait.until(ExpectedConditions.elementToBeClickable(show)).click();
	}
	
	public void selectSeat(String seat) {
		WebElement s = wait.until(ExpectedConditions.visibilityOfElementLocated(seatButton(seat)));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", s);
		wait.until(ExpectedConditions.elementToBeClickable(s)).click();
	}
	
	public void clickPayNow() {
		WebElement pay = wait.until(ExpectedConditions.visibilityOfElementLocated(payNowBtn));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", pay);
		wait.until(ExpectedConditions.elementToBeClickable(pay)).click();
	}
	
	
}
