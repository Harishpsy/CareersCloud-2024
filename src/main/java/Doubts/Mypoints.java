package Doubts;

import Menu.myPoints;
import PageObjectModule.Mypointspageobject;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import static PageObjectModule.Mypointspageobject.*;

public class Mypoints {
    WebDriver driver;

    public Mypoints(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void myPoints() throws InterruptedException {

        PageFactory.initElements ( driver , Mypointspageobject.class );

        // Clicking My Points
        myPoints Mypoints = new myPoints ( driver );

        try {
            Thread.sleep (5000);
            WebElement clickingMyPointsPage = driver.findElement (By.xpath ("//*[text()='My Points']"));

            if (clickingMyPointsPage.isSelected ()) {
                Thread.sleep ( 3000 );
                System.out.println ( "My points Button was already Selected" );
            } else if (clickingMyPointsPage.isDisplayed ()) {
                Thread.sleep ( 5000 );
                clickingMyPointsPage.click ();
                System.out.println ( "Successfully clicked the My Points button" );
            } else {
                System.out.println ( "Error Occured In The Above Code" );
            }

            if (clickingMyPointsPage.isSelected ()) {

                // Clicking View Earn Points
                Thread.sleep (5000);
                clickingViewEarnPoints.click ();
                System.out.println ("My Points Already Clicked");
            } else if (clickingMyPointsPage.isEnabled ()) {
                Thread.sleep (5000);
                clickingViewEarnPoints.click ();
                System.out.println ("Successfully Navigated To The Menu Mypoint and clicked The View earn Point");

            } else {
                System.out.println ("My Points page code error");
            }

            // Clicking The close Button
            Thread.sleep (5000);
            clickingCloseIcon.click ();
            System.out.println ("Successfully CLicked The Close Incon the My Points Doubt page");

            //Scrolling Down Function
            Thread.sleep (5000);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");
            System.out.println ("Successfully Scrolled the My Points Doubt page");

            // Clicking The Dropdown Menu
            Thread.sleep (5000);
            Actions actions = new Actions (driver);
            actions.scrollToElement (clickingDropDown).perform ();
            clickingDropDown.click ();
            System.out.println ("Successfully Clicked the My Points Doubt page");

            // Clicking The Home Button
            Thread.sleep (5000);
            clickingHomeButton.click ();
            System.out.println ("SuccessFully Clicked The Home Button From The  Doubt > Mypoints ");

        } catch (NoSuchElementException e) {

            System.out.println ("Error On The Above code" + e.getMessage ());

        }

    }


}
