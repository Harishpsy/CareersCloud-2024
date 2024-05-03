package PageObjectModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myebookspageobject {

    // Clicking My ebooks

    @FindBy(xpath = "//*[@id=\"3\"]")
    public static WebElement clickingTheMyEbooks;

    // Click the three dots in the My Ebook

    @FindBy(xpath = "//*[@class=\"ant-dropdown-trigger\"]")
    public static WebElement Threedots;

    //Clicking the remove My ebook icon in dropdown

    @FindBy(xpath = "//span[text()='Remove My  Ebook']")
    public static WebElement Remove_My_ebook;

    /* Clicking the share icon in My Ebook */

    @FindBy(xpath = "//span[text()='Share']")
    public static WebElement Share_icon;

    //click the copy link in the share popup

    @FindBy(xpath = "//span[text()='COPY LINK']")
    public static WebElement Copy_link;

    //Clicking the cancel button in the in share popup

    @FindBy(xpath = "//span[text()='Cancel']")
    public static WebElement Cancelbutton;

    //clicking the report icon

    @FindBy(xpath = "//span[text()='Report']")
    public static WebElement Reporticon;

    //Click the wrong information radio button

    @FindBy(xpath = "//span[text()='Wrong Information']")
    public static WebElement Wronginformationradiobutton;

    //Entering the text inside the report text field

    @FindBy(name = "reportDescription")
    public static WebElement Enterthereport;

    // Click the report button

    @FindBy(xpath = "//span[text()='REPORT']")
    public static WebElement Reportbutton;

    // Clicking The Cancel Button

    //Clicking the Course name in My ebook Card

    @FindBy(xpath = "//*[@class=\"anticon anticon-right right-arrow-icon\"]")
    public static WebElement ClickingCourseName;

    //Clicking the breadcrums to navigate backward to My ebook page

    @FindBy(xpath = "//span[text()='Course']")
    public static WebElement ClickingCoursebreadcrums;

    // Clicking the like button

    @FindBy(xpath = "//*[@class=\"feed-card-footer-like-icon\"]")
    public static WebElement Likebutton;

    // ClickingTheUnLikesButton

    @FindBy(xpath = "//span[text()='Likes']")
    public static WebElement clickingUnlikeButton;

    // Clicking The Ebook

    @FindBy(xpath = "//*[@class=\"ebook-cover-image-container\"]")
    public static WebElement clickingEbook;

    // Clicking UnLike Button

    @FindBy(xpath = "//*[@class=\"unlike\"]")
    public static WebElement clickingLikeButton;

    // Clicking Comment Icon

    @FindBy(xpath = "//*[@id=\"comments-icon\"]")
    public static WebElement clickingCommentIcon;

    //  Entering Comment In The TextField

    @FindBy(xpath = "//*[@name=\"comments1\"]")
    public static WebElement enteringTheCommentInTextField;

    // Clicking The Send Button In The Comment Text Field

    @FindBy(className = "anticon-send")
    public static WebElement clickingSendButton;

    // Clicking The View Button In The Ebook

    @FindBy(xpath = "//span[text()='View']")
    public static WebElement clickingViewButtonInEbook;

    // Clicking Back Button in the Ebook Page

    @FindBy(xpath = "//span[text()='Back']")
    public static WebElement clickingBackButton;

    // Clicking The Home Button

    @FindBy(xpath = "//a[text()='Home']")
    public static WebElement clickingHomeButton;
}
