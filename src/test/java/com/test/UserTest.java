package com.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.page.UserPage;

import resources.Base;

public class UserTest extends Base {
	public WebDriver driver;
	UserPage u;

	@BeforeSuite
	public void InjectDriver() throws InterruptedException, IOException {
//		System.setProperty("webdriver.chrome.driver", "D:\\Testing Projects\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.get("file:///D:/website/Offline%20Website/index.html");
		driver = getDriver();	
		navigateUrl();
		u = new UserPage(driver);
	}

	@Test()
	public void validateAddUserPageTitle() {
		try {
			Assert.assertTrue(u.navigateToDashboard());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void validateAddUserTest() throws InterruptedException {
		Assert.assertEquals("User Added Successfully. You can not see added user.", u.validateAdduser());
	}

	@Test(priority = 2)
	public void countStateTest() {
		Assert.assertTrue(u.countStateTest());
	}

	
//	@AfterTest
//	public void closeDriver() {
//		driver.close();
//	}
}
