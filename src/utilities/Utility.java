package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void mouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void mouseHoverAndClickOnElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }

    public void verifyElements(String displayedMessage,String expectedMessageText, By by) {
        String actualMessageText = getTextFromElement(by);
        Assert.assertEquals(displayedMessage, expectedMessageText, actualMessageText);
    }

    public void selectMenu(String menu) {
        driver.findElement(By.linkText(menu)).click();
    }

    public void selectFromDropDownMenu(By by, String text) {
        WebElement dropDownMenu = driver.findElement(by);
        Select select = new Select(dropDownMenu);
        select.selectByVisibleText(text);
    }

    public void verifyText(String expectedText, String actualText) {

    }
}
