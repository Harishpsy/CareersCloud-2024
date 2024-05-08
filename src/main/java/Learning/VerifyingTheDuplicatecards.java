package Learning;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

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
    }
}
