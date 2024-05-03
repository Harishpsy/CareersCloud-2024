package PageObjectModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Mypointspageobject {

    // Clicking The My Points

    @FindBy(xpath = "//*[@id=\"5\"]")
    public static WebElement clickingMyPoints;

    // Clicking The View Earn Points

    @FindBy(xpath = "//span[text()='View Earn Points']")
    public static WebElement clickingViewEarnPoints;

    // Clicking The close Button

    @FindBy(xpath = "//*[@class=\"ant-modal-close-x\"]")
    public static WebElement clickingCloseIcon;

    // Clicking The Dropdown Menu

    @FindBy(xpath = "//*[@class=\"icon-vector ant-collapse-arrow\"]")
    public static WebElement clickingDropDown;

    // Clicking The Home Button

    @FindBy(xpath = "//a[text()='Home']")
    public static WebElement clickingHomeButton;
}
