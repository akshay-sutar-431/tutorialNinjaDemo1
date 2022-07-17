package tests;

import resources.Base;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

import java.io.IOException;

public class LoginTest extends Base {

    WebDriver driver;

    @Test(dataProvider = "getLoginData")
    public void login(String username, String password, String expectedStatus) throws IOException {

        HomePage hp = new HomePage(driver);
        LoginPage lp = new LoginPage(driver);

        hp.myAccountDropDown().click();
        hp.getLoginOption().click();
        lp.getUsernameField().sendKeys(username); //user123@gmail.com
        log.debug("Username Passed");
        lp.getPasswordField().sendKeys(password); //user
        log.debug("Password Passed");
        //lp.getUsernameField().sendKeys(prop.getProperty("username"));
        //lp.getPasswordField().sendKeys(prop.getProperty("password"));
        lp.getLoginButton().click();
        log.debug("Clicked on Login Button");

        AccountPage accountPage = new AccountPage(driver);
        String actualResult;

        try {
            accountPage.getEditAccountInfo();
            actualResult = "Passed";

        }
        catch (Exception e)
        {
            actualResult = "Failure";
        }

        Assert.assertEquals(actualResult, expectedStatus);

        //tearDown();
    }

    @DataProvider
    public Object[][] getLoginData()
    {
        Object[][] data = {
                {"user", "user", "Failure"},
                {"user123@gmail.com", "user", "Passed"},
                {"abc@gmail.com", "abc", "Failure"}
        };
        return data;
    }

    @AfterMethod
    public void closure(){
        driver.close();
    }

    @BeforeMethod
    public void setup() throws IOException {

        log = LogManager.getLogger(LoginTest.class.getName());

        driver = initializeDriver();
        log.debug("Browser initialized");
        driver.get(prop.getProperty("appURL"));
        log.debug("Application launched");
    }
}
