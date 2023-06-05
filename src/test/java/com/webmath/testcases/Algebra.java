package com.webmath.testcases;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Algebra {

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

	@Test(priority = 1)
	public void VerifylinksofAlgebra() {
		try {
			driver.findElement(By.linkText("Algebra")).click();
			Thread.sleep(2000);
			List<WebElement> e = driver.findElements(By.tagName("a"));
			for (int i = 0; i < e.size(); i++) {
				String links = e.get(i).getText();
				System.out.println(links);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 2)
	public void somplifyingproductofalgebricexpression() {
		try {
			driver.findElement(By.linkText("Algebra")).click();
			driver.findElement(By.linkText("Products")).click();
			Thread.sleep(2000);
			WebElement expression = driver.findElement(By.xpath("//input[@name='s']"));
			expression.clear();
			Thread.sleep(2000);
			expression.sendKeys("(7z^3)(6y^3x^2)");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			WebElement product = driver.findElement(By.xpath("(//font/center)[1]"));
			String actualproduct = product.getText();
			System.out.println(actualproduct);
			String expectedproduct = "";
			Assert.assertEquals(actualproduct, expectedproduct, "test is passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 3)
	public void Solvingquadraticequationbyfactoring() {
		try {
			driver.findElement(By.linkText("Algebra")).click();
			driver.findElement(By.linkText("Solve by factoring")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='s']")).sendKeys("x^2+17x+30");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			WebElement factor = driver.findElement(By.xpath("(//font/center)[1]"));
			String actualfactor = factor.getText();
			System.out.println(actualfactor);
			String expectedfactor = "";
			Assert.assertEquals(actualfactor, expectedfactor, "Test is Passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 4)
	public void Substractionofcomplexnumber() {
		try {
			driver.findElement(By.linkText("Algebra")).click();
			driver.findElement(By.linkText("Subtract")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='s']")).sendKeys("(4i-7)-(9+3i)");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			WebElement substraction = driver.findElement(By.xpath("(//font/center)[1]"));
			String actualsubstraction = substraction.getText();
			System.out.println(actualsubstraction);
			String expectedsubstraction = "i-16";
			Assert.assertEquals(actualsubstraction, expectedsubstraction, "Test is Passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 5)
	public void PercentsCalculation() {
		try {
			driver.findElement(By.linkText("Algebra")).click();
			driver.findElement(By.linkText("Percents")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='param0']")).sendKeys("766");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='param1']")).sendKeys("45");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			WebElement percents = driver.findElement(By.xpath("(//font/p)[2]"));
			String actualpercents = percents.getText();
			System.out.println(actualpercents);
			String expectedpercents = "This means, 766 is 45 % of 1702.222222";
			Assert.assertEquals(actualpercents, expectedpercents, "Test is Passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 6)
	public void multiplicationofpolynomials() {
		try {
			driver.findElement(By.linkText("Algebra")).click();
			driver.findElement(By.linkText("Multiply")).click();
			Thread.sleep(2000);
			WebElement polynomial = driver.findElement(By.xpath("//input[@name='s']"));
			polynomial.clear();
			polynomial.sendKeys("(x^2+4)(x-10)");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			WebElement multiplication = driver.findElement(By.xpath("(//font/center)[1]"));
			String actualmultiplication = multiplication.getText();
			System.out.println(actualmultiplication);
			String expectedmultiplication = "";
			Assert.assertEquals(actualmultiplication, expectedmultiplication, "Test is passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 7)
	public void SolvingEquation() {
		try {
			driver.findElement(By.linkText("Algebra")).click();
			driver.findElement(By.linkText("One equation")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='lhs']")).sendKeys("y+34");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='rhs']")).sendKeys("x^2+5y+9");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='variable']")).sendKeys("x");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			WebElement equation = driver.findElement(By.xpath("(//p/font)[47]"));
			String actualequation = equation.getText();
			System.out.println(actualequation);
			String expectedequation = "The solution to your equation is:\r\n" + " = 25-4y";
			Assert.assertNotEquals(actualequation, expectedequation, "Test is Passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 8)
	public void FindingsquareRoots() {
		try {
			driver.findElement(By.linkText("Algebra")).click();
			driver.findElement(By.linkText("Square roots")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='s']")).sendKeys("625z^2");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			WebElement squareroot = driver.findElement(By.xpath("(//tbody/tr/td)[2]"));
			String actualsquareroot = squareroot.getText();
			System.out.println(actualsquareroot);
			String expectedsquareroot = "The final, simplest radical form of = 25z";
			Assert.assertEquals(actualsquareroot, expectedsquareroot, "Test is Passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 9)
	public void backToProblem() {
		try {
			driver.findElement(By.linkText("Algebra")).click();
			driver.findElement(By.linkText("Square roots")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='s']")).sendKeys("625z^2");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//img[@src='/static/images/backToProblem.gif'])[1]")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterClass
	public void BrowserClose() {
		driver.quit();
	}

}
