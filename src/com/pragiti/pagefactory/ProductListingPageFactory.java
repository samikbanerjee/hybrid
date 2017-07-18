package com.pragiti.pagefactory;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductListingPageFactory extends AbstractPageFactory {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */

	@FindBy(css="li.La.auto.parent")
	WebElement navmenu;

	@FindBy(linkText="Canon")
	WebElement navcategory;

	@FindBy(xpath = ("(//input[@type='checkbox'])"))
	List<WebElement> checkboxXPath;

	public ProductListingPageFactory(WebDriver driver) {
		//This initElements method will create  all WebElements
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	//select a category from Navigation Menu
	public void clickOnNavMenuCategories()
	{
		Actions action= new Actions(driver);
		action.moveToElement(navmenu).perform();
		navcategory.click();
	}

	// To remove the filters check-box 
	public void uncheckCheckbox(){	
		for(WebElement checkbox:checkboxXPath)
		{
			if (checkbox.isSelected()) {
				checkbox.click();
				break;
			}

		}

	}
}

