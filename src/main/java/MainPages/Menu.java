package MainPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
        // Clicking the "Login With Google" button
        WebElement loginWithGoogleButton = driver.findElement(xpath("//span[text()='Log in with Google']"));
        loginWithGoogleButton.click();

        // Window Handling

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parent = iterator.next();
        String child = iterator.next();
        driver.switchTo().window(child);
    }

    @Test

    public void enteringMailId() {
        // Entering the email ID
        WebElement enteringMailId = driver.findElement(id("identifierId"));
        enteringMailId.sendKeys("harishpsy12@gmail.com");
    }


    }





