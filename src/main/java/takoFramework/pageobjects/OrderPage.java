package takoFramework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import takoFramework.AbstractComponents.AbstractComponent;


public class OrderPage extends AbstractComponent {
    WebDriver driver;
    public OrderPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
       PageFactory.initElements(driver, this);

   }


   @FindBy (css = "[placeholder='Select Country']")
   WebElement countryDropdown;

    @FindBy ( css = ".btnn")
     WebElement placeOrderBtn;

    @FindBy( css = ".ta-item.list-group-item:nth-child(3)")
    WebElement countryName;



    public void selectCountry(String country) {

    countryDropdown.sendKeys(country);
    waitForWebElementToAppear(countryName);
    countryName.click();


    }

    public ThanksPage placeOrder () {

        placeOrderBtn.click();
        ThanksPage thanksPage = new ThanksPage(driver);
        return thanksPage;
    }


}

