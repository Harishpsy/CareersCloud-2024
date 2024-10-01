package Menu;

import PageObjectModule.InviteFriendspageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static PageObjectModule.InviteFriendspageobject.clickingHomeButton;
import static PageObjectModule.InviteFriendspageobject.clickingInviteFriends;

public class inviteFriends {
    WebDriver driver;
    public inviteFriends(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void InviteFriends() throws InterruptedException {

        PageFactory.initElements ( driver , InviteFriendspageobject.class ); // Using (POM)

        // Clicking The Invite Friends
        Thread.sleep ( 3000 );
        clickingInviteFriends.click ();
        System.out.println ( "Invite Friends feature is still under developing process" );

        // Clicking The Home Button
        Thread.sleep ( 5000 );
        clickingHomeButton.click ();

    }
}
