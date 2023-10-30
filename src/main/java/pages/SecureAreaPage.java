package pages;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject {

    private By logOutButton = By.xpath("//a[@class='button secondary radius']");
    private By msgShowedLocator = By.id("flash");

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    public void waitForBannerMsg() {
        waitForVisibilityOf(msgShowedLocator, Duration.ofSeconds(5));
    }

    public String getMessageShowed() {
        return find(msgShowedLocator).getText();
    }

}
