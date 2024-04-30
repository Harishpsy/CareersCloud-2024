package MainPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Register_page {
    public static void main(String[] args) throws InterruptedException {

        // Setup for browser launch

        WebDriver driver = new ChromeDriver ();

        // Entering the url

        driver.get ("https://careerscloud.in/");
        driver.manage ().window ().maximize ();

        // Waiting for element visible

        Thread.sleep (3000);

        // Clicking the login button

        WebElement LoginButton = driver.findElement (By.xpath ("//span[text()='Log in with Google']"));
        LoginButton.click ();
        Thread.sleep (3000);

        //Windows Handeling

        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window (child);

        //Entering the mailId

        WebElement Entering_mailId = driver.findElement (By.id ("identifierId"));
        Entering_mailId.sendKeys ("harishpsy122@gmail.com");

        //Clicking the next button

        WebElement Nextbutton = driver.findElement (By.xpath ("//span[text()='Next']"));
        Nextbutton.click ();

        //Entering Password

        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds (30)); // 30 seconds timeout
        WebElement passwordField = wait.until (ExpectedConditions.elementToBeClickable (By.xpath ("//*[@name='Passwd']")));
        wait.until (ExpectedConditions.visibilityOf (passwordField));
        passwordField.sendKeys ("H@ri$H_122");

        //Clicking the next button

        //wait = new WebDriverWait (driver, Duration.ofSeconds (30));

        WebElement Next_button = driver.findElement (By.xpath ("//span[text()='Next']"));
        Next_button.click ();

        //Clicking the Continue_button

        Thread.sleep (3000);
        WebElement Continuebutton = driver.findElement (By.xpath ("//span[text()='Continue']"));
        Continuebutton.click ();
        driver.switchTo ().window (parent);

        // Scroll to the element

        Thread.sleep (3000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep (1000);
        WebElement lastName_textField = driver.findElement (By.xpath ("//*[@id=\"last_name\"]"));
        jse.executeScript ("arguments[0].scrollIntoView(true);", lastName_textField);
        lastName_textField.sendKeys ("psy");

        // Entering the mobile number

        WebElement mobile_NumberEnter = driver.findElement (By.xpath ("//*[@id=\"mobile_number\"]"));
        mobile_NumberEnter.sendKeys ("8148296804");

        // Entering the pincode

        WebElement pincode_Entering = driver.findElement (By.xpath ("//*[@id=\"pincode\"]"));
        pincode_Entering.sendKeys ("600126");

        // preparing for state psc

        WebElement preparingForStatePsc = driver.findElement (By.xpath ("//*[@id=\"prefered_location_id\"]"));
        preparingForStatePsc.click ();

        // Scroll the popup

        WebElement tamilNaduPsc = driver.findElement (By.xpath ("//*[@title=\"Tamil Nadu PSC\"]"));
        Actions actions = new Actions (driver);
        Thread.sleep (3000);
        actions.scrollToElement (tamilNaduPsc).perform ();
        tamilNaduPsc.click ();


    }
}

