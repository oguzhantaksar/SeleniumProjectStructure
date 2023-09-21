package takoFramework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import takoFramework.AbstractComponents.AbstractComponent;

import java.util.List;


public class ProductsPage extends AbstractComponent {
    WebDriver driver;
    public ProductsPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
       PageFactory.initElements(driver, this);

   }


   @FindBy(css = ".card-body")
   List <WebElement> products;

    @FindBy(css="#toast-container")
    WebElement toastMessage;


    By addToCardBy = By.cssSelector(".btn.w-10");

    // By toastMessage = By.cssSelector("#toast-container");


   public List<WebElement> getProductsList() {

       waitForWebElementsToAppear(products);
       return products;
   }

    public WebElement getProductByName (String productName) {

        WebElement wantedProduct = getProductsList().stream()
                .filter(product ->
                        product.findElement(By.cssSelector(".card-body h5"))
                                .getText()
                                .equalsIgnoreCase(productName))
                .findFirst().orElse(null);
        return wantedProduct;
    }

    public void addProductToCart(String productName) {

       getProductByName(productName).findElement(addToCardBy).click();
       waitForWebElementToDissappear(driver.findElement(By.cssSelector(".ng-animating")));
       waitForWebElementToAppear(toastMessage);

    }
}

