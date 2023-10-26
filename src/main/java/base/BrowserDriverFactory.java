package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.log4testng.Logger;

public class BrowserDriverFactory {

    /** In order to run test in parallel we need to create the ThreadLocal */
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private String browser;
    private Logger log;

    /** Creating constructor that will receive browser type and log */
    public BrowserDriverFactory(String browser, Logger log) {
        this.browser = browser;
        this.log = log;
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

            default:
                log.info("Don't know how to start this browser '" + browser + "', instead starting chrome.");
                driver.set(new ChromeDriver());
                break;
        }

        return driver.get();
    }
}
