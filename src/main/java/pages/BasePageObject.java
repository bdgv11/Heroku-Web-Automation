package pages;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;

    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    /** Open page with giver URL */
    public void openUrl(String url) {
        driver.get(url);
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /** Click on element with given locator when it's visible */
    public void clickOnElement(By locator) {
        waitForVisibilityOf(locator, Duration.ofSeconds(5));
        find(locator).click();
    }

    /**
     * Wait for specific ExpectedCondition for the given amount of time in seconds
     */
    public void waitFor(ExpectedCondition<WebElement> condition, Duration timeout) {
        timeout = timeout != null ? timeout : Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }

    /**
     * Wait for given number of seconds for element with given locator to be visible
     * on the page
     */
    public void waitForVisibilityOf(By locator, Duration... timeout) {
        waitFor(ExpectedConditions.visibilityOfElementLocated(locator), timeout.length > 0 ? timeout[0] : null);
    }

}
