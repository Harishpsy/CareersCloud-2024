package Menu;

import PageObjectModule.Mypointspageobject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static PageObjectModule.Mypointspageobject.*;

public class myPoints {
    WebDriver driver;
    public myPoints(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void MyPoints() throws InterruptedException {

        PageFactory.initElements ( driver , Mypointspageobject.class );

        // Clicking My Points
        Thread.sleep ( 5000 );
        clickingMyPoints.click ();
        System.out.println ( "Successfully Clicked My Points" );

        // Clicking View Earn Points
        Thread.sleep ( 5000 );
        clickingViewEarnPoints.click ();
        System.out.println ( "Successfully Clicked ViewEarnPoints " );

        // Clicking The close Button
        Thread.sleep ( 5000 );
        clickingCloseIcon.click ();
        System.out.println ( "Successfully Clicked CloseIcon" );

        //Scrolling Down Function
        Thread.sleep ( 5000 );
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript ( "window.scrollTo(0,document.body.scrollHeight)" );
        System.out.println ( "Successfully Scroll The Page " );

        // Clicking The Dropdown Menu
        Thread.sleep ( 5000 );
        Actions actions = new Actions ( driver );
        actions.scrollToElement ( clickingDropDown ).perform ();
        clickingDropDown.click ();
        System.out.println ( "Successfully Clicked DropDown" );
    }
}
