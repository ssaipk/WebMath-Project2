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

public class MathforEveryoneandGeneralMathmodule {
	WebDriver driver;

	@BeforeClass
	public void BrowserLaunch() {
		driver = new FirefoxDriver();
	}

	@BeforeMethod
	public void urllaunch() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.webmath.com");
	}

	@Test(priority = 1, groups = "Math for everyone")
	public void verifylinksofmathforeveryone() {
		try {
			driver.findElement(By.linkText("Math for Everyone")).click();
			Thread.sleep(2000);
			List<WebElement> a = driver.findElements(By.tagName("a"));
			int size = a.size();
			for (int i = 1; i < size; i++) {
				String links = a.get(i).getText();
				System.out.println(links);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 2, groups = "Math for everyone")
	public void salepriceCalculation() {
		try {
			driver.findElement(By.linkText("Math for Everyone")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Sale price")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='param0']")).sendKeys("50");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='param1']")).sendKeys("15");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@value='Figure Cost']")).click();
			Thread.sleep(3000);
			driver.switchTo().frame("centerContentFrame");
			String actualprice = driver.findElement(By.xpath("(//tbody/tr)[3]")).getText();
			System.out.println(actualprice);
			String expectedprice = "0.850 x $50 = $42.50.";
			Assert.assertEquals(actualprice, expectedprice, "test is passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 3, groups = "Math for everyone")
	public void PowerConversion() {
		try {
			driver.findElement(By.linkText("Math for Everyone")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("power")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='param0']")).sendKeys("10");
			Thread.sleep(2000);
			WebElement unit = driver.findElement(By.xpath("//Select[@name='param1']"));
			Select selectunit = new Select(unit);
			selectunit.selectByIndex(0);
			Thread.sleep(2000);
			WebElement unit1 = driver.findElement(By.xpath("//Select[@name='param2']"));
			Select conversionunit = new Select(unit1);
			conversionunit.selectByIndex(0);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			String actualconversion = driver.findElement(By.xpath("(//font/p)[1]")).getText();
			System.out.println(actualconversion);
			String expectedconversion = "Or, as a final answer, 10 horsepower is 7460.000000 watt(s)";
			Assert.assertEquals(actualconversion, expectedconversion, "test is passed");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 4, groups = "Math for everyone")
	public void LoanCalculation() {
		try {
			driver.findElement(By.linkText("Math for Everyone")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("A loan")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("57000");
			driver.findElement(By.xpath("//input[@name='years']")).sendKeys("5");
			driver.findElement(By.xpath("//input[@name='period']")).sendKeys("12");
			driver.findElement(By.xpath("//input[@name='rate']")).sendKeys("8.70");
			driver.findElement(By.xpath("//input[@name='extra']")).sendKeys("340");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(3000);
			driver.switchTo().frame("centerContentFrame");
			String actualpayment = driver.findElement(By.xpath("(//font/blockquote)[2]")).getText();
			System.out.println(actualpayment);
			String expectedpayment = "the loan + bank's profit = $57000.00 + $9800.67 = $66800.67.";
			Assert.assertEquals(actualpayment, expectedpayment, "Test is Passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 5, groups = "Math for everyone")
	public void CostofElectricity() {
		try {
			driver.findElement(By.linkText("Math for Everyone")).click();
			driver.findElement(By.linkText("Cost of electricity")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='watts']")).sendKeys("310,670");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='time']")).sendKeys("198");
			Thread.sleep(1000);
			WebElement time = driver.findElement(By.xpath("//select[@name='tunit']"));
			Select timeunit = new Select(time);
			timeunit.selectByIndex(1);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='cost']")).sendKeys("0.5");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			String actualelectricitycost = driver.findElement(By.xpath("(//font[@size='4'])[4]")).getText();
			System.out.println(actualelectricitycost);
			String expectedelectricitycost = "3.234 kWh × $0.05f/kWh = $0.16";
			Assert.assertEquals(actualelectricitycost, expectedelectricitycost, "Test is passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 6, groups = "General Math")
	public void Verifylinksofgeneralmath() {
		try {
			driver.findElement(By.linkText("General Math")).click();
			Thread.sleep(2000);
			List<WebElement> b = driver.findElements(By.tagName("a"));
			for (int i = 0; i < b.size(); i++) {
				String links = b.get(i).getText();
				System.out.println(links);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 7, groups = "General Math")
	public void FactorCalculation() {
		try {
			driver.findElement(By.linkText("General Math")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Factor")).click();
			Thread.sleep(2000);
			WebElement option = driver.findElement(By.xpath("//select[@name='param0']"));
			Select optionselect = new Select(option);
			optionselect.selectByIndex(0);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='param1']")).sendKeys("55");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			String actualfactors = driver.findElement(By.xpath("(//font/blockquote)[1]")).getText();
			System.out.println(actualfactors);
			String expectedfactors = "-55, -11, -5, -1, 1, 5, 11, and 55.";
			Assert.assertEquals(actualfactors, expectedfactors, "test is passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 8, groups = "General Math")
	public void FractiontoDecimalCalcution() {
		try {
			driver.findElement(By.linkText("General Math")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Fraction to Decimal")).click();
			WebElement top = driver.findElement(By.xpath("//input[@name='top']"));
			top.clear();
			top.sendKeys("87");
			Thread.sleep(2000);
			WebElement bottom = driver.findElement(By.xpath("//input[@name='bottom']"));
			bottom.clear();
			bottom.sendKeys("11");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='dplaces']")).sendKeys("3");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			driver.switchTo().frame("centerContentFrame");
			String actualfraction = driver.findElement(By.xpath("(//font/p)[2]")).getText();
			System.out.println(actualfraction);
			String expectedfraction = "And that's about it! 87/11 written as a decimal to 3 decimal places is 7.909.";
			Assert.assertEquals(actualfraction, expectedfraction, "test is passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 9, groups = "General Math")
	public void Reducefractionstolowestterm() {
		try {
			driver.findElement(By.linkText("General Math")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Reduce")).click();
			Thread.sleep(2000);
			WebElement top = driver.findElement(By.xpath("//input[@name='top']"));
			top.clear();
			top.sendKeys("567");
			Thread.sleep(2000);
			WebElement bottom = driver.findElement(By.xpath("//input[@name='bottom']"));
			bottom.clear();
			bottom.sendKeys("356");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			String actualfactor = driver.findElement(By.xpath("(//font/center)[1]")).getText();
			System.out.println(actualfactor);
			String expectedfactor = "The final answer is:123 ";
			Assert.assertNotEquals(actualfactor, expectedfactor, "test is passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 10, groups = "General Math")
	public void Additionoffraction() {
		try {
			driver.findElement(By.linkText("General Math")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Add")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='atop1']")).sendKeys("45");
			driver.findElement(By.xpath("//input[@name='abottom1']")).sendKeys("12");
			driver.findElement(By.xpath("//input[@name='atop2']")).sendKeys("56");
			driver.findElement(By.xpath("//input[@name='abottom2']")).sendKeys("21");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			String actualadd = driver.findElement(By.xpath("(//font/center)[1]")).getText();
			System.out.println(actualadd);
			String expectedadd = "The final answer is: ";
			Assert.assertNotEquals(actualadd, expectedadd, "test is passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 11, groups = "General Math")
	public void clearingfilledform() {
		try {
			driver.findElement(By.linkText("General Math")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Add")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='atop1']")).sendKeys("45");
			driver.findElement(By.xpath("//input[@name='abottom1']")).sendKeys("12");
			driver.findElement(By.xpath("//input[@name='atop2']")).sendKeys("56");
			driver.findElement(By.xpath("//input[@name='abottom2']")).sendKeys("21");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='reset']")).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterClass
	public void BrowserClose() {
		driver.quit();
	}

}
