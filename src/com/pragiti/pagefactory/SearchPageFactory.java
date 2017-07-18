package com.pragiti.pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchPageFactory extends AbstractPageFactory {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */

	WebDriver driver;

	@FindBy(css = "div.thumb")
	WebElement  productthumbnail ;

	@FindBy(xpath = ("(//input[@type='checkbox'])"))
	List<WebElement> checkboxXPath;

	@FindBy(className = "addToCartButton")
	WebElement addtocartbutton;


	@FindBy(className = "count")
	WebElement cartcount;

	public WebElement getCartcount() {
		return cartcount;
	}

	@FindBy(id = "sortOptions1")
	WebElement sortOptions;

	@FindBy(linkText = "Show all")
	WebElement showall;


	@FindBy(linkText = "2")
	WebElement pagination;

	public SearchPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getSortOptions() {
		return sortOptions;
	}

	public WebElement getShowall() {
		return showall;
	}

	public WebElement getAddtocartbutton() {
		return addtocartbutton;
	}

	public WebElement getPagination() {
		return pagination;
	}

	public WebElement getProductthumbnail() {
		return productthumbnail;
	}

	// filters check-box click
	public void clickOnCheckbox() {

		for (WebElement checkbox : checkboxXPath)
			if (!checkbox.isSelected()) {
				checkbox.click();
				break;
			}
	}

	// sort products
	public void clickOnSortOptions(String sorttext) {
		Select se = new Select(sortOptions);
		se.selectByVisibleText(sorttext);
	}

}
