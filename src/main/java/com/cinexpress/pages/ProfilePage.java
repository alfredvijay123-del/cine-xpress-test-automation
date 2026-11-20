package com.cinexpress.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

	WebDriver driver;
	WebDriverWait wait;
	
	By BackHomeButton = By.xpath("//*[@id=\"root\"]/div/div/button");
	By FullNameBox = By.xpath("//*[@id=\"name\"]");
	By PhoneField = By.cssSelector("#phone");
//	By ProfileImg = By.cssSelector("input[type='file'");
	By SaveChangesBtn = By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/form/button");
	By MyBookingBtn = By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[3]/button[1]");
	By LogoutBtn = By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[3]/button[2]");

	
	public ProfilePage (WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void clickBackHome() {
		wait.until(ExpectedConditions.elementToBeClickable(BackHomeButton)).click();
	}

	public void changeName(String name) {
		WebElement box = wait.until(ExpectedConditions.elementToBeClickable(FullNameBox));
		box.click();
		box.clear();
		box.sendKeys(name);
	}
	
	public void enterPhone(String phone) {
		WebElement box = wait.until(ExpectedConditions.elementToBeClickable(PhoneField));
		box.click();
		box.clear();
		box.sendKeys(phone);
	}
	
	
//	public void uploadProfileImg(String filePath) {
//		driver.findElement(ProfileImg).sendKeys(filePath);
//	}
	
	
	public void clickSaveChanges() {
		wait.until(ExpectedConditions.elementToBeClickable(SaveChangesBtn)).click();
	}
	
	public void clickMyBookings() {
		wait.until(ExpectedConditions.elementToBeClickable(MyBookingBtn)).click();
	}
	
	public void clickLogout() {
		wait.until(ExpectedConditions.elementToBeClickable(LogoutBtn)).click();
		
	}
}
