package Menu;

import PageObjectModule.Mypurchasepageobject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static PageObjectModule.Mypurchasepageobject.clickingHomeButton;
import static PageObjectModule.Mypurchasepageobject.clickingMyPurchase;

public class Menu_MyPurchase {
    WebDriver driver;

    public Menu_MyPurchase(WebDriver driver) {
        this.driver = driver;
    }

    public void MyPurchase() throws InterruptedException {

        PageFactory.initElements (driver, Mypurchasepageobject.class);

        // Clicking The My Purchase

        Thread.sleep (5000);
        clickingMyPurchase.click ();
        System.out.println ("SucessFully Clicked MyPurchase");

        //Scrolling Down Function

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo( 0, document.body.scrollHeight)");

        //Scrolling up Function

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(document.body.scrollHeight, 0 )");

        // Clicking The Home Button

        clickingHomeButton.click ();
    }


}
