package com.pragiti.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MyAccountPageFactory extends AbstractPageFactory{

	/**
	 * All WebElements are identified by @FindBy annotation
	 */

	@FindBy(xpath=".//div[@id='content']")
	WebElement accountDashboard;

	@FindBy(xpath="//div[contains(@class,'headline')]")
	WebElement headline;	

	@FindBy(xpath="//a[contains(@href,'update-password')]")
	WebElement changepassword;

	@FindBy(id="profile.currentPassword")
	WebElement currentPwd ;

	@FindBy(id="profile-newPassword")
	WebElement newPwd ;

	@FindBy(id="profile.checkNewPassword")
	WebElement confirmNewPwd ;


	@FindBy(xpath="//button[@class='positive']")
	WebElement update_button;


	@FindBy(xpath="//div[@id='globalMessages']")
	WebElement update_pwd_msg;

	// update profile 
	@FindBy(xpath="//a[@href='update-profile']")
	WebElement update_profile;


	@FindBy(id="profile.lastName")
	WebElement update_lname;

	//update email
	@FindBy(xpath="//a[@href='update-email']")
	WebElement update_email;	


	@FindBy(id="profile.email")
	WebElement update_new_email;

	@FindBy(id="profile.checkEmail")
	WebElement confirm_new_email;

	@FindBy(id="profile.pwd")
	WebElement pwd;

	@FindBy(linkText="Profile")
	WebElement profilelink;

	// address book
	@FindBy(linkText="Address Book")
	WebElement addressbooklink;


	@FindBy(xpath="//div[contains(text(),'Profile')]")
	WebElement profile;	


	@FindBy(xpath="//div[contains(text(),'Address Book')]")
	WebElement addressbook;

	@FindBy(xpath="//div[contains(text(),'Payment Details')]")
	WebElement paymentdetails;


	@FindBy(xpath="//div[contains(text(),'	Order History')]")
	WebElement orderdetails;

	//add address 
	@FindBy(xpath="//a[@href='add-address']")
	WebElement addaddressbutton;

	@FindBy(xpath="//select[@id='address.country']")
	WebElement country;	

	@FindBy(xpath="//select[@id='address.title']")
	WebElement title;

	@FindBy(xpath="//input[@id='address.firstName']")
	WebElement address_fname;

	@FindBy(xpath="//a[contains(@href,'edit-address')]")
	WebElement editaddress;


	@FindBy(xpath="//div[@id='addressform_button_panel']/button")
	WebElement saveaddress;

	//remove address
	@FindBy(xpath=".//*[@id='content']/div[2]/div[2]/div/div/div/div/div[3]/div/a[2]")
	WebElement removeaddressbutton;


	@FindBy(xpath="//div[@id='cboxLoadedContent']")
	WebElement removealert;		


	@FindBy(xpath="//a[contains(@href,'remove-address')]")
	WebElement alert_yesbutton;

	// navigate to payment details page
	@FindBy(linkText="Payment Details")
	WebElement paymentdetailslink;

	@FindBy(xpath="//button[@class='submitRemove']")
	WebElement removepaymentdetails;

	//navigate to order history page
	@FindBy(linkText="Order History")
	WebElement orderhistorylink;

	@FindBy(xpath="//td[position()=1]")
	WebElement ordernumber;	

	// navigate to order details page 	
	@FindBy(linkText="View")
	WebElement ViewOrderDetailspage;

	@FindBy(xpath="//div[@class='orderBox address']//ul")
	WebElement shippingaddress;

	@FindBy(xpath="//div[@class='orderBox delivery']//ul")
	WebElement shippingmethod;

	@FindBy(xpath="//div[@class='orderBox billing']//ul")
	WebElement billingaddress;

	@FindBy(xpath="//div[@class='orderBox payment']//ul")
	WebElement payment_details;

	@FindBy(xpath="//table[@class='orderListTable']")
	WebElement ordersummary;

	@FindBy(xpath="//input[@id='address.surname']")
	WebElement address_surname;

	// add address
	@FindBy(xpath="//input[@id='address.line1']")
	WebElement address_line1;

	@FindBy(xpath="//input[@id='address.line2']")
	WebElement address_line2;

	@FindBy(xpath="//input[@id='address.townCity']")
	WebElement address_townCity;

	@FindBy(xpath="//input[@id='address.postcode']")
	WebElement address_postcode;

	@FindBy(xpath="//select[@id='address.region']")
	WebElement address_province;

	@FindBy(xpath="//button[@class='positive right change_address_button show_processing_message']")
	WebElement nextbutton;

	public WebElement getEditaddress() {
		return editaddress;
	}

	// save address
	public WebElement getSaveaddress() {
		return saveaddress;
	}


	public WebElement getOrdernumber() {
		return ordernumber;
	}

	public WebElement getViewOrderDetailspage() {
		return ViewOrderDetailspage;
	}


	public WebElement getBillingaddress() {
		return billingaddress;
	}

	public WebElement getOrdersummary() {
		return ordersummary;
	}

	public WebElement getPayment_details() {
		return payment_details;
	}

	public WebElement getShippingmethod() {
		return shippingmethod;
	}

	public WebElement getShippingaddress() {
		return shippingaddress;
	}

	public WebElement getOrderhistorylink() {
		return orderhistorylink;
	}

	public WebElement getRemovepaymentdetails() {
		return removepaymentdetails;
	}

	public WebElement getPaymentdetailslink() {
		return paymentdetailslink;
	}

	public WebElement getAlert_yesbutton() {
		return alert_yesbutton;
	}

	public WebElement getRemovealert() {
		return removealert;
	}

	public WebElement getRemoveaddress() {
		return removeaddressbutton;
	}

	public WebElement getAddress_fname() {
		return address_fname;
	}

	public void setAddress_fname(String fname) {
		address_fname.sendKeys(fname);

	}

	public WebElement getAddress_surname() {
		return address_surname;
	}


	public void setAddress_surname(String surname) {
		address_surname.sendKeys(surname);
	}


	public WebElement getAddress_line1() {
		return address_line1;
	}


	public void setAddress_line1(String add_line1) {
		address_line1.sendKeys(add_line1);
	}


	public WebElement getAddress_line2() {
		return address_line2;
	}


	public void setAddress_line2(String add_line2) {
		address_line2.sendKeys(add_line2);
	}


	public WebElement getAddress_townCity() {
		return address_townCity;
	}


	public void setAddress_townCity(String townCity) {
		address_townCity.sendKeys(townCity);
	}


	public WebElement getAddress_postcode() {
		return address_postcode;
	}


	public void setAddress_postcode(String postcode) {
		address_postcode.sendKeys(postcode);
	}


	public WebElement getNextbutton() {
		return nextbutton;
	}

	public WebElement getProfilelink() {
		return profilelink;
	}

	public WebElement getAddressbooklink() {
		return addressbooklink;
	}

	public WebElement getUpdate_email() {
		return update_email;
	}


	public WebElement getUpdate_new_email() {
		return update_new_email;
	}

	//Updating email address
	public void setUpdate_new_email(String new_email) {
		update_new_email.sendKeys(new_email);
	}


	public WebElement getConfirm_new_email() {
		return confirm_new_email;
	}

	// Setting new email address 
	public void setConfirm_new_email(String confirmNewEmail) {
		confirm_new_email.sendKeys(confirmNewEmail);
	}

	public WebElement getPwd() {
		return pwd;
	}

	public void setPwd(String password) {
		pwd.sendKeys(password);
	}

	public WebElement getAccountDashboard() {
		return accountDashboard;
	}	
	public WebElement getProfile() {
		return profile;
	}
	public WebElement getAddressbook() {
		return addressbook;
	}
	public WebElement getPaymentdetails() {
		return paymentdetails;
	}
	public WebElement getOrderdetails() {
		return orderdetails;
	}
	public WebElement getUpdate_button() {
		return update_button;
	}

	public WebElement getAddaddressbutton() {
		return addaddressbutton;
	}

	public WebElement getUpdate_profile() {
		return update_profile;
	}

	public void click_update_button()
	{
		update_button.click();
	}


	public WebElement getUpdate_lname() {
		return update_lname;
	}

	public WebElement getUpdate_pwd_msg() {
		return update_pwd_msg;
	}

	public WebElement getChangepassword() {
		return changepassword;
	}
	/**
	 * This POM method will be exposed in test case to login in the application
	 * @param strUserName
	 * @param strPasword
	 * @return
	 */

	//update e-mail
	public void updateEmail(String new_email, String confirm_new_email,String password)
	{   this.getUpdate_new_email().clear();
	this.setUpdate_new_email(new_email);
	this.setConfirm_new_email(confirm_new_email);
	this.setPwd(password);
	this.click_update_button();

	}
	// update profile 
	public void setUpdate_lname(String lname) {
		update_lname.sendKeys(lname);
	}

	//update profile details
	public void updateProfile(String lname)
	{
		this.getUpdate_lname().clear();
		this.setUpdate_lname(lname);

	}

	//current password
	public void setCurrentPwd(String currPwd) {	
		currentPwd.sendKeys(currPwd);
	}

	//set new password
	public void setNewPwd(String new_Pwd) {
		newPwd.sendKeys(new_Pwd);
	}

	//confirm new password
	public void setConfirmNewPwd(String confirm_new_Pwd) {
		confirmNewPwd.sendKeys(confirm_new_Pwd); 
	}


	//update password 
	public void updatepwd(String currentPwd,String newPwd, String confirmNewPwd)
	{

		this.setCurrentPwd(currentPwd);
		this.setNewPwd(newPwd);
		this.setConfirmNewPwd(confirmNewPwd);
		this.click_update_button();

	}

	//add address to the address book 
	public void addadress(String country_name, String member_title,String fname,String lname, String addline1, String addline2, String city, String province ,String postcode)
	{
		Select countryoptions=  new Select(country);
		countryoptions.selectByVisibleText(country_name);

		Select titleoptions=  new Select(title);
		titleoptions.selectByVisibleText(member_title);

		this.setAddress_fname(fname);
		this.setAddress_surname(lname);
		this.setAddress_line1(addline1);
		this.setAddress_line2(addline2);
		this.setAddress_townCity(city);

		Select provinceoptions=  new Select(address_province);
		provinceoptions.selectByVisibleText(province);

		this.setAddress_postcode(postcode);
		this.getNextbutton().click();

	}

	// edit address from the address book 
	public void editaddress(String addline1, String addline2)
	{
		this.getAddress_line1().clear();
		this.setAddress_line1(addline1);

		this.getAddress_line2().clear();
		this.setAddress_line2(addline2);

		this.getSaveaddress().click();
	}


	public MyAccountPageFactory(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}

}
