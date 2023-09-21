package takoFramework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import takoFramework.AbstractComponents.AbstractComponent;


public class ThanksPage extends AbstractComponent {
    WebDriver driver;
    public ThanksPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
       PageFactory.initElements(driver, this);

   }


   @FindBy (css = ".hero-primary")
   WebElement thanksHeader;


    public String controlThanks() {

        return thanksHeader.getText();
    }
}

