package com.cinexpress.pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

	WebDriver driver;
	WebDriverWait wait;

	By paymentFrame  = By.cssSelector("iframe.razorpay-checkout-frame");
	By mobileField     = By.cssSelector("input[type='tel']");
	By continueButton  = By.xpath("//button[normalize-space()='Continue']");
	By walletOption  = By.cssSelector("[data-testid='wallet']");
	By netbankingOpt = By.cssSelector("[data-testid='netbanking']");
	By canaraBank = By.xpath("(//*[normalize-space(text())='Canara Bank'])[1]");
	By successButton = By.xpath("//*[(self::button or self::a or self::input) and (normalize-space()='Success' or @value='Success')]");
	
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
//	Redirect to Razorpay popup
	public void switchToPaymentFrame() {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrame));
	}
	
//	Contact details filling if they ask6555	
	public void enterContactIfAsked(String mobile) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<org.openqa.selenium.WebElement> fields = driver.findElements(mobileField);
		if (!fields.isEmpty() && fields.get(0).isDisplayed()) {
			fields.get(0).click();
			fields.get(0).sendKeys(mobile);
			wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
		}
	}
	
	public void clickWallet() {
		wait.until(ExpectedConditions.elementToBeClickable(walletOption)).click();
	}
	
	public void clickNetbanking() {
		wait.until(ExpectedConditions.elementToBeClickable(netbankingOpt)).click();
	}
	
	public void selectCanaraBank() {
		wait.until(ExpectedConditions.elementToBeClickable(canaraBank)).click();
	}
	
//	Opening new window for conform payument
	public void switchToBankWindow(String mainWindow) {
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> handles = driver.getWindowHandles();
		for (String h : handles) {
			if (!h.equals(mainWindow)) {
				driver.switchTo().window(h);
				break;
			}
		}
	}
	
	public void clickSuccess() {
		wait.until(ExpectedConditions.elementToBeClickable(successButton)).click();
	}
	
//	Redirct to main window
	public void switchToMainWindow(String mainWindow) {
		driver.switchTo().window(mainWindow);
		driver.switchTo().defaultContent();
	}
}
