package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;

    @Parameters({ "browser" })
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("firefox") String browser) {

        // Create an instance set the driver to the variable
        BrowserDriverFactory browserDriverFactory = new BrowserDriverFactory(browser);
        driver = browserDriverFactory.createDriver();

        // Open the main test page
        String url = "https://the-internet.herokuapp.com";
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
