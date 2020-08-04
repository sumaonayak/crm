package com.autodeskcrm.genericUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverUtils {
	 protected WebDriver driver;
	public ReadDataFromProperty rd = new ReadDataFromProperty();
	@BeforeMethod
	public void openapp() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "./sss/geckodriver.exe");
		driver= new FirefoxDriver();
		String url = rd.fetchdata("url");
		driver.get(url);
		String un = rd.fetchdata("username");
		String pwd = rd.fetchdata("password");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("submitbutton")).click();
	}
/*	@AfterMethod
public void closeapp()
{
		WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele2).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		}
		*/

}
