package Menu;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.By.xpath;

public class Menu_MyCoins {

    WebDriver driver;

    public Menu_MyCoins(WebDriver driver) {
        this.driver = driver;
    }

    public void MyCoins() throws InterruptedException {


        // Clicking The My Coin

        Thread.sleep (3000);
        WebElement clickingMycoin = driver.findElement (xpath ("//*[@id=\"4\"]"));
        clickingMycoin.click ();

        // Clicking Coin Earning Arrow

        Thread.sleep (3000);
        WebElement clickingCoinEarningText = driver.findElement (xpath ("//div[text()='Coin Earning']"));
        clickingCoinEarningText.click ();

        // Clicking The close Button

        Thread.sleep (3000);
        WebElement clickingCloseIcon = driver.findElement (xpath ("//*[@class=\"ant-modal-close-x\"]"));
        clickingCloseIcon.click ();

        // Scrolling backward

        Thread.sleep (3000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0, document.body.scrollHeight)");

        //Scrolling forward

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo( document.body.scrollHeight, 0)");

        // clicking The Google Play Button

        WebElement clickingGooglePlayButton = driver.findElement (xpath ("//span[text()='Google Play']"));
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
