package com.pragiti.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPageFactory  extends AbstractPageFactory{

	/**
	 * All WebElements are identified by @FindBy annotation
	 */	

	@FindBy(css="div.headline")
	WebElement reviweText;

	public WebElement getReviweText() {
		return reviweText;
	}

	@FindBy(xpath="//div[@class='summaryDeliveryAddress']")
	WebElement shippingAddress;

	public WebElement getShippingAddress() {
		return shippingAddress;
	}

	@FindBy(xpath="//div[@class='summaryDeliveryMode clearfix']")
	WebElement shippingMethod;

	public WebElement getShippingMethod() {
		return shippingMethod;
	}

	@FindBy(xpath="//div[@class='summaryPayment clearfix']")
	WebElement paymentandBillingAddress;

	public WebElement getPaymentandBillingAddress() {
		return paymentandBillingAddress;
	}

	@FindBy(id="Terms1")
	WebElement termsCondition;

	public void clickTermsConditions(){
		termsCondition.click();
	}

	@FindBy(xpath="//button[@class='positive right place-order']")
	WebElement placeOrder;

	public void clickPlaceOrder(){
		placeOrder.click();
	}

	@FindBy(xpath="//div[@class='orderBox address']")
	WebElement orderBoxAddress;

	public WebElement getOrderBoxAddress() {
		return orderBoxAddress;
	}

	@FindBy(xpath="//div[@class='orderBox delivery']")
	WebElement orderBoxDelivery;

	public WebElement getOrderBoxDelivery() {
		return orderBoxDelivery;
	}

	@FindBy(xpath="//div[@class='orderBox payment']")
	WebElement orderBoxPayment;

	public WebElement getOrderBoxPayment() {
		return orderBoxPayment;
	}

	@FindBy(xpath="//div[@class='orderList']")
	WebElement orderList;

	public WebElement getOrderList() {
		return orderList;
	}

	@FindBy(xpath="//div[@class='orderHead']/div[contains(text(),'Order Number')]")
	WebElement orderNumber;

	//editDeliveryOption on review page

	@FindBy(xpath="//div[@class='column append-1']/ul/li[contains(text(),'Delivery Mode')]")
	WebElement editDeliveryOption;

	public WebElement getDeliveryOption() {
		return editDeliveryOption;
	}

	//edit line1 on review page

	@FindBy(xpath="//div[@class='summaryDeliveryAddress']/ul/li[2]")
	WebElement editLine1;

	public WebElement getEditLine1() {
		return editLine1;
	}

	@FindBy(xpath="//div[@class='summaryPayment clearfix']/div[@class='column append-1']")
	WebElement editPaymetDetails;

	@FindBy(xpath="//div[@class='summaryPayment clearfix']/div[@class='column']")
	WebElement editBillingaddress;

	public WebElement getEditBillingaddress() {
		return editBillingaddress;
	}

	public WebElement getEditPaymetDetails() {
		return editPaymetDetails;
	}


	public WebElement getOrderNumber() {
		return orderNumber;
	}

	@FindBy(xpath="//div[@id='content']/div[@class='span-24']/div/a")
	WebElement continueShopping;

	public void clickContinueShopping(){
		continueShopping.click();
	}
	@FindBy(xpath="//div[@class='summaryDeliveryAddress']/a[contains (text(),'Edit') ] ")
	WebElement editDeliveryAddress;


	public void clickEditDeliveryAddress(){
		editDeliveryAddress.click();
	}

	@FindBy(xpath="//div[@class='summaryDeliveryMode clearfix']/a[contains (text(),'Edit') ]")
	WebElement editDeliveryMode;


	public void clickEditDeliveryMode(){
		editDeliveryMode.click();
	}
	@FindBy(xpath="//div[@class='summaryPayment clearfix']/a[contains (text(),'Edit') ]")
	WebElement editPayment;


	public void clickEditPayment(){
		editPayment.click();
	}

	public ReviewPageFactory(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}

}
