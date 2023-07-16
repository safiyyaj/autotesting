package com.TestAuto.Test.testautoassi;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AppTest {
	
	ChromeDriver driver;
	
	@Test
	public void LoggingwithCorrectDetials() {
        
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
  
        driver.get("https://demo.actitime.com/login.do");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("manager");
        driver.findElement(By.name("pwd")).sendKeys("admin");
       
        driver.findElement(By.id("loginButton")).click();
    }
	
	@Test
	public void verifyLoginwithincorrectUserName() {
		
		 ChromeOptions chromeOptions = new ChromeOptions();
		 	chromeOptions.addArguments("--remote-allow-origins=*");
	        ChromeDriver driver = new ChromeDriver(chromeOptions);
	  
	        driver.get("https://demo.actitime.com/login.do");
	        driver.manage().window().maximize();
	        driver.findElement(By.id("username")).sendKeys("User");
	        driver.findElement(By.name("pwd")).sendKeys("manager");
	       
	        driver.findElement(By.id("loginButton")).click();
		
	}
	
	@Test
	public void verifyLoginwithincorrectPassword() {
		
		 ChromeOptions chromeOptions = new ChromeOptions();
		 	chromeOptions.addArguments("--remote-allow-origins=*");
	        ChromeDriver driver = new ChromeDriver(chromeOptions);
	  
	        driver.get("https://demo.actitime.com/login.do");
	        driver.manage().window().maximize();
	        driver.findElement(By.id("username")).sendKeys("admin");
	        driver.findElement(By.name("pwd")).sendKeys("Password");
	       
	        driver.findElement(By.id("loginButton")).click();
	
	}
	
	@Test
	public void SearchUser_withcorrectdetails() {
        
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(Common.CHROME_ARGUMENT);
        ChromeDriver driver = new ChromeDriver(chromeOptions);
  
        driver.get("https://demo.actitime.com/login.do");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys(Common.UserName);
        driver.findElement(By.name("pwd")).sendKeys(Common.Password);
       
        driver.findElement(By.id("loginButton")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/user/submit_tt.do"));
        
        
        driver.findElement(By.id("container_users")).click();
    }
	
	@Test
	public void SearchReport_SearchUser_withcorrectdetails() {
        
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(Common.CHROME_ARGUMENT);
        ChromeDriver driver = new ChromeDriver(chromeOptions);
  
        driver.get(Common.WEB_URL);
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys(Common.UserName);
        driver.findElement(By.name("pwd")).sendKeys(Common.Password);
       
        driver.findElement(By.id("loginButton")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/user/submit_tt.do"));
        
	}
	
	

			public void captureScreenshot(WebDriver driver, String screenshotPath) {
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenshotFile.toPath(), new File(screenshotPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	

}	


