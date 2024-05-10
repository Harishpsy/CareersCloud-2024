package FeatureReference;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static MainPages.Login_page.driver;
import static org.openqa.selenium.By.xpath;

public class VeriyingCardCountInWebpage {

    public void VeriyingCardCount() {

        //  Method for Counting How many Cards present in the list

        List<WebElement> articleCards = new ArrayList<> ();

        // Add elements using either XPath or loop through individual cards

        articleCards.addAll (driver.findElements (xpath ("//*[text()='GA Questions Asked in SBI Clerk Mains Exam 2023 - 2024']")));
        articleCards.addAll (driver.findElements (xpath ("//*[text()='SBI Clerk Prelims Exam 2023 Quants - Self Analysis']")));

        // Verification (assuming you have a way to verify the expected number of cards)

        int expectedCards = 10; // Replace with your expected number
        if (articleCards.size () == expectedCards) {
            System.out.println ("List of article cards verified. Found " + articleCards.size () + " cards.");
        } else {
            System.out.println ("List verification failed. Expected " + expectedCards + ", found " + articleCards.size () + " cards.");
        }

    }
}
