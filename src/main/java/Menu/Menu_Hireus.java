package Menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.By.xpath;

public class Menu_Hireus {

    WebDriver driver;

    public Menu_Hireus(WebDriver driver) {

        this.driver = driver;

    }

    public void Hireus() throws InterruptedException {
        // Clicking The Hire US Button

        Thread.sleep (3000);
        WebElement clickingHireUs = driver.findElement (xpath ("//*[@id=\"9\"]"));
        clickingHireUs.click ();

        //Windows Handeling child to parent and parent to child

        Thread.sleep (5000);
        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window (child);
        driver.close ();
        driver.switchTo ().window (parent);

    }
}
