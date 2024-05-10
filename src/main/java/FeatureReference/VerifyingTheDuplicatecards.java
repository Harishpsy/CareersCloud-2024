package FeatureReference;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static MainPages.Login_page.driver;
import static org.openqa.selenium.By.xpath;

public class VerifyingTheDuplicatecards {

    public void Duplicatecards() {

        // Verifying The List Of cards was getting duplicating or not

        String[] ArticleCards = {"https://assets.careerscloud.in/course/article/images/c2113c87210d2718aa625f9197817216.webp", "https://assets.careerscloud.in/course/article/images/57f0d0c460019c05a8f66e6a9b3476d0.webp", "https://assets.careerscloud.in/course/article/images/fcb6c606cdafa519a1890771f57edf4a.webp", "https://assets.careerscloud.in/course/article/images/5e04b7cd2e3ea898c0b2edc7841c1328.webp"
                , "https://assets.careerscloud.in/course/article/images/ec428c6a121667134eb7cbacf3f67351.webp", "https://assets.careerscloud.in/course/article/images/69109f10b2cdaccc9216126292b8dfc8.webp",
                "https://assets.careerscloud.in/course/article/images/208645246de3c6b62587a5889727bc2c.webp", "https://assets.careerscloud.in/course/article/images/db144ac76bb53fcc90d528a249058a81.webp", "https://assets.careerscloud.in/course/article/images/45edfb09904144471d389f54c6981130.webp", "https://assets.careerscloud.in/course/article/images/6f8fdf6e275c0b45a38b8311a1046f1e.webp",
                "https://assets.careerscloud.in/course/article/images/8f0ddd398a23ff67aaaf7901ff57178e.webp", "https://assets.careerscloud.in/course/article/images/81d1c8d42093f4ce19865393244be820.webp", "https://assets.careerscloud.in/course/article/images/2605d1cb4009d6b46b67e43ad9a14716.webp", "https://assets.careerscloud.in/course/article/images/9a2c5d7a0de5558f4a188fc2de80ff67.webp", "https://assets.careerscloud.in/course/article/images/a03f53d18b2a19db6670f5f8b6e82e98.webp"};

        List<WebElement> ArticleCard = driver.findElements (xpath ("//*[@class=\"image1\"]"));

        int cardscount = 0;

        for (WebElement Card : ArticleCard) {

            String Actualcard = Card.getAttribute ("src");

            //To cross verify I have write the sop statement below

            //    System.out.println (Actualcard);

            if (Arrays.asList (ArticleCards).contains (Actualcard)) {
                cardscount++;
                System.out.println ("Found " + cardscount + Actualcard);
            }
        }
        Assert.assertEquals (cardscount, ArticleCards.length);


        // Verifying the videoscard was getting duplicating using the unique videos Url

        // This Method was working fine

        String[] videoscard = {"https://www.youtube.com/embed/WesnnBbVMNs", "https://www.youtube.com/embed/I6jckmkU90w", "https://www.youtube.com/embed/66dm-vf3Yew", "https://www.youtube.com/embed/2YF_wwrUFBU"
                , "https://www.youtube.com/embed/tzWTqG6AjgA", "https://www.youtube.com/embed/BVxZTcXCQ1w", "https://www.youtube.com/embed/hCG1fxWsiIs", "https://www.youtube.com/embed/nXFDs9-d98k"
                , "https://www.youtube.com/embed/0w6kk-NvtaM", "https://www.youtube.com/embed/Eqt0azCKCmY", "https://www.youtube.com/embed/MrScTfvFVDk", "https://www.youtube.com/embed/yX5tOeyGMpE",
                "https://www.youtube.com/embed/B4x0o3Xxh0I", "https://www.youtube.com/embed/aZlCCjH224I", "https://www.youtube.com/embed/TmLHK6yZ_1U", "https://www.youtube.com/embed/7HoLC0bouZM", "https://www.youtube.com/embed/5kDFVNrB_uE", "https://www.youtube.com/embed/l_U14N2OZ3Y"
                , "https://www.youtube.com/embed/yQyqSFvhV6E", "https://www.youtube.com/embed/sSisSX7mRTs", "https://www.youtube.com/embed/j9gCpOpSd5c", "https://www.youtube.com/embed/uD8COFsPXI4",
                "https://www.youtube.com/embed/ksytSb7-QKI", "https://www.youtube.com/embed/Mh1v2nPnXEw", "https://www.youtube.com/embed/xgSncNI1uMU", "https://www.youtube.com/embed/e4TWEFT-eR0"
                , "https://www.youtube.com/embed/iBxsIZ2jyog", "https://www.youtube.com/embed/x94bd9BOZhA", "https://www.youtube.com/embed/3Edf_H2aKD8", "https://www.youtube.com/embed/7mB3UecOb-Y"};

        List<WebElement> cards = driver.findElements (xpath ("//*[@class=\"video-iframe\"]"));

        Set<String> uniqueUrls = new HashSet<> ();
        int uniqueCount = 0;

        for (WebElement card : cards) {
            String actualUrl = card.getAttribute ("src");

            if (uniqueUrls.contains (actualUrl)) {
                System.out.println ("Duplicate found --> " + actualUrl);
            } else {
                uniqueUrls.add (actualUrl);
                if (Arrays.asList (videoscard).contains (actualUrl)) {
                    uniqueCount++;
                    System.out.println ("Found: " + uniqueCount + "-->" + actualUrl);
                }
            }
        }

        System.out.println ("Total unique videos url found: " + uniqueCount);
        Assert.assertEquals (uniqueCount, videoscard.length);
    }
}
