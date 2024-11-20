package LoginPage;

import Master.MainObjects.BaseObjects;
import PageObjectModule.Loginpageobject;
import ScreenShot.ScreenShot;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import static PageObjectModule.Loginpageobject.*;

public class Loginpage extends BaseObjects {
    WebDriver driver;

    public Loginpage(WebDriver driver) {
        this.driver = driver;
    }

    @Test(enabled = true)
    public void login() throws InterruptedException, IOException {
        driver.get ( "https://careerscloud.in" );
        ScreenShot.captureScreenshot ( "Navigated to Website" );

        driver.manage ().window ().maximize ();
        driver.manage ().deleteAllCookies ();
        Thread.sleep ( 5000 );

        PageFactory.initElements ( driver , Loginpageobject.class );

        Thread.sleep ( 7000 );
        LoginButton.click ();
        ScreenShot.captureScreenshot ( "Clicked Login Button" );
        System.out.println ( "Successfully Clicked the Login Button" );

        switchToChildWindow ();

        Thread.sleep ( 5000 );
        Entering_mailID.sendKeys ( "harishpsy12@gmail.com" );
        ScreenShot.captureScreenshot ( "Entered Email ID" );
        Nextbutton.click ();
        ScreenShot.captureScreenshot ( "Clicked Next Button" );
        System.out.println ( "Successfully Clicked the Next Button" );

        enterPassword ();

        Thread.sleep ( 7000 );
        Continuebutton.click ();
        ScreenShot.captureScreenshot ( "Clicked Continue Button" );
        System.out.println ( "Successfully Clicked the Continue Button" );

        switchToParentWindow ();
    }

    private void switchToChildWindow() throws IOException {
        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window ( child );
        ScreenShot.captureScreenshot ( "Switched to Child Window" );
    }

    private void switchToParentWindow() throws IOException {
        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        driver.switchTo ().window ( parent );
        ScreenShot.captureScreenshot ( "Switched to Parent Window" );
    }

    private void enterPassword() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 40 ) );
        wait.until ( ExpectedConditions.visibilityOf ( passwordField ) );
        passwordField.sendKeys ( "Harish@1998" );
        ScreenShot.captureScreenshot ( "Entered Password" );
        Thread.sleep ( 2000 );
        Nextbutton.click ();
        ScreenShot.captureScreenshot ( "Clicked Next Button" );
        System.out.println ( "Successfully Clicked the Next Button" );
    }
    /**
     * Captures a screenshot for the current browser state and saves it with a unique name.
     *
     * @param actionName Description of the action performed.
     */



}
