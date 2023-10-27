package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {

    private By userNameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By loginButton = By.xpath("//button[@class='radius']");

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

}
