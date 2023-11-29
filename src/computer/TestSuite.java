package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;


public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setupBrowser() {
        openBrowserForSetUp(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        clickOnElement(By.xpath("//a[@href='/computers']"));

        //1.2 Click on Desktop
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));

        //1.3 Select Sort By position "Name: Z to A"
        selectFromDropDownMenu(By.name("products-orderby"), "Name: Z to A");

        //1.4 Verify the Product will arrange in Descending order.
        verifyElements("error", "Name: Z to A", By.xpath("//option[contains(text(),'Name: Z to A')]"));

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() {

        clickOnElement(By.xpath("//a[@href='/computers']"));
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));
        selectFromDropDownMenu(By.name("products-orderby"), "Name: A to Z");
        clickOnElement(By.xpath("(//button[@type='button'][normalize-space()='Add to cart'])[1]"));
        verifyElements("error", "Build your own computer", By.xpath("//h1[contains(text(),'Build your own computer')]"));
        selectFromDropDownMenu(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
        selectFromDropDownMenu(By.id("product_attribute_2"), "8GB [+$60.00]");
        clickOnElement(By.id("product_attribute_3_7"));
        clickOnElement(By.id("product_attribute_4_9"));
        clickOnElement(By.id("product_attribute_5_12"));
        verifyElements("error", "$1,470.00", By.id("price-value-1"));
        clickOnElement(By.id("add-to-cart-button-1"));
        verifyElements("error", "The product has been added to your shopping cart", By.xpath("//p[@class='content']"));
        clickOnElement(By.xpath("//span[@title='Close']"));
        mouseHoverOnElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        verifyElements("error", "Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));
        WebElement quantity = driver.findElement(By.xpath("//td[@class=quantity]/child::input"));
        quantity.clear();
        quantity.sendKeys("2");
        clickOnElement(By.id("updatecart"));
        verifyElements("error", "$2,950.00", By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
        clickOnElement(By.id("termsofservice"));
        clickOnElement(By.id("checkout"));
        verifyElements("error", "Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Simon");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Cowell");
        sendTextToElement(By.id("BillingNewAddress_Email"), "SimonCowellPeter100@gmail.com");
        sendTextToElement(By.id("BillingNewAddress_Company"), "SC Limited");
        selectFromDropDownMenu(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "14A High Street");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "DA157YN");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "1234567");
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        clickOnElement(By.id("shippingoption_1"));
        clickOnElement(By.xpath("(//button[@class='button-1 shipping-method-next-step-button'])[1]"));
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        verifyElements("error", "Thank you", By.xpath("//h1[contains(text(),'Thank you')]"));
        verifyElements("error", "Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        verifyElements("error", "Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]"));

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
