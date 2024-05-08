package Learning;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

import static MainPages.Login_page.driver;
import static org.openqa.selenium.By.xpath;

public class VerifyingRecentArticlePresent {

    public void RecentArticlePresent() {

        // Verifying the Recent article in the webpage

        String[] articleLinks = {"https://careerscloud.in/course-details/62/article/3758", "https://careerscloud.in/course-details/62/article/3586", "https://careerscloud.in/course-details/62/article/3557", "https://careerscloud.in/course-details/62/article/3510", "https://careerscloud.in/course-details/62/article/3408"};

        List<WebElement> recentArticle = driver.findElements (xpath ("//*[@class=\"ant-list-items\"]/child::*"));

        int count = 0;

        for (WebElement articles : recentArticle) {

            String actualLink = articles.getAttribute ("href");

            if (Arrays.asList (articleLinks).contains (actualLink)) {
                count++;
                System.out.println ("Found " + count + " matching articles");
            }
        }

        Assert.assertEquals (count, articleLinks.length);
        System.out.println (Arrays.toString (articleLinks));


    }

}
