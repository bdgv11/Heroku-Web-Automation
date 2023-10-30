package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {

    // Locators
    private String url = "https://the-internet.herokuapp.com";
    private By formAuthLink = By.linkText("Form Authentication");

    // Methods
    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    /** Open Welcome Page with it's URL */
    public void openWelcomePage() {
        openUrl(url);
    }

    /** Open LoginPage by clicking on Form Auth link */
    public LoginPage clickOnFormAuth() {
        clickOnElement(formAuthLink);
        return new LoginPage(driver);
    }

}
