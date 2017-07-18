package com.pragiti.pagefactory;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePageFactory extends AbstractPageFactory{

	/**
	 * All WebElements are identified by @FindBy annotation
	 */

	@FindBy(linkText="Sign in / Register")
	WebElement loginLink;

	@FindBy(css="li.logged_in")
	WebElement welComeText;

	@FindBy(linkText="Sign Out")
	WebElement signOutLink;

	@FindBy(linkText="My Account")
	WebElement myAccountLink;

	@FindBy(css="div.content")
	WebElement callUsText;

	@FindBy(xpath="//div[@class='simple_disp-img simple-banner']/a/img[@title='hybris Accelerator']")
	WebElement siteLogo;

	@FindBy(linkText="Find a Store")
	WebElement findStoreLink;

	@FindBy(css="a.minicart")
	WebElement yourShoppingCartLink;

	@FindBy(id="lang_selector_LangCurrencyComponent")
	WebElement langSelector;

	@FindBy(id="currency_selector_LangCurrencyComponent")
	WebElement currencySelector;

	@FindBy(linkText="Facebook")
	WebElement facebookLink;

	@FindBy(linkText="Twitter")
	WebElement twitterLink;

	@FindBy(linkText="Linked In")
	WebElement linkedInLink;

	@FindBy(linkText="Agile Commerce Blog")
	WebElement agileCommerceBloglink;

	@FindBy(className="navigationbarcollectioncomponent")
	WebElement navigationBarCollectionComponent;

	@FindBy(linkText="Brands")
	WebElement brandsLink;

	@FindBy(linkText="Canon")
	WebElement navcategory;

	@FindBy(id="input_SearchBox")
	WebElement input_SearchBox;

	@FindBy(xpath="//button[@class='siteSearchSubmit']")
	WebElement searchGlass;

	@FindBy(linkText="About Commerce Accelerator")
	WebElement aboutCommerceAccelerator;

	@FindBy(linkText="FAQ")
	WebElement faq;

	@FindBy(linkText="About hybris")
	WebElement abouthybris;

	@FindBy(linkText="Contact Us")
	WebElement contactUs;

	@FindBy(xpath=".//*[@id='content']/div[2]/div/a/img")
	WebElement brandImages;

	@FindBy(xpath="//div[@id='homepage_slider']")
	WebElement rotatingBannerImage;

	@FindBy(css="img[alt=\"Canon PowerShot A480\"]")
	WebElement canonPowerShotA480;

	@FindBy(xpath="//div[@class='simple_disp-img simple-banner']/a/img[@title='Brands Galore']")
	WebElement  brandsGalore;

	@FindBy(css="img[alt=\"Sony Cybershot DSC-S930\"]")
	WebElement sonyCybershotDSCS930;

	@FindBy(css="img[alt=\"Kodak EASYSHARE V1253\"]")
	WebElement kodakEASYSHAREV1253;

	@FindBy(css="img[alt=\"Sony DSC-H20\"]")
	WebElement sonyDSCH20;

	@FindBy(css="img[alt=\"Camcorders. HD fun in the palm of your hand >\"]")
	WebElement Camcorders;

	@FindBy(css="img[alt=\"Lenses\"]")
	WebElement lenses;

	@FindBy(css="img[alt=\"What colour are you? Sony Cybershot - a colour for any mood.\"]")
	WebElement whatcolourareyou;

	@FindBy(linkText="2")
	WebElement next2;

	@FindBy(css="img[alt=\"New - Ignite your passion for film with the latest HD camcorder...\"]")
	WebElement   hdcamcorder;

	@FindBy(linkText="3")
	WebElement next3;

	@FindBy(css="img[alt=\"Fun on the run  - Never miss a memory!\"]")
	WebElement funontherun ;

	@FindBy(xpath="//div[@class='thumb']/img[@title='Photosmart E317 Digital Camera']")
	WebElement e317DigitalCamera;

	@FindBy(xpath="//div[@class='thumb']/img[@title='DSC-N1']")
	WebElement dSCN1;

	@FindBy(xpath="//div[@class='thumb']/img[@title='NV10']")
	WebElement nV10;

	@FindBy(xpath="//div[@class='thumb']/img[@title='Cyber-shot W55']")
	WebElement cybershotW55;

	@FindBy(xpath="//div[@class='thumb']/img[@title='PowerShot A480']")
	WebElement PowerShotA480bestsp;

	@FindBy(xpath="//div[@class='thumb']/img[@title='EOS450D + 18-55 IS Kit']")
	WebElement eOS450D ;

	@FindBy(xpath="//button[@class='jcarousel-next jcarousel-next-horizontal']")
	WebElement next;

	@FindBy(xpath="//div[@class='thumb']/img[@title='PL60 Silver']")
	WebElement pL60Silver;

	@FindBy(xpath="//div[@class='thumb']/img[@title='DSLR-A100H']")
	WebElement dSLRA100H;

	@FindBy(css="img[alt=\"HDR-CX105E  Red\"]")
	WebElement hDRCX105E;

	@FindBy(xpath="//div[@class='thumb']/img[@title='LEGRIA HF S100']")
	WebElement lEGRIAHFS100;

	@FindBy(xpath="//div[@class='thumb']/img[@title='AV Cable, Model AV-8']")
	WebElement avCable;

	@FindBy(xpath="//span[@class='thumb']/img[@title='Digital Compact Cameras']")
	WebElement digitalCompactcamera;

	@FindBy(xpath="//span[@class='thumb']/img[@title='Digital SLR Cameras']")
	WebElement dSLR;

	@FindBy(xpath="//span[@class='thumb']/img[@title='Camera and Camcorder Memory']")
	WebElement cameraandMemory;

	@FindBy(xpath="//span[@class='thumb']/img[@title='Camera Accessories and Supplies']")
	WebElement cameraAccessorise;


	//WebElements Getters 

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getWelComeText() {
		return welComeText;
	}

	public WebElement getMyAccountLink() {
		return myAccountLink;
	}
	public WebElement getCallusText() {
		return callUsText;
	}

	public WebElement getFindStorelink() {
		return findStoreLink;
	}


	public WebElement getSiteLogoImage() {
		return siteLogo;
	}

	public WebElement getYourShoppingCartLink() {
		return yourShoppingCartLink;
	}

	public WebElement getLang_selector() {
		return langSelector;
	}


	public WebElement getCurrency_selector() {
		return currencySelector;
	}

	public WebElement getFacebookLink() {
		return facebookLink;
	}

	public WebElement getTwitterLink() {
		return twitterLink;
	}
	public WebElement getAgileCommerceBlog() {
		return agileCommerceBloglink;
	}
	public WebElement getLinked_InLink() {
		return linkedInLink;
	}

	public WebElement getnavigationbarcollectioncomponent() {
		return navigationBarCollectionComponent;
	}

	public WebElement getSearchBox() {
		return input_SearchBox;
	}

	public WebElement getSearchGlass() {
		return input_SearchBox;
	}

	public WebElement getAboutCommerceAcceleratorLink() {
		return aboutCommerceAccelerator;
	}

	public WebElement getAbouthybrisLink() {
		return abouthybris;
	}
	public WebElement getFAQLink() {
		return faq;
	}
	public WebElement getContactUsLink() {
		return contactUs;
	}

	public WebElement getBrandImages() {
		return brandImages;
	}

	public WebElement getRotatingBannerImage() {
		return rotatingBannerImage;
	}


	public WebElement getCanonPowerShotA480Image() {
		return canonPowerShotA480;
	}

	public WebElement getSonyCybershotDSCS930Image() {
		return sonyCybershotDSCS930;
	}

	public WebElement getKodakEASYSHAREV1253Image() {
		return kodakEASYSHAREV1253;
	}

	public WebElement getSonyDSCH20Image() {
		return sonyDSCH20;
	}

	public WebElement getE317DigitalCameraImage() {
		return e317DigitalCamera;
	}

	public WebElement getDSCN1Image() {
		return dSCN1;
	}

	public WebElement getNV10Image() {
		return nV10;
	}

	public WebElement getCybershotW55Image() {
		return cybershotW55;
	}

	public WebElement getPowerShotA480BSPImage() {
		return PowerShotA480bestsp;
	}

	public WebElement getEOS450DImage() {
		return eOS450D;
	}

	public WebElement getPL60SilverImage() {
		return pL60Silver;
	}

	public WebElement getDSLRA100HImage() {
		return dSLRA100H;
	}

	public WebElement getHDRCX105EImage() {
		return hDRCX105E;
	}

	public WebElement getLEGRIAHFS100Image() {
		return lEGRIAHFS100;
	}

	public WebElement getAVCableImage() {
		return avCable;
	}

	// set search text
	public void setInput_SearchBox(String searchKeyword) {
		// Fill search keyword
		input_SearchBox.sendKeys(searchKeyword);
	}

	public void clickBrandsGaloreImage(){
		brandsGalore.click();
	}

	public void clickCanonPowerShotA480Image(){
		canonPowerShotA480.click();
	}

	public void clickSonyCybershotDSCS930Image(){
		sonyCybershotDSCS930.click();
	}

	public void clickKodakEASYSHAREV1253Image(){
		kodakEASYSHAREV1253.click();
	}

	public void clickSonyDSCH20Image(){
		sonyDSCH20.click();
	}

	public void clickCamcordersImage(){
		Camcorders.click();
	}

	public void clickLensesImage(){
		lenses.click();
	}

	public void clickWhatcolourareImage(){
		whatcolourareyou.click();
	}

	public void clickOn2(){
		next2.click();
	}

	public void clickHDcamcorderImage(){
		hdcamcorder.click();
	}

	public void clickOn3(){
		next3.click();
	}

	public void clickFunontherunImage(){
		funontherun.click();
	}

	public void clickE317DigitalCameraImage(){
		e317DigitalCamera.click();
	}

	public void clickDSCN1Image(){
		dSCN1.click();
	}

	public void clickNV10Image(){
		nV10.click();
	}

	public void clickCybershotW55Image(){
		cybershotW55.click();
	}

	public void clickPowerShotA480BSPImage(){
		PowerShotA480bestsp.click();
	}

	public void clickEOS450DImage(){
		eOS450D.click();
	}

	public void clicknext(){
		next.click();
	}

	public void clickPL60SilverImage(){
		pL60Silver.click();
	}

	public void clickDSLRA100HImage(){
		dSLRA100H.click();
	}

	public void clickHDRCX105EImage(){
		hDRCX105E.click();
	}

	public void clickLEGRIAHFS100Image(){
		e317DigitalCamera.click();
	}

	public void clickavCableImage(){
		avCable.click();
	}

	public void clickDigitalCompactCameraImage(){
		digitalCompactcamera.click();
	}

	public void clickDSLRImage(){
		dSLR.click();
	}

	public void clickCameraAndMemoryImage(){
		cameraandMemory.click();
	}
	public void clickCameraAccessoriseImage(){
		cameraAccessorise.click();
	}

	public HomePageFactory(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}


	//Click on login link
	public void clickLoginLink(){
		loginLink.click();
	}

	public void clickMyAccountLink(){
		myAccountLink.click();
	}


	public void clickSiteLogoImage(){
		siteLogo.click();
	}

	public void clickFindStoreLink(){
		findStoreLink.click();
	}


	public void clickBrandsLink(){
		brandsLink.click();
	}

	public void clickCanonLink(){
		navcategory.click();
	}

	public void clickAboutCommerceAcceleratorLink(){
		aboutCommerceAccelerator.click();
	}

	public void clickAbouthybrisLink(){
		abouthybris.click();
	}

	public void clickFAQLink(){
		faq.click();
	}

	public void clickContactUsLink(){
		contactUs.click();
	}

	public void clickSignOut(){
		signOutLink.click();
	}
}