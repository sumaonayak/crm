package com.autodeskcrm.TestUtils;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.autodeskcrm.genericUtils.Dropdown;
import com.autodeskcrm.genericUtils.Generic_methods;
import com.autodeskcrm.genericUtils.WebDriverUtils;

public class CreatecontactTest extends WebDriverUtils {
	
	@Test
	public void contact() throws Throwable 
	{
		Dropdown sel = new Dropdown();
		Generic_methods gm=new Generic_methods();
		
		/*read data from property file*/
		String contact_fn = rd.fetchdata("contact_fn");
		String contact_ln = rd.fetchdata("contact_ln");
		
		/*step1:navigate to contact */
		driver.findElement(By.linkText("Contacts")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/*step2:navigate to create new contact */
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		/*step3: create new contact */
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(contact_fn);
		driver.findElement(By.name("lastname")).sendKeys(contact_ln);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		/*open new tab*/
		String parent_id = driver.getWindowHandle();
		System.out.println(parent_id);
		Set<String> allids = driver.getWindowHandles();
		allids.remove(parent_id);
		System.out.println(allids);
		for(String id:allids)
		{
		driver.switchTo().window(id);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("qspiders")).click();
		
		/*come back to parent window */
		driver.switchTo().window(parent_id);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*step4:verify contact*/
		String actconatct = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(actconatct.contains(contact_fn));
		
		/*step5:navigate to  contact */
		driver.findElement(By.linkText("Contacts")).click();
		
		/*step5:inspect the element */
		WebElement ele1 = driver.findElement(By.xpath("//a[.='suma']"));
		
		/*step5:navigate to search box and enter the data */
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(contact_fn);
		
		/*step6:select the dropdown*/
		WebElement ele = driver.findElement(By.xpath("//select[@name='search_field']"));
		sel.selecttext(ele, "First Name");
		
		/*step7:click on search now button */
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		/*step8:select the contact checkbox*/
		driver.findElement(By.xpath("//input[@name='selected_id']")).click();
		
		/*step9:delete the contact*/
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		
		/*step10:handle alert*/
		gm.alertOk(driver);
		
		/*verify the element is deleted or not*/
		
	WebElement ele2 = driver.findElement(By.xpath("//a[.='suma']"));
		boolean flag = gm.waitForAnyElement(driver, ele1);
		
		if(flag)
		{
			System.out.println("the element is not deleted");
		}
		else
		{
			System.out.println("the element is deleted");
		}
		
		/*step10:navigate to organizartion */
		driver.findElement(By.linkText("Organizations")).click();
		
		/*step11:select the organization*/
		driver.findElement(By.xpath("//a[.='qspiders']/../preceding-sibling::td[2]")).click();
		
		/*step12:delete the organization*/
		driver.findElement(By.xpath("//input[@value='Delete']"));
		
		/*step13:handle alert popup*/
		gm.alertOk(driver);
	}

}
