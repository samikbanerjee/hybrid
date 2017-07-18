package com.pragiti.pagefactory;
import java.util.Map;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PDPPageFactory {
    private Map<String, String> data;
    private WebDriver driver;
    @FindBy(id = "addToCartButton")
    @CacheLookup
    private WebElement addToBag;


    @FindBy(name = "qty")
    @CacheLookup
    private WebElement quantity;


    @FindBy(css = "a[href=' /en/shop/readers']")
    @CacheLookup
    private WebElement readers;


    public PDPPageFactory() {
    }

    public PDPPageFactory(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PDPPageFactory(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public PDPPageFactory(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
    }
    
    /**
     * Go To PDP Page
     *
     * @return the PDPPageFactory class instance.
     */
     public PDPPageFactory goToPDP(String url)
    {
    	driver.get(url);
		return this;
    }



    /**
     * Click on Add To Bag Button.
     *
     * @return the PDPPageFactory class instance.
     */
    public PDPPageFactory clickAddToBagButton() {
        addToBag.click();
        return this;
    }

    /**
     * Click on Readers Link.
     *
     * @return the PDPPageFactory class instance.
     */
    public PDPPageFactory clickReadersLink() {
        readers.click();
        return this;
    }





    /**
     * Set default value to Quantity Drop Down List field.
     *
     * @return the PDPPageFactory class instance.
     */
    public PDPPageFactory setQuantityDropDownListField() {
        return setQuantityDropDownListField(data.get("QUANTITY"));
    }

    /**
     * Set value to Quantity Drop Down List field.
     *
     * @return the PDPPageFactory class instance.
     */
    public PDPPageFactory setQuantityDropDownListField(String quantityValue) {
        new Select(quantity).selectByVisibleText(quantityValue);
        return this;
    }


    /**
     * Unset default value from Quantity Drop Down List field.
     *
     * @return the PDPPageFactory class instance.
     */
    public PDPPageFactory unsetQuantityDropDownListField() {
        return unsetQuantityDropDownListField(data.get("QUANTITY"));
    }

    /**
     * Unset value from Quantity Drop Down List field.
     *
     * @return the PDPPageFactory class instance.
     */
    public PDPPageFactory unsetQuantityDropDownListField(String quantityValue) {
        new Select(quantity).deselectByVisibleText(quantityValue);
        return this;
    }

 

}
