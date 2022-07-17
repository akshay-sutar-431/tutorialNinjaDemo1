package utilities;

import org.openqa.selenium.WebDriver;
import pageobjects.LoginPage;
import pageobjects.RegisterAccountPage;

public class Base {
    public static WebDriver driver;
    public RegisterAccountPage rp;
    public WaitHelper waitHelper;
    public LoginPage lp;

}
