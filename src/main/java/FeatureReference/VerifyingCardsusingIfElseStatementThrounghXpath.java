package FeatureReference;

import org.openqa.selenium.WebElement;

import java.util.List;

import static MainPages.Login_page.driver;
import static org.openqa.selenium.By.xpath;

public class VerifyingCardsusingIfElseStatementThrounghXpath {

    public void reference() throws InterruptedException {


        // Find elements using either XPath or loop through individual cards

        final List<WebElement> mainsCards = driver.findElements (xpath ("//*[text()='GA Questions Asked in SBI Clerk Mains Exam 2023 - 2024']"));
        final List<WebElement> prelimsCards = driver.findElements (xpath ("//*[text()='SBI Clerk Prelims Exam 2023 Quants - Self Analysis']"));

        // Verification (assuming you have a way to verify card existence)

        if (mainsCards.isEmpty ()) {
            System.out.println ("Verification failed: GA Questions not found");
        } else {
            System.out.println ("Found 'GA Questions...' cards.");
        }

        if (prelimsCards.isEmpty ()) {
            System.out.println ("Verification failed: 'SBI Clerk Prelims...' cards not found.");
        } else {
            System.out.println ("SBI Clerk Prelims Found");
        }


    }
}
