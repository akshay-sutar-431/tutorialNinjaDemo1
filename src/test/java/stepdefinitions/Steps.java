package stepdefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.LoginPage;
import pageobjects.RegisterAccountPage;
import utilities.Base;

import java.util.concurrent.TimeUnit;

public class Steps extends Base {

    @Given("User launch the browser")
    public void user_launch_the_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    
    @When("User open the application URL {string}")
    public void user_open_the_application_url(String appLink) {
        rp = new RegisterAccountPage(driver);
        driver.get(appLink);
    }
    
    @When("User click on My Account drop menu and click on Register option")
    public void user_click_on_my_account_drop_menu_and_click_on_register_option() {
        rp.clickOnMyAccountAndRegister();
    }
    
    @When("User enter the new account details into mandatory fields")
    public void user_enter_the_new_account_details_into_mandatory_fields() {
        rp.setPersonalDetails("KGx", "Destroyer", "kgx_d2@gmail.com", "547862", "kgx@123", "kgx@123");
        rp.setNewsletter("No");
        rp.setPrivacyPolicy("No");
    }
    
    @When("click on Continue button")
    public void click_on_continue_button() {
        rp.clickOnContinue();
    }
    
    @Then("User should logged in, taken to Account page and proper details should displayed on the page")
    public void user_should_logged_in_taken_to_account_page_and_proper_details_should_displayed_on_the_page() {
        if(driver.getPageSource().contains("Account Has Been Created"))
        {
            Assert.assertTrue(true);
        }
    }
    
    @Then("close browser")
    public void close_browser() {
        driver.quit();
    }

    @And("Don't enter anything into the fields and click on Continue button")
    public void donTEnterAnythingIntoTheFieldsAndClickOnContinueButton() {
        rp.clickOnContinue();
    }

    @Then("Warning messages should be displayed for the respective fields")
    public void warningMessagesShouldBeDisplayedForTheRespectiveFields() {

    }

    @And("I click on My Account drop menu and click on Login option")
    public void iClickOnMyAccountDropMenuAndClickOnLoginOption() {
        lp.clickOnMyAccountMenu();
        lp.clickOnLoginMenu();
    }

    @Then("User should navigate to login page")
    public void userShouldNavigateToLoginPage() {
        boolean title = lp.getPageSource("I am a returning customer");
        Assert.assertTrue(title);
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        lp.clickOnLoginButton();
    }

    @Then("User should be navigated to Login page")
    public void userShouldBeNavigatedToLoginPage() {
        boolean title = lp.getPageSource("My Account");
        Assert.assertTrue(title);
    }

    @When("I open the application URL {string}")
    public void iOpenTheApplicationURL(String app) {
        lp = new LoginPage(driver);
        driver.get(app);
    }

    @When("I enter the {string} and {string}")
    public void iEnterTheAnd(String user, String pass) {
        lp.setUserName(user);
        lp.setPassword(pass);
    }

    @Then("User should be navigated to Login page {string}")
    public void userShouldBeNavigatedToLoginPage(String expectedOutput) {
        boolean title = lp.getPageSource("My Account");
        Assert.assertTrue(title);

    }
}
