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

public class K8MathsandTrigcalculus {

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

	@Test(priority = 0, groups = "K-8math")
	public void VerifylinksofK8Math() {
		try {
			driver.findElement(By.linkText("K-8 Math")).click();
			Thread.sleep(2000);
			List<WebElement> c = driver.findElements(By.tagName("a"));
			for (int i = 0; i < c.size(); i++) {
				String links = c.get(i).getText();
				System.out.println(links);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 1, groups = "K-8math")
	public void Multiplicationcalculation() {
		try {
			driver.findElement(By.linkText("K-8 Math")).click();
			driver.findElement(By.linkText("Multiply")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='n1']")).sendKeys("465");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='n2']")).sendKeys("667");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			WebElement multiplication = driver.findElement(By.xpath("(//font/center)[11]"));
			String actualmultiplication = multiplication.getText();
			String expectedmultiplication = "All done! Just add the blue numbers together to get your answer:\r\n"
					+ "310155\r\n" + "\r\n" + "and that's your answer!";
			System.out.println(actualmultiplication);
			Assert.assertNotEquals(actualmultiplication, expectedmultiplication, "Test is passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 2, groups = "K-8math")
	public void FindingRatio() {
		try {
			driver.findElement(By.linkText("K-8 Math")).click();
			driver.findElement(By.linkText("What's a Ratio?")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='a1']")).sendKeys("56");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='b1']")).sendKeys("78");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			WebElement ratio = driver.findElement(By.xpath("(//ul/li)[4]"));
			String actualratio = ratio.getText();
			String expectedratio = "In other words, 28:39 is the same as your ratio 56:78.";
			Assert.assertEquals(actualratio, expectedratio, "Test is passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 3, groups = "K-8math")
	public void ChamparingFractions() {
		try {
			driver.findElement(By.linkText("K-8 Math")).click();
			driver.findElement(By.linkText("Comparing Fractions")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='n1']")).sendKeys("450");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='d1']")).sendKeys("900");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='n2']")).sendKeys("50");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='d2']")).sendKeys("150");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			WebElement fraction = driver.findElement(By.xpath("//font/blockquote/p"));
			String actualcomparision = fraction.getText();
			System.out.println(actualcomparision);
			String expectedcomparision = "In this case, in looks like pie showing 450/900 has more shading than the pie showing 50/150. This means that 450/900 is larger than 50/150";
			Assert.assertEquals(actualcomparision, expectedcomparision, "Test is passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 4, groups = "K-8math")
	public void Calculatingareaofrectangle() {
		try {
			driver.findElement(By.linkText("K-8 Math")).click();
			driver.findElement(By.linkText("Rectangles")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='width']")).sendKeys("12");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='height']")).sendKeys("15");
			Thread.sleep(2000);
			WebElement units = driver.findElement(By.xpath("//select[@name='units']"));
			Select selectunit = new Select(units);
			selectunit.selectByIndex(4);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			WebElement area = driver.findElement(By.xpath("(//font/ul/li)[2]"));
			String actualarea = area.getText();
			System.out.println(actualarea);
			String expectedarea = "The quick way to determine the area is to multiply the width and the height to get: 12 × 15 = 180.";
			Assert.assertEquals(actualarea, expectedarea, "Test is passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 5, groups = "Trig.Calculus")
	public void Verifylinksoftrigandcalculus() {
		try {
			driver.findElement(By.linkText("Trig. & Calculus")).click();
			Thread.sleep(2000);
			List<WebElement> d = driver.findElements(By.tagName("a"));
			for (int i = 0; i < d.size(); i++) {
				String links = d.get(i).getText();
				System.out.println(links);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 6, groups = "Trig.Calculus")
	public void simplifyingtrignometricexpression() {
		try {
			driver.findElement(By.linkText("Trig. & Calculus")).click();
			driver.findElement(By.linkText("Trigonometric Expressions")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='s']")).sendKeys("sin(56)+cos(45)");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			WebElement expression = driver.findElement(By.xpath("//tbody/tr/td/font"));
			String actualanswer = expression.getText();
			System.out.println(actualanswer);
			String expectedanswer = "1.53614";
			Assert.assertEquals(actualanswer, expectedanswer, "Test is passed");
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 7, groups = "Trig.Calculus")
	public void Calculatingangleofrighttriangle() {
		try {
			driver.findElement(By.linkText("Trig. & Calculus")).click();
			driver.findElement(By.linkText("Right Triangles")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='a']")).sendKeys("9");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='b']")).sendKeys("8");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='c']")).sendKeys("15");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='d']")).sendKeys("35");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='e']")).sendKeys("?");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			WebElement angle = driver.findElement(By.xpath("(//font/center)[4]"));
			String actualangle = angle.getText();
			System.out.println(actualangle);
			String expectedangle = "Angle E = 48.3665°";
			Assert.assertEquals(actualangle, expectedangle, "Test is passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 8, groups = "Trig.Calculus")
	public void Cleartheentereddataofrightangles() {
		try {
			driver.findElement(By.linkText("Trig. & Calculus")).click();
			driver.findElement(By.linkText("Right Triangles")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='a']")).sendKeys("9");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='b']")).sendKeys("8");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='c']")).sendKeys("15");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='d']")).sendKeys("35");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='e']")).sendKeys("?");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='reset']")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 9, groups = "Trig.Calculus")
	public void Findingderivatives() {
		try {
			driver.findElement(By.linkText("Trig. & Calculus")).click();
			driver.findElement(By.linkText("Derivatives")).click();
			Thread.sleep(2000);
			WebElement expression = driver.findElement(By.xpath("//input[@name='s']"));
			expression.clear();
			expression.sendKeys("2x^2+3y^3");
			Thread.sleep(2000);
			WebElement variable = driver.findElement(By.xpath("//input[@name='wrt']"));
			variable.clear();
			variable.sendKeys("y");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("centerContentFrame");
			WebElement derivative = driver.findElement(By.xpath("(//font/center)[2]"));
			String actualderivative = derivative.getText();
			System.out.println(actualderivative);
			String expectedderivative = "";
			Assert.assertEquals(actualderivative, expectedderivative, "Test is passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 10, groups = "Trig.Calculus")
	public void solvingintergral() {
		try {
			driver.findElement(By.linkText("Trig. & Calculus")).click();
			driver.findElement(By.linkText("Integrals")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='s']")).sendKeys("4x^3y");
			Thread.sleep(2000);
			WebElement variable = driver.findElement(By.xpath("//input[@name='wrt']"));
			variable.clear();
			variable.sendKeys("x");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(3000);
			driver.switchTo().frame("centerContentFrame");
			WebElement integration = driver.findElement(By.xpath("(//font/center)[2]"));
			String actualintegration = integration.getText();
			System.out.println(actualintegration);
			String expectedintegration = "";
			Assert.assertEquals(actualintegration, expectedintegration, "Test is passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterClass
	public void BrowserClose() {
		driver.quit();
	}
}
