package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.CsvDataProviders;
import base.TestUtilities;
import pages.LoginPage;
import pages.WelcomePage;

public class LoginTests extends TestUtilities {

    @Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
    public void loginTest(Map<String, String> testDate) {
        // Data
        String no = testDate.get("no");
        String username = testDate.get("username");
        String password = testDate.get("password");
        String expectedMessage = testDate.get("expectedMessage");
        String description = testDate.get("description");

        System.out.println("Starting negativeLogInTest #" + no + " for " + description);

        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.openWelcomePage();

        // Click on form Auth
        LoginPage loginPage = welcomePage.clickOnFormAuth();

        // Enter username and password
        loginPage.logInWithCreds(username, password);

        // Wait for msg expected is showed
        loginPage.waitForErrorMsg();

        // Asserts
        Assert.assertTrue(loginPage.getErrorMsgText().contains(expectedMessage),
                "Actual error msg does not contain expected one.");
    }

}
