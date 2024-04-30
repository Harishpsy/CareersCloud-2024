package Menu;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.xpath;

public class Menu_MyPurchase {
    WebDriver driver;

    public Menu_MyPurchase(WebDriver driver) {
        this.driver = driver;
    }

    public void MyPurchase() throws InterruptedException {
        // Clicking The My Purchase

        Thread.sleep (5000);
        WebElement clickingMyPurchase = driver.findElement (xpath ("//*[@id=\"8\"]"));
        clickingMyPurchase.click ();
        System.out.println ("SucessFully Clicked MyPurchase");

        //Scrolling Down Function

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo( 0, document.body.scrollHeight)");

        //Scrolling up Function

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(document.body.scrollHeight, 0 )");

        // Clicking The Home Button

        WebElement clickingHomeButton = driver.findElement (xpath ("//a[text()='Home']"));
        clickingHomeButton.click ();
    }


}
