package com.webmath.testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Webmathhomepage {
	WebDriver driver;

	@BeforeClass
	public void BrowserLaunch() {
		driver = new FirefoxDriver();
	}

	@Test(priority = 1)
	public void Webmathurllaunch() {
		try {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.webmath.com");
			Thread.sleep(2000);
			String actualtitle = driver.getTitle();
			String expectedtitle = "WebMath - Solve Your Math Problem";
			Assert.assertEquals(actualtitle, expectedtitle, "Webmath application url is launch successfully");
			System.out.println(actualtitle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 2)
	public void VerifyWebmathOptions() {
		try {
			driver.get("https://www.webmath.com");
			// verifying home option
			driver.findElement(By.linkText("Home")).click();
			Thread.sleep(2000);
			// verifying Math for everyone option
			driver.findElement(By.linkText("Math for Everyone")).click();
			Thread.sleep(2000);
			// verifying General math option
			driver.findElement(By.linkText("General Math")).click();
			Thread.sleep(2000);
			// verifying k-8 math option
			driver.findElement(By.linkText("K-8 Math")).click();
			Thread.sleep(2000);
			// verifying algebra option
			driver.findElement(By.linkText("Algebra")).click();
			Thread.sleep(2000);
			// verifying plots & geometry option
			driver.findElement(By.linkText("Plots & Geometry")).click();
			Thread.sleep(2000);
			// verifying trig. & calculas option
			driver.findElement(By.linkText("Trig. & Calculus")).click();
			Thread.sleep(2000);
			// verifying other option
			driver.findElement(By.linkText("Other Stuff")).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Test(priority = 3)
	public void verifydropdownoptions() {
		try {
			// verifying all options present in dropdown
			driver.findElement(By.linkText("Home")).click();
			WebElement topicItem = driver.findElement(By.id("topicItem"));
			Select topicItemSelect = new Select(topicItem);
			Thread.sleep(2000);
			List<WebElement> options = topicItemSelect.getOptions();
			for (int i = 0; i < options.size(); i++) {
				options.get(i).getText();
				System.out.println(options.get(i).getText());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterClass
	public void BrowserClose() {
		driver.quit();
	}

}
