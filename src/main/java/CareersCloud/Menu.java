package CareersCloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;


public class Menu {
    WebDriver driver = new ChromeDriver ();

    @BeforeTest
    public void setup() throws InterruptedException {

        // Entering the url

        driver.get ("https://careerscloud.in/");
        driver.manage ().window ().maximize ();
        Thread.sleep (3000);
    }

    @Test
    public void loginWithGoogleButton() {

        // Clicking Login With Google Button

        WebElement clickingLoginWithGoogleButton = driver.findElement (xpath ("//span[text()='Log in with Google']"));
        clickingLoginWithGoogleButton.click ();
    }

    @Test
    public void windowsHandeling() {

        // Windows Handeling

        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> iterator = windows.iterator ();
        String parent = iterator.next ();
        String child = iterator.next ();
        driver.switchTo ().window (child);
    }

    @AfterTest

    public void enteringMailId() {

        //Entering the mailId

        WebElement Entering_mailId = driver.findElement (id ("identifierId"));
        Entering_mailId.sendKeys ("harishpsy122@gmail.com");

        //Clicking the next button

        WebElement Nextbutton = driver.findElement (xpath ("//span[text()='Next']"));
        Nextbutton.click ();

    }
    @Test

    public void clickingNextButton () {



    }

}

