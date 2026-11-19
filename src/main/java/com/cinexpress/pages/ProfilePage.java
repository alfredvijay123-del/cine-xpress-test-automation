package com.cinexpress.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

	WebDriver driver;
	WebDriverWait wait;
	
	public ProfilePage (WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// TODO Auto-generated method stub
	
	}

}
