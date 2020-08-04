package com.autodeskcrm.TestUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.autodeskcrm.genericUtils.Dropdown;
import com.autodeskcrm.genericUtils.Generic_methods;
import com.autodeskcrm.genericUtils.WebDriverUtils;

public class CreateorgTest extends  WebDriverUtils {
	@Test
public void createorg() throws Throwable
{
		Dropdown sel = new Dropdown();
		Generic_methods gm=new Generic_methods();
		/*read the data */
		String org_type = rd.fetchdata("org_type");
		String org_name = rd.fetchdata("org_name")+gm.getRamDomNum();
		String org_ind = rd.fetchdata("org_ind");
		
		/*step1:navigate to organization*/
	driver.findElement(By.linkText("Organizations")).click();
	
	/*step2:navigate to create organization*/
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	/*step3:create organization*/
	driver.findElement(By.name("accountname")).sendKeys(org_name);
	WebElement ele = driver.findElement(By.name("industry"));
	sel.selecttext(ele, org_ind);
	WebElement ele1 = driver.findElement(By.name("accounttype"));
	sel.selecttext(ele1, org_type);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	/*step4:verify organization*/
	String actorgname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	Assert.assertTrue(actorgname.contains(org_name));
}
}
