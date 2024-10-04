package Menu;

import PageObjectModule.Mypointspageobject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static PageObjectModule.Mypointspageobject.*;

/**
 * The myPoints class handles operations related to the "My Points" feature of the web application.
 * It performs actions such as clicking on specific elements, scrolling, and interacting with dropdown menus.
 * This class uses Selenium WebDriver to automate browser actions and JUnit for testing purposes.
 */
public class myPoints {
    WebDriver driver;
    public myPoints(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method tests the "My Points" feature by performing a series of actions on the related web elements.
     * It initializes the page elements, clicks on various points-related buttons, scrolls the page,
     * and interacts with the dropdown menu in the "My Points" section.
     * The method uses Thread.sleep to wait between actions, ensuring that each operation has enough time to complete.
     *
     * @throws InterruptedException if the thread is interrupted while sleeping.
     */
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
