package com.cinexpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
	WebDriver driver;
	
	By signUpLink = By.linkText("Sign up");
	By namefield = By.name("name");
	By emailField = By.name("email");
	By passwordField = By.name("password");
	By eyeButton = By.cssSelector("button[type='button']");
	By signUpButton = By.xpath("//button[text()='Sign Up']");
	By signInButton = By.xpath("//button[normalize-space()='Sign In']");
	By loadMoreButton =By.xpath("//button[normalize-space()='Load More']");
	
	public LoginPage(WebDriver dreiver) {
		this.driver = dreiver;
	}
	
	public void clickSignuplinks() {
		driver.findElement(signUpLink).click();
	}
	
	public void enterName(String name) {
		driver.findElement(namefield).sendKeys(name);
	}
	
	public void enterEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickEyeButton() {
		driver.findElement(eyeButton).click();
		
	}
//	public void clickSignIn() {
//		driver.findElement(signInButton).click();
//	}
	public void clickSignup() {
		driver.findElement(signUpButton).click();
	}
	
	
	public void clickLoadMore() {
		driver.findElement(loadMoreButton).click();
	}
	
	public void clicSignupLinks() {
		driver.findElement(signUpLink).click();
		
	}
}
