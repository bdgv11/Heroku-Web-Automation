package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {

    private By userNameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By loginButton = By.xpath("//button[@class='radius']");
    private By errorMsgShowed = By.id("flash");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public SecureAreaPage logInWithCreds(String username, String password) {
        typeOnElement(userNameLocator, username);
        typeOnElement(passwordLocator, password);
        clickOnElement(loginButton);
        return new SecureAreaPage(driver);
    }

    public void waitForErrorMsg() {
        waitForVisibilityOf(errorMsgShowed, Duration.ofSeconds(5));
    }

    public String getErrorMsgText() {
        return find(errorMsgShowed).getText();
    }

}
