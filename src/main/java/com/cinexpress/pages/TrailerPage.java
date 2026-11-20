package com.cinexpress.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrailerPage {

	WebDriver driver;
	WebDriverWait wait;

	By watchTrailerBtn = By.xpath("//button[contains(normalize-space(),'Watch Trailer')]");
	By trailerFrame    = By.cssSelector("iframe[title='Movie Trailer']");
	By playOverlay     = By.xpath("//*[@id='player-control-overlay']/div/div[1]/div[1]");
	By fullscreenBtn   = By.cssSelector("button.fullscreen-icon");
	By backToMovie     = By.xpath("//a[contains(normalize-space(),'Back to Movie')]");


	
	public TrailerPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void clickWatchTrailer() {
		wait.until(ExpectedConditions.elementToBeClickable(watchTrailerBtn)).click();
	}
	
	public void clickPlay() {
		WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(trailerFrame));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", frame);
		new Actions(driver).moveToElement(frame).click().perform();
	}
	
	public void clickFullscreen() {
		driver.switchTo().defaultContent();
		WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(trailerFrame));
		new Actions(driver).moveToElement(frame).perform();
	
		try {
			Thread.sleep(800);
			driver.switchTo().frame(frame);
			wait.until(ExpectedConditions.elementToBeClickable(fullscreenBtn)).click();
		} catch (Exception e) {
			
			try {
				driver.switchTo().frame(frame);
			} catch (Exception ignore) { }
			driver.findElement(By.tagName("body")).sendKeys("f");
		} finally {
			driver.switchTo().defaultContent();
		}
	}
	

	public void clickBackToMovie() {		
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.elementToBeClickable(backToMovie)).click();
	}
}
	
//		}
//		}
//	public void switchToTrailerFrame() {
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(trailerFrame));
//	}
//	
//	public void switchToMainPage() {
//		driver.switchTo().defaultContent();
//	}
//	
//	public void clickPlay() {
//		wait.until(ExpectedConditions.elementToBeClickable(playOverlay)).click();
//	}
//	
//	public void clickFullscreen() {
//		wait.until(ExpectedConditions.elementToBeClickable(fullscreenBtn)).click();
//	}
//	
//	public void clickBackToMovie() {
//		wait.until(ExpectedConditions.elementToBeClickable(backToMovie)).click();
//	}
//}

