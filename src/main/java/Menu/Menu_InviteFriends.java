package Menu;

import PageObjectModule.InviteFriendspageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static PageObjectModule.InviteFriendspageobject.clickingHomeButton;
import static PageObjectModule.InviteFriendspageobject.clickingInviteFriends;

public class Menu_InviteFriends {

    WebDriver driver;

    public Menu_InviteFriends(WebDriver driver) {
        this.driver = driver;
    }

    public void InviteFriends() throws InterruptedException {

        PageFactory.initElements (driver, InviteFriendspageobject.class);

        // Clicking The Invite Friends

        Thread.sleep (3000);
        clickingInviteFriends.click ();
        System.out.println ("This feature is still under developing process");

        // Clicking The Home Button

        Thread.sleep (5000);
        clickingHomeButton.click ();

    }
}
