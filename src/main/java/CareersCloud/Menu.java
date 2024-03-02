package CareersCloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;


public class Menu {
    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setup() throws InterruptedException {

        // Entering the url

        driver.get("https://careerscloud.in/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test
    public void loginWithGoogleButton() {

        // Clicking Login With Google Button

        WebElement clickingLoginWithGoogleButton = driver.findElement(By.xpath("//span[text()='Log in with Google']"));
        clickingLoginWithGoogleButton.click();
    }

    @Test
    public void windowsHandeling(){

        // Windows Handeling

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parent = iterator.next();
        String child = iterator.next();
        driver.switchTo().window(child);

    }

}

