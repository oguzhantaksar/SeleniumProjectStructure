package takoFramework.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import takoFramework.pageobjects.CartPage;
import takoFramework.pageobjects.OrdersPage;

import java.time.Duration;
import java.util.List;

public class AbstractComponent {

    WebDriver driver;

    public AbstractComponent(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[routerlink='/dashboard/cart']")
    WebElement cart;

    @FindBy (css = "[routerlink='/dashboard/myorders']")
    WebElement orders;

//    public void waitForElementToAppear(By locator) {
//
//
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }

    public void waitForWebElementToAppear(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForWebElementsToAppear(List<WebElement> elements) {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }


    public void waitForWebElementToDissappear(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOf(element));

    }

    public CartPage goToCartPage() {

        cart.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;

    }

    public OrdersPage goToOrdersPage () {
        orders.click();
        OrdersPage ordersPage = new OrdersPage(driver);
        return ordersPage;
    }
}
