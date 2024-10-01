package Menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.By.xpath;

public class rateApp {

    WebDriver driver;
    public rateApp(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void RateApp() throws InterruptedException {

        // Clicking The Rate App
        Thread.sleep ( 3000 );
        WebElement clickingRateApp = driver.findElement ( xpath ( "//*[@id=\"7\"]" ) );
        clickingRateApp.click ();

        //Windows Handeling child to parent
        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window ( child );
        driver.close ();
        Thread.sleep ( 3000 );
        driver.switchTo ().window ( parent );

    }
}
