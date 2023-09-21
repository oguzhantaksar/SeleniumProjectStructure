package takoFramework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import takoFramework.AbstractComponents.AbstractComponent;

import java.util.List;


public class CartPage extends AbstractComponent {
    WebDriver driver;
    public CartPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
       PageFactory.initElements(driver, this);

   }

   @FindBy(css = ".subtotal button")
   WebElement checkoutBtn;

    @FindBy(css = ".cartSection h3")
    List<WebElement> cartProducts;


    public boolean validateCart(String productName) {

        Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }

    public OrderPage goToOrderPage() {
        checkoutBtn.click();
        OrderPage orderPage = new OrderPage(driver);
        return orderPage;

    }

}
