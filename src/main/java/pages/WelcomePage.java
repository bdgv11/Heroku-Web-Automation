package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {

    // Locators
    private String url = "https://the-internet.herokuapp.com";
    private By formAuthLink = By.linkText("Form Authentication");

    // Methods
    public WelcomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Open Welcome Page with it's URL */
    public void openWelcomePage() {
        log.info("Opening Welcome Page");
        openUrl(url);
    }

    /** Open LoginPage by clicking on Form Auth link */
    public LoginPage clickOnFormAuth() {
        clickOnElement(formAuthLink);
        return new LoginPage(driver, log);
    }

}
