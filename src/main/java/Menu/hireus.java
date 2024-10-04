package Menu;

import PageObjectModule.Hireuspageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

import static PageObjectModule.Hireuspageobject.clickingHireUs;

/**
 * The hireus class provides functionality to interact with the "Hire Us" feature in a web application.
 * It uses the Page Object Model (POM) to interact with web elements and handle windows for navigation.
 */
public class hireus {
    WebDriver driver;
    public hireus(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void Hireus() throws InterruptedException {

        // Page Factory Method (POM)
        PageFactory.initElements ( driver , Hireuspageobject.class );

        // Clicking The Hire US Button
        Thread.sleep ( 3000 );
        clickingHireUs.click ();

        //Windows Handeling child to parent and parent to child
        Thread.sleep ( 5000 );
        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window ( child );

        // Closing the new tab
        driver.close ();

        // Navigating to parent tab
        driver.switchTo ().window ( parent );

    }
}
