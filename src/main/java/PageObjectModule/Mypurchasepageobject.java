package PageObjectModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Mypurchasepageobject {

    // Clicking The My Purchase

    @FindBy(xpath = "//*[@id=\"8\"]")
    public static WebElement clickingMyPurchase;

    // Clicking The Home Button

    @FindBy(xpath = "//a[text()='Home']")
    public static WebElement clickingHomeButton;


}
