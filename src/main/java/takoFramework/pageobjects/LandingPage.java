package takoFramework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import takoFramework.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

    WebDriver driver;

   public LandingPage(WebDriver driver) {

       super(driver);
       this.driver = driver;
       PageFactory.initElements(driver, this);

   }

   @FindBy(id = "userEmail")
    WebElement userEmail;

   @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(id = "login")
    WebElement loginBtn;

    @FindBy(css = "[class*='flyInOut']")
    WebElement negativeLogin;

   public ProductsPage Login(String email, String password) {

       userEmail.sendKeys(email);
       userPassword.sendKeys(password);
       loginBtn.click();
       ProductsPage productsPage = new ProductsPage(driver);
       return productsPage;

   }

    public void goTo() {

        driver.get("https://rahulshettyacademy.com/client");

    }

    public String getNegativeLoginText() {

       waitForWebElementToAppear(negativeLogin);
       return negativeLogin.getText();

    }
}
