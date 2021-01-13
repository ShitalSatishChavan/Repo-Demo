package testngframework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScript_01 extends BaseTest
{
	@Test
	public void testActitimeLogin()
	{
		
		//3.Enter Valid Username, Password and click on login button
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("Time-Track"));
		//4.Verify HomePage displayed or not
		String homepage_title = driver.getTitle();
		String expected_title="actiTIME - Enter Time-Track";
		Assert.assertEquals(homepage_title, expected_title);
		
	}

}
