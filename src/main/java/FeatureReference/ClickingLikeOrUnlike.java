package FeatureReference;

import org.openqa.selenium.WebElement;

import static MainPages.Login_page.driver;
import static org.openqa.selenium.By.xpath;

public class ClickingLikeOrUnlike {

    public void LikeOrUnlike() {

        // Clicking the like and unlike button

        WebElement clickAction = driver.findElement (xpath ("//*[contains(@class, 'like') or contains(@class, 'unlike')]"));

        if (clickAction.isDisplayed ()) {
            clickAction.click ();


            if (clickAction.getAttribute ("class").contains ("unlike")) {
                System.out.println (" Un Liked Successfully ");
            } else {
                System.out.println (" Liked Successfully ");
            }
        }

    }
}

//                "https://www.youtube.com/embed/yQyqSFvhV6E", "https://www.youtube.com/embed/sSisSX7mRTs", "https://www.youtube.com/embed/j9gCpOpSd5c",
//                        "https://www.youtube.com/embed/uD8COFsPXI4", "https://www.youtube.com/embed/ksytSb7-QKI", "https://www.youtube.com/embed/5kDFVNrB_uE",
//                        "https://www.youtube.com/embed/Mh1v2nPnXEw", "https://www.youtube.com/embed/xgSncNI1uMU", "https://www.youtube.com/embed/e4TWEFT-eR0",
//                        "https://www.youtube.com/embed/iBxsIZ2jyog", "https://www.youtube.com/embed/x94bd9BOZhA", "https://www.youtube.com/embed/3Edf_H2aKD8",
//                        "https://www.youtube.com/embed/7mB3UecOb-Y", "https://careerscloud.in/course-details/6/video/2155", "https://www.youtube.com/embed/K0WSAIwQC6o
//, "https://www.youtube.com/embed/66dm-vf3Yew", "https://www.youtube.com/embed/2YF_wwrUFBU",
//                "https://www.youtube.com/embed/tzWTqG6AjgA", "https://www.youtube.com/embed/BVxZTcXCQ1w", "https://www.youtube.com/embed/I6jckmkU90w", "https://www.youtube.com/embed/nXFDs9-d98k",
//                "https://www.youtube.com/embed/0w6kk-NvtaM", "https://www.youtube.com/embed/Eqt0azCKCmY", "https://www.youtube.com/embed/MrScTfvFVDk", "https://www.youtube.com/embed/yX5tOeyGMpE", "https://www.youtube.com/embed/B4x0o3Xxh0I",
//                "https://www.youtube.com/embed/aZlCCjH224I", "https://www.youtube.com/embed/TmLHK6yZ_1U", "https://www.youtube.com/embed/7HoLC0bouZM", "https://www.youtube.com/embed/l_U14N2OZ3Y"