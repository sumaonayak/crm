package com.autodeskcrm.genericUtils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
	/**
	 * @author suma
	 * @param ele
	 * @param text
	 */
	public void selecttext(WebElement ele,String text)
	/**
	 * 
	 */
	{
		Select s=new Select(ele);
		s.selectByVisibleText(text);
	}

}
