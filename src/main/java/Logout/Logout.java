package Logout;

import Master.MainObjects.BaseObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Logout extends BaseObjects {

    WebDriver driver;

    public Logout(WebDriver driver) {
        this.driver = driver;
    }

    public void clickingLogout() throws InterruptedException {

        // Clicking The Profile Button On The Right Side Corner
//      WebDriverWait wait = new WebDriverWait ( driver, Duration.ofSeconds ( 30 ) );
        Thread.sleep ( 20000 );
        WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) ); // Adjust timeout as needed
        WebElement clickingProfile = wait.until ( ExpectedConditions.visibilityOfElementLocated ( By.xpath ( "//*[@class=\"ant-avatar ant-avatar-circle ant-avatar-image ant-dropdown-trigger image css-xu9wm8\"]" ) ) );
        clickingProfile.click ();
        testCase.createTest ( "Clicked The Profile Button" );
        System.out.println ( "Successfully Clicked The Profile Button" );

        // Clicking The Logout Button
        WebDriverWait wait1 = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
        Thread.sleep ( 5000 );
        WebElement clickingLogoutButton = driver.findElement ( By.xpath ( "//*[text()='Logout']" ) );
        clickingLogoutButton.click ();
        testCase.createTest ( "Clicked The Logout Button" );
        System.out.println ( "Successfully Clicked The Logout Button" );

        // Clicking The No Button In The Logout Popup
        Thread.sleep ( 5000 );
        WebElement clickingNo = driver.findElement ( By.xpath ( "//span[text()='No']" ) );
        clickingNo.click ();
        testCase.createTest ( "Clicked The No Button" );
        System.out.println ( "Successfully Clicked The No Button In The Logout Popup" );

        Thread.sleep ( 20000 );
//        wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) );
        clickingProfile = wait.until ( ExpectedConditions.visibilityOfElementLocated ( By.xpath ( "//*[@class=\"ant-avatar ant-avatar-circle ant-avatar-image ant-dropdown-trigger image css-xu9wm8\"]" ) ) );
        clickingProfile.click ();
        testCase.createTest ( "Clicked The Profile Button Again To Logout The Website" );
        System.out.println ( "Successfully Clicked The Profile Button Again To Logout The Website" );

        // Clicking The Logout Button
        wait1 = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
        Thread.sleep ( 5000 );
        clickingLogoutButton = driver.findElement ( By.xpath ( "//*[text()='Logout']" ) );
        clickingLogoutButton.click ();
        testCase.createTest ( "Clicked The Logout Button Again" );
        System.out.println ( "Successfully Clicked The Logout Button" );

        // Clicking The Yes Button In The Logout Popup
        Thread.sleep ( 5000 );
        WebElement clickingYes = driver.findElement ( By.xpath ( "//*[text()='Yes']" ) );
        clickingYes.click ();
        testCase.createTest ( "Clicked The Yes Button,Navigated to The Login Page" );
        System.out.println ( "Successfully Clicked The Yes Button,Navigated to The Login Page" );

    }
}
