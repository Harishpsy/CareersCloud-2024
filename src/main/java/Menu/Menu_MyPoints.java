package Menu;

import PageObjectModule.Mypointspageobject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import static PageObjectModule.Mypointspageobject.*;

public class Menu_MyPoints {

    WebDriver driver;

    public Menu_MyPoints(WebDriver driver) {
        this.driver = driver;
    }

    public void MyPoints() throws InterruptedException {

        PageFactory.initElements (driver, Mypointspageobject.class);

        // Clicking The My Points

        Thread.sleep (3000);
        clickingMyPoints.click ();

        // Clicking The View Earn Points

        Thread.sleep (3000);
        clickingViewEarnPoints.click ();

        // Clicking The close Button

        Thread.sleep (5000);
        clickingCloseIcon.click ();

        //Scrolling Down Function

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");

        // Clicking The Dropdown Menu

        Actions actions = new Actions (driver);
        actions.scrollToElement (clickingDropDown).perform ();
        clickingDropDown.click ();

        // Clicking The Home Button

        Thread.sleep (2000);
        clickingHomeButton.click ();


    }


}
