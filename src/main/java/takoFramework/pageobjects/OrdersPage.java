package takoFramework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import takoFramework.AbstractComponents.AbstractComponent;

import java.util.List;


public class OrdersPage extends AbstractComponent {
    WebDriver driver;
    public OrdersPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
       PageFactory.initElements(driver, this);

   }


    @FindBy(css = ".ng-star-inserted tr td:nth-child(3)")
    List<WebElement> ordersNames;

    public List<WebElement> getOrdersList() {

        waitForWebElementsToAppear(ordersNames);
        return ordersNames;
    }


    public Boolean validateOrder (String productName) {

       Boolean match = getOrdersList().stream().anyMatch( orderName -> orderName.getText().equalsIgnoreCase(productName));
       return match;

    }


}

