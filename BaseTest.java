package testngframework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	WebDriver driver;
	@Parameters("browsername")
	@BeforeClass
	public void preCondition(String browsername)
	{
		//1.Open Browser
		if(browsername.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browsername.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//2.Open Application
		driver.get("https://demo.actitime.com/login.do");
	}
	@AfterClass
	public void postCondition()
	{
		//5.Close Browser
		driver.close();
	}
	@AfterMethod
	public void testMethodExecutionResult(ITestResult result)
	{
		int value = result.getStatus();
		
		if(value==1)
		{
			Reporter.log(result.getName()+" test method execution status is Passed",true);
		}
		else if(value==2)
		{
			Reporter.log(result.getName()+" test method execution status is Failed",true);
		}
		else
		{
			Reporter.log(result.getName()+" test method execution status is Skipped",true);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
