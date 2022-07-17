package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Base;

public class LoginPage extends Base {
    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    @CacheLookup
    private WebElement myAccount;

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    @CacheLookup
    private WebElement loginDropMenu;

    @FindBy(id = "input-email")
    @CacheLookup
    private WebElement usernameField;

    @FindBy(id = "input-password")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(xpath = "//*[@value='Login']")
    @CacheLookup
    private WebElement loginButton;

    public WebElement getUsernameField()
    {
        return usernameField;
    }

    public WebElement getPasswordField()
    {
        return passwordField;
    }

    public WebElement getLoginButton()
    {
        return loginButton;
    }

    public void clickOnMyAccountMenu()
    {
        myAccount.click();
    }

    public void clickOnLoginMenu()
    {
        loginDropMenu.click();
    }

    public void setUserName(String user)
    {
        usernameField.sendKeys(user);
    }

    public void setPassword(String pass)
    {
        passwordField.sendKeys(pass);
    }

    public void clickOnLoginButton()
    {
        loginButton.click();
    }

    public boolean getPageSource(String title)
    {
        return driver.getPageSource().contains(title);
    }
}
