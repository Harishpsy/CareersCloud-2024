package Learning;

import org.openqa.selenium.WebElement;

import static MainPages.Login_page.driver;
import static org.openqa.selenium.By.xpath;

public class ClickingLikeOrUnlike {

    public void LikeOrUnlike() {

        // Clicking the like and unlike button

        WebElement clickAction = driver.findElement (xpath ("//*[contains(@class, 'like') or contains(@class, 'unlike')]"));

        if (clickAction.isDisplayed ()) {
            clickAction.click ();


            if (clickAction.getAttribute ("class").contains ("unlike")) {
                System.out.println (" Un Liked Successfully ");
            } else {
                System.out.println (" Liked Successfully ");
            }
        }

    }
}

