package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserDriverFactory {

    /** In order to run test in parallel we need to create the ThreadLocal */
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private String browser;

    /** Creating constructor that will receive browser type and log */
    public BrowserDriverFactory(String browser) {
        this.browser = browser.toLowerCase();

    }

    /**
     * This method will create and return the driver according to the String
     * 'browser' parameter passed. By default will open in Chrome.
     */
    public WebDriver createDriver() {
        switch (browser) {
            case "chrome":
                driver.set(new ChromeDriver());
                break;

            case "firefox":
                driver.set(new FirefoxDriver());
                break;

            case "safari":
                driver.set(new SafariDriver());
                break;

            default:
                driver.set(new ChromeDriver());
                break;
        }

        return driver.get();
    }
}
