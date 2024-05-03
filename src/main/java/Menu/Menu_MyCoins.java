package Menu;

import PageObjectModule.Mycoinpageobject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

import static PageObjectModule.Mycoinpageobject.*;

public class Menu_MyCoins {

    WebDriver driver;

    public Menu_MyCoins(WebDriver driver) {
        this.driver = driver;
    }

    public void MyCoins() throws InterruptedException {

        PageFactory.initElements (driver, Mycoinpageobject.class);

        // Clicking The My Coin

        Thread.sleep (3000);
        clickingMycoin.click ();

        // Clicking Coin Earning Arrow

        Thread.sleep (3000);
        clickingCoinEarningText.click ();

        // Clicking The close Button

        Thread.sleep (3000);
        clickingCloseIcon.click ();

        // Scrolling backward

        Thread.sleep (3000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0, document.body.scrollHeight)");

        //Scrolling forward

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo( document.body.scrollHeight, 0)");

        // clicking The Google Play Button
        clickingGooglePlayButton.click ();

        //Windows Handeling child to parent

        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window (child);
        driver.close ();
        Thread.sleep (3000);
        driver.switchTo ().window (parent);

        //Scrolling forward

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo( document.body.scrollHeight, 0)");

    }
}
