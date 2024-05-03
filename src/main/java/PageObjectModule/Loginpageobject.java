package PageObjectModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpageobject {

    // Clicking the login button
    @FindBy(xpath = "//span[text()='Log in with Google']")
    public static WebElement LoginButton;

    //Entering the mailId

    @FindBy(id = "identifierId")
    public static WebElement Entering_mailID;

    //Clicking the next button

    @FindBy(xpath = "//span[text()='Next']")
    public static WebElement Nextbutton;

    //Entering Password

    @FindBy(xpath = "//*[@name='Passwd']")
    public static WebElement passwordField;

    //Clicking the Continue_button

    @FindBy(xpath = "//span[text()='Continue']")
    public static WebElement Continuebutton;


}
