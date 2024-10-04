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

    /**
     * Tests the Invite Friends feature of the application.
     *
     * This method automates the process of clicking the "Invite Friends" button
     * and then navigating back to the home screen. It utilizes the Page Object
     * Model for element initialization.
     *
     * @throws InterruptedException if the thread is interrupted while sleeping
     */
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
