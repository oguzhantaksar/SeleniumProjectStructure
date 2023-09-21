package tako.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tako.TestComponents.BaseTest;
import tako.TestComponents.Retry;
import takoFramework.pageobjects.CartPage;
import takoFramework.pageobjects.OrderPage;
import takoFramework.pageobjects.ProductsPage;
import takoFramework.pageobjects.ThanksPage;

import java.io.IOException;
import java.util.List;

public class NegativeValidationsTest extends BaseTest {

    @Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
    public void validateLoginNegative() throws IOException {

        landingPage.Login("oguzhantaksarnegative@hotmail.com","Master255%");
        Assert.assertEquals("Incorrect email or password.", landingPage.getNegativeLoginText());      ;
    }

    @Test
    public void validateProductNegative() throws IOException {

        String productName = "ZARA COAT 3";
        String negativeProductName = "ZARA COAT 2";
        ProductsPage productsPage = landingPage.Login("oguzhantaksar2@hotmail.com","Master25%");
        List<WebElement> products = productsPage.getProductsList();
        productsPage.addProductToCart(productName);
        CartPage cartPage = productsPage.goToCartPage();
        Boolean match = cartPage.validateCart(negativeProductName);
        Assert.assertFalse(match);
    }
}

