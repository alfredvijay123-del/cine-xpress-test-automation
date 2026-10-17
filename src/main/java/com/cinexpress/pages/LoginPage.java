package com.cinexpress.pages;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;
	
	By signUpLink = By.linkText("Sign up");
	By namefield = By.name("name");
	By emailField = By.name("email");
	By passwordField = By.name("password");
	By eyeButton = By.cssSelector("button[type='button']");
	
	By createAccountButton  = By.xpath("//button[@type='submit' and normalize-space()='Create Account']");
	By signInButton = By.xpath("//button[normalize-space()='Sign In']");
	By loadMoreButton =By.xpath("//button[normalize-space()='Load More']");
	
	public LoginPage(WebDriver dreiver) {
		this.driver = dreiver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));}
	
		public void clickSignuplinks() {
			wait.until(ExpectedConditions.elementToBeClickable(signUpLink)).click();
		}
	
		public void enterName(String name) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(namefield)).sendKeys(name);
		}

		public void enterEmail(String email) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
		}
	
		public void enterPassword(String password) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
		}
	
		public void clickEyeButton() {
			wait.until(ExpectedConditions.elementToBeClickable(eyeButton)).click();
		}
		
	public void clickSignIn() {
		wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
	}
	
		public void clickCreateAccount() {
			wait.until(ExpectedConditions.elementToBeClickable(createAccountButton)).click();
		}
	
	public void clickLoadMore() {
		driver.findElement(loadMoreButton).click();
	}
	
	public void clicSignupLinks() {
		driver.findElement(signUpLink).click();
		
	}
}
