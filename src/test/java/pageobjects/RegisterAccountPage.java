package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Base;

public class RegisterAccountPage {
    WebDriver pdriver;
    public RegisterAccountPage(WebDriver driver)
    {
        pdriver = driver;
        PageFactory.initElements(pdriver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    @CacheLookup
    private WebElement myAccount;

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    @CacheLookup
    private WebElement register;

    @FindBy(id = "input-firstname")
    @CacheLookup
    private WebElement fistName;

    @FindBy(id = "input-lastname")
    @CacheLookup
    private WebElement lastName;

    @FindBy(id = "input-email")
    @CacheLookup
    private WebElement emailId;

    @FindBy(id = "input-telephone")
    @CacheLookup
    private WebElement telePhone;

    @FindBy(id = "input-confirm")
    @CacheLookup
    private WebElement confirmPassword;

    @FindBy(name = "password")
    @CacheLookup
    private WebElement password;

    @FindBy(xpath = "//input[@name='newsletter' and @value=1]")
    @CacheLookup
    private WebElement subscribeYes;

    @FindBy(xpath = "//input[@name='newsletter' and @value=1]")
    @CacheLookup
    private WebElement subscribeNo;

    @FindBy(xpath = "//input[@name='agree' and @value=1]")
    @CacheLookup
    private WebElement privacyPolicyYes;

    @FindBy(xpath = "//input[@type='submit' and @value='Continue']")
    @CacheLookup
    private WebElement continueButton;



    public void clickOnMyAccountAndRegister()
    {
        myAccount.click();
        register.click();
    }

    public void setPersonalDetails(String fName, String lName, String email, String number, String pass, String cPass)
    {
        fistName.sendKeys(fName);
        lastName.sendKeys(lName);
        emailId.sendKeys(email);
        telePhone.sendKeys(number);
        password.sendKeys(pass);
        confirmPassword.sendKeys(cPass);
    }

    public void setNewsletter(String mode)
    {
        if(mode.equalsIgnoreCase("yes"))
        {
            subscribeYes.click();
        }
        else if(mode.equalsIgnoreCase("no"))
        {
            subscribeNo.click();
        }
        else
            System.out.println("Newsletter subscribe: Default");
    }

    public void setPrivacyPolicy(String mode) {
        if (mode.equalsIgnoreCase("yes")) {
            privacyPolicyYes.click();
        } else
            System.out.println("Checkbox: Unchecked");
    }

    public void clickOnContinue()
    {
        continueButton.click();
    }
}
