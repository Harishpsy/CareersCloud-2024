package FeatureReference;

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


        // Another Method for verifying Duplicate In The Wep page Using HashSet

        // This method was working fine

        String[] videosLinks = {"https://careerscloud.in/course-details/6/video/2164", "https://careerscloud.in/course-details/6/video/2158",
                "https://careerscloud.in/course-details/6/video/2162", "https://careerscloud.in/course-details/6/video/2160",
                "https://careerscloud.in/course-details/6/video/2155"};

        List<WebElement> recentVideos = driver.findElements (xpath ("//*[@class=\"ant-list-items\"]/child::*"));
        Set<String> uniqueurl = new HashSet<> ();
        int uniquevideosurlcount = 0;

        for (WebElement recentVideo : recentVideos) {
            String actualUrls = recentVideo.getAttribute ("href");

            if (uniqueurl.contains (actualUrls)) {

                System.out.println ("Duplicate found --> " + actualUrls);
            } else {
                uniqueurl.add (actualUrls);
                if (Arrays.asList (videosLinks).contains (actualUrls)) {
                    uniquevideosurlcount++;
                    System.out.println ("Found: " + uniquevideosurlcount + "-->" + actualUrls);
                }
            }
        }
        System.out.println ("Total unique videos url found: " + uniquevideosurlcount);
        Assert.assertEquals (uniquevideosurlcount, videosLinks.length);


    }

}
