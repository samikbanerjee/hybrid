package com.pragiti.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class PaymentPageFactory extends AbstractPageFactory {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */

	@FindBy(xpath="//li[@class='active']/a[contains(text(),'Payment & Billing Address')]")
	WebElement  paymentAddress;

	public WebElement getPaymentAddress() {
		return paymentAddress;
	}

	@FindBy(id="silentOrderPostForm")
	WebElement cardDetailsform;

	public WebElement getCardDetailsform() {
		return cardDetailsform;
	}

	@FindBy(id="card_cardType")
	WebElement cardType;

	public WebElement getCardType() {
		return cardType;
	}


	//Setting the card type from the drop down
	public void setCardType(String card) {
		Select se = new Select(cardType);
		se.selectByVisibleText(card);
	}

	@FindBy(id="card_nameOnCard")
	WebElement nameOnCard;

	//Setting the card name from the drop down
	public void setNameOnCard(String strNameOnCard) {
		nameOnCard.sendKeys(strNameOnCard);

	}

	@FindBy(id="card_accountNumber")
	WebElement accountNumber;

	public void setAccountNumber(String strAccountNumber) {
		accountNumber.sendKeys(strAccountNumber);

	}

	@FindBy(id="card_cvNumber")
	WebElement cvNumber;

	//Setting the card CV number  from the drop down
	public void setCvNumber(String strcvNumber) {
		cvNumber.sendKeys(strcvNumber);

	}

	@FindBy(id="ExpiryMonth")
	WebElement expiryMonth;

	//Setting the card expiry month from the drop down
	public void setExpiryMonth(String expirymonth) {
		Select se = new Select(expiryMonth);
		se.selectByVisibleText(expirymonth);
	}

	public WebElement getExpiryMonth() {
		return expiryMonth;
	}

	@FindBy(id="ExpiryYear")
	WebElement expiryYear;

	//Setting the Expiry year from the drop down
	public void setExpiryYear(String expiryyear) {
		Select se = new Select(expiryYear);
		se.selectByVisibleText(expiryyear);
	}

	public WebElement getExpiryYear() {
		return expiryYear;
	}
	@FindBy(id="useDeliveryAddress")
	WebElement useDeliveryAddress;

	public WebElement getUseDeliveryAddress() {
		return useDeliveryAddress;
	}

	public void clickUseDeliveryAddress(){
		useDeliveryAddress.click();
	}

	@FindBy(xpath="//button[@class='positive right submit_silentOrderPostForm']")
	WebElement nextFrompayementpage;

	public void clickNextFromPayementPage(){
		nextFrompayementpage.click();
	}

	public PaymentPageFactory(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//div[@class='form-actions']/a[@class='button']")
	WebElement cancel;

	public void clickCancel(){
		cancel.click();
	}



}
