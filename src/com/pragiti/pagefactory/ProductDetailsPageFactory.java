package com.pragiti.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class ProductDetailsPageFactory extends AbstractPageFactory {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */

	@FindBy(id="content")
	WebElement productcontent;

	public WebElement getProductcontent() {
		return productcontent;
	}

	@FindBy(xpath="//h1")
	WebElement productname;

	public WebElement getProductname() {
		return productname;
	}

	@FindBy(xpath="//div[contains(@class, 'summary')]")
	WebElement productdescription;

	public WebElement getProductdescription() {
		return productdescription;
	}

	@FindBy(xpath="//div[contains(@class, 'big-price right')]")
	WebElement productprice;

	public WebElement getProductprice() {
		return productprice;
	}

	@FindBy(id="based_on_reviews")
	WebElement reviewcount;

	public WebElement getReviewcount() {
		return reviewcount;
	}

	@FindBy(xpath="//div[@class='prodReview clearfix']/span[@class='stars']")
	WebElement productstars;

	public WebElement getProductstars() {
		return productstars;
	}

	@FindBy(xpath="//button[@class='outOfStock']")
	WebElement productstockmessage;


	public WebElement getProductstockmessage() {
		return productstockmessage;
	}

	@FindBy(xpath="//input[@id='qtyInput']")
	WebElement quantityfield;

	public WebElement getQuantityfield() {
		return quantityfield;
	}

	@FindBy(xpath="//button[@id='addToCartButton']")
	WebElement addtocart;

	public WebElement getAddtocart() {
		return addtocart;
	}

	@FindBy(xpath="//a[@id='write_review_action_main']")
	WebElement writereview;

	public WebElement getWritereview() {
		return writereview;
	}

	@FindBy(linkText ="Share")
	WebElement share;

	public WebElement getShare() {
		return share;
	}

	@FindBy(xpath="//*[@id='a2apage_mini_services']/a[1]")
	WebElement socialmediashare;


	public WebElement getSocialmediashare() {
		return socialmediashare;
	}

	@FindBy(linkText="POWER ADAPTERS & INVERTERS")
	WebElement pdpbreadcrumb;


	public WebElement getPdpbreadcrumb() {
		return pdpbreadcrumb;
	}


	public ProductDetailsPageFactory(WebDriver driver) {

		//This initElements method will create  all WebElements

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}	
