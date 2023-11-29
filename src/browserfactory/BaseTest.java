package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BaseTest {

    static String browser = "Chrome";
    public static WebDriver driver;

    public void openBrowserForSetUp(String baseUrl) {

        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Internet Explorer")) {
            driver = new InternetExplorerDriver();
        } else System.out.println("Wrong Browser Name");

        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public void closeBrowser() {
        driver.quit();
    }
}
