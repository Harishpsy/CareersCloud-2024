package Menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.xpath;

public class Menu_InviteFriends {

    WebDriver driver;

    public Menu_InviteFriends(WebDriver driver) {
        this.driver = driver;
    }

    public void InviteFriends() throws InterruptedException {
        // Clicking The Invite Friends

        Thread.sleep (3000);
        WebElement clickingInviteFriends = driver.findElement (xpath ("//*[@id=\"6\"]"));
        clickingInviteFriends.click ();
        System.out.println ("This feature is still under developing process");

        // Clicking The Home Button
        Thread.sleep (5000);
        WebElement clickingHomeButton = driver.findElement (xpath ("//a[text()='Home']"));
        clickingHomeButton.click ();

    }
}
