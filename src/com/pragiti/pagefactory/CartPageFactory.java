package com.pragiti.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPageFactory extends AbstractPageFactory{
	
	/**
	 * All WebElements are identified by @FindBy annotation
	 */

	@FindBy(xpath="//li[@class='yCmsComponent miniCart']")
	WebElement cartText;
	
	@FindBy(id="addToCartButton")
	WebElement addToCartButton;

	@FindBy(xpath="//td[@class='thumb']/a/img[@title='PowerShot A480']")
	WebElement productImage;

	@FindBy(linkText="PowerShot A480")
	WebElement productLink;

	@FindBy(xpath="//td[@class='itemPrice']")
	WebElement itemPrice;

	@FindBy(id="quantity0")
	WebElement quantity;


	@FindBy(xpath="//label[@class='nostyle']")
	WebElement shipping;

	@FindBy(xpath="//td[@headers='header6']")
	WebElement total;

	@FindBy(id="QuantityProduct_0")
	WebElement update;



	@FindBy(css="div.alert.positive")
	WebElement updateAlert;

	@FindBy(id="RemoveProduct_0")
	WebElement remove;
	
	@FindBy(id="checkoutButtonTop")
	WebElement checkout;

	//Web-elements Getters 
	
	public WebElement getRemoveProduct() {
		return remove;
	}

	public WebElement getUpdateAlert() {
		return updateAlert;
	}

	public WebElement getUpdateProductQuantity() {
		return update;
	}

	public WebElement getProductImage() {
		return productImage;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getItemPrice() {
		return itemPrice;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getShippingOptions() {
		return shipping;
	}
	public WebElement getTotal() {
		return total;
	}
	
	//Click on the web elements

	public void clickCartText(){
		cartText.click();
	}

	public void clickAddToCartButton(){
		addToCartButton.click();
	}

	
	public void clickUpdate(){
		update.click();
	}
	
	public void clickRemove() {
		remove.click();
	}
	
	public void clickCheckout() {
		checkout.click();
	}
	public CartPageFactory(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
}
