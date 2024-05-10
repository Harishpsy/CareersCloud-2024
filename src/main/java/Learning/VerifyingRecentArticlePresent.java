package Learning;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


        // Another Method for verifying Duplicate In The Wep page

        // Assuming 'driver' is an instance of WebDriver initialized earlier

        String[] videosLinks = {"https://careerscloud.in/course-details/6/video/2154", "https://careerscloud.in/course-details/6/video/2158",
                "https://careerscloud.in/course-details/6/video/2162", "https://careerscloud.in/course-details/6/video/2160",
                "https://careerscloud.in/course-details/6/video/2155"};

        Set<String> uniqueLinks = new HashSet<> ();
        int duplicateCount = 0;

        List<WebElement> recentVideos = driver.findElements (xpath ("//*[@class=\"ant-list-items\"]/child::*"));

        for (WebElement video : recentVideos) {
            String actualVideoLink = video.getAttribute ("href");

            if (Arrays.asList (videosLinks).contains (actualVideoLink)) {
                if (!uniqueLinks.add (actualVideoLink)) {
                    duplicateCount++;
                    System.out.println ("Found Duplicate: " + actualVideoLink);
                }
            }
        }

        Assert.assertEquals (duplicateCount, 0, "Found duplicates in the list of recent video links");


    }

}
