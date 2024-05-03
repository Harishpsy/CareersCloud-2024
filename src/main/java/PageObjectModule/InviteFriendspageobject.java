package PageObjectModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InviteFriendspageobject {

    // Clicking The Invite Friends

    @FindBy(xpath = "//*[@id=\"6\"]")
    public static WebElement clickingInviteFriends;

    // Clicking The Home Button

    @FindBy(xpath = "//a[text()='Home']")
    public static WebElement clickingHomeButton;

}
