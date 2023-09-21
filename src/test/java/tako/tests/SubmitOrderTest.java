package tako.tests;

import org.apache.commons.io.FileUtils;
import org.apache.hc.client5.http.impl.routing.SystemDefaultRoutePlanner;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tako.TestComponents.BaseTest;
import takoFramework.pageobjects.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {

    String productName = "ZARA COAT 3";
    @Test(dataProvider = "getDatas", groups = {"order"})
    public void submitOrder(HashMap<String, String> input) throws IOException {


        ProductsPage productsPage = landingPage.Login(input.get("email"), input.get("password"));
        List<WebElement> products = productsPage.getProductsList();
        productsPage.addProductToCart(input.get("productName"));
        CartPage cartPage = productsPage.goToCartPage();
        Boolean match = cartPage.validateCart(input.get("productName"));
        Assert.assertTrue(match);
        OrderPage orderPage = cartPage.goToOrderPage();
        orderPage.selectCountry("india");
        ThanksPage thanksPage = orderPage.placeOrder();
        String thanksMessage = thanksPage.controlThanks();
        Assert.assertTrue(thanksMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    @Test(dependsOnMethods = {"submitOrder"})
    public void validateOrderFromOrdersPage () {

        ProductsPage productsPage = landingPage.Login("oguzhantaksar@hotmail.com","Master25%");
        OrdersPage ordersPage = productsPage.goToOrdersPage();
        Boolean match = ordersPage.validateOrder(productName);
        Assert.assertTrue(match);
    }







    @DataProvider
    public Object[][] getDatas () throws IOException {
       List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir") + "/src/test/java/tako/Data/PurchaseOrder.json");
        return new Object[][] {{data.get(0)}, {data.get(1)}};
    }
}