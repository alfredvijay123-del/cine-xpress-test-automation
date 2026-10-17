package com.cinexpress.tests;

import org.openqa.selenium.By;
import com.cinexpress.pages.CitySelectPage;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cinexpress.pages.LoginPage;

public class LoginTest {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver Driver = new ChromeDriver();
				
		Driver.get("https://cine-xpress.vercel.app/");
		
		LoginPage loginpage = new LoginPage(Driver);  // Driverine LoginPage.java yilott Access cheyyunnu
		 
//		Login page(sign up)
		loginpage.clickSignuplinks(); 
		loginpage.enterName("AlfredVijay");
		loginpage.enterEmail("just19@yopmail.com");
		loginpage.enterPassword("KL52C1680");
		
		loginpage.clickEyeButton();
		Thread.sleep(2000);
		loginpage.clickEyeButton();
		
		loginpage.clickCreateAccount();          //Click Signup
		
		loginpage.clickLoadMore();     //Select city pop-up
		
		CitySelectPage citypage = new CitySelectPage(Driver);
		citypage.searchCity();
//		
//		Login page(Sign in)
		
//		loginpage.enterEmail("alfredvijay123@gmail.com");
//		loginpage.enterPassword("KL52Q2497");
//		loginpage.clickSignIn();
////	

//		Driver.findElement(By.name("email")).sendKeys("alfredvijay123@gmail.com");
//		
//		Driver.findElement(By.name("password")).sendKeys("KL52Q2497");
//		
//		Driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		
		Thread.sleep(3000);
//		Select city pop-up
//		Driver.findElement(By.xpath("//button[text()='Load More'")).click();
//		Driver.findElement(By.xpath("//button[normalize-space()='Load More']")).click();
		
//		Driver.findElement(By.cssSelector("input[placeholder='Search city...']")).sendKeys("Kochi");
//		Driver.findElement(By.cssSelector("input[placeholder='Search city...']")).click();
//
//		Driver.findElement(By.cssSelector("input[placeholder='Search city...']")).sendKeys("Kochi");
		
		Thread.sleep(3000);
		Driver.quit();
	}
}