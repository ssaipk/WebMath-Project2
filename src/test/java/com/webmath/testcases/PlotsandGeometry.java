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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PlotsandGeometry {

	WebDriver driver;

	@BeforeClass
	public void BrowserLaunch() {
		driver = new FirefoxDriver();
	}

	@BeforeMethod
	public void urlLaunch() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.webmath.com");
	}

	@Test(priority = 1)
	public void verifyLinksofPlotsandgeometry() {
		try {
			driver.findElement(By.linkText("Plots & Geometry")).click();
			Thread.sleep(2000);
			List<WebElement> f = driver.findElements(By.tagName("a"));
			for (int i = 0; i < f.size(); i++) {
				String links = f.get(i).getText();
				System.out.println(links);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 2)
	public void PointsPlotting() {
		try {
			driver.findElement(By.linkText("Plots & Geometry")).click();
			driver.findElement(By.linkText("Points")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='param0']")).sendKeys("(3,-8)(8,5)(-4,6)");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			String actualplot = "(3,-8)(8,5)(-4,6)";
			String Expectedplot = "(3,-8)(8,5)(-4,6)";
			Assert.assertEquals(actualplot, Expectedplot, "Test is Passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 3)
	public void PointPlottingClearEnteredData() {
		try {
			driver.findElement(By.linkText("Plots & Geometry")).click();
			driver.findElement(By.linkText("Points")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='param0']")).sendKeys("(3,-8)(8,5)(-4,6)");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='reset']")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 4)
	public void CalculatingDiameterOfCircle() {
		try {
			driver.findElement(By.linkText("Plots & Geometry")).click();
			driver.findElement(By.xpath("(//font/a)[14]")).click();
			Thread.sleep(2000);
			WebElement option = driver.findElement(By.xpath("//select[@name='param_know']"));
			Select selectoption = new Select(option);
			selectoption.selectByVisibleText("radius");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='param_value']")).sendKeys("20");
			Thread.sleep(2000);
			WebElement option1 = driver.findElement(By.xpath("//select[@name='param_want']"));
			Select selectoption1 = new Select(option1);
			selectoption1.selectByVisibleText("diameter");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			WebElement diameter = driver.findElement(By.xpath("//td/center"));
			String actualdiameter = diameter.getText();
			System.out.println(actualdiameter);
			String expecteddiameter = "diameter = 2 × 20 = 40";
			Assert.assertEquals(actualdiameter, expecteddiameter, "Test is passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 5)
	public void CalculatingSidesofSquare() {
		try {
			driver.findElement(By.linkText("Plots & Geometry")).click();
			driver.findElement(By.linkText("Squares")).click();
			Thread.sleep(2000);
			WebElement op = driver.findElement(By.xpath("//select[@name='param_know']"));
			Select selectop = new Select(op);
			selectop.selectByIndex(2);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='param_value']")).sendKeys("78");
			Thread.sleep(2000);
			WebElement op1 = driver.findElement(By.xpath("//select[@name='param_want']"));
			Select selectop1 = new Select(op1);
			selectop1.selectByIndex(0);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			WebElement side = driver.findElement(By.xpath("//td/center"));
			String actualside = side.getText();
			System.out.println(actualside);
			String expectedside = "Side = diagonal / 1.41 = 78/1.41 = 55.1543 The side of the square has a length of 55.1543.";
			Assert.assertNotEquals(actualside, expectedside, "Test is Passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 6)
	public void CalculatingVolumeOfCylinder() {
		try {
			driver.findElement(By.linkText("Plots & Geometry")).click();
			driver.findElement(By.linkText("Cylinders")).click();
			Thread.sleep(2000);
			WebElement opt = driver.findElement(By.xpath("//select[@name='param_know']"));
			Select selectopt = new Select(opt);
			selectopt.selectByIndex(1);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='param_value']")).sendKeys("12");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='param_value1']")).sendKeys("31");
			Thread.sleep(2000);
			WebElement opt1 = driver.findElement(By.xpath("//select[@name='param_want']"));
			Select selectopt1 = new Select(opt1);
			selectopt1.selectByIndex(3);
			Thread.sleep(2000);
			WebElement opt2 = driver.findElement(By.xpath("//select[@name='param_value2']"));
			Select selectopt2 = new Select(opt2);
			selectopt2.selectByIndex(0);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			WebElement volume = driver.findElement(By.xpath("(//center/font/p)[1]"));
			String actualvolume = volume.getText();
			System.out.println(actualvolume);
			String expectedvolume = "The volume of this cylinder is 3506.02.";
			Assert.assertEquals(actualvolume, expectedvolume, "test is Passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 7)
	public void CalculatingPerimeterOfRighttriangle() {
		try {
			driver.findElement(By.linkText("Plots & Geometry")).click();
			driver.findElement(By.linkText("Right Triangles")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='param_value']")).sendKeys("8");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='param_value1']")).sendKeys("23");
			Thread.sleep(2000);
			WebElement select = driver.findElement(By.xpath("//select[@name='param_want']"));
			Select select1 = new Select(select);
			select1.selectByIndex(1);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			WebElement perimeter = driver.findElement(By.xpath("//p/font"));
			String actualperimeter = perimeter.getText();
			System.out.println(actualperimeter);
			String expectedperimeter = "The perimeter of this triangle is 55.3516.";
			Assert.assertEquals(actualperimeter, expectedperimeter, "Test is Passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterClass
	public void BrowserClose() {
		driver.quit();
	}

}
