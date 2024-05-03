package PageObjectModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepageobject {

    // clicking Preference Button

    @FindBy(xpath = "//*[@name=\"selectedPreference\"]")
    public static WebElement clickingPreferenceButton;

    // Clicking The Railway Button

    @FindBy(xpath = "//div[text()='Railway']")
    public static WebElement clickingRailwayButton;

    // Clicking The Bank&Insurance Button

    @FindBy(xpath = "//div[text()='Bank & Insurance']")
    public static WebElement clickingBankandInsuranceButton;

    // Clicking The Add Preference

    @FindBy(xpath = "//a[text()=' Add Preference']")
    public static WebElement clickingAddPreferencebutton;

    // clicking UPSC Button

    @FindBy(xpath = "//div[text()='UPSC']")
    public static WebElement clickingUPSCButton;

    // Clicking Save Preference

    @FindBy(xpath = "//span[text()='Save Preference']")
    public static WebElement clickingsavePreference;

    // Clicking Cancel Button In Profile

    @FindBy(xpath = "//span[text()='Cancel']")
    public static WebElement clickingCancelButton;

    //  Clicking The Right arrow in the Home feed

    @FindBy(xpath = "//span[@class=\"anticon anticon-right action-icon\"]")
    public static WebElement clickingRightArrow;

    // Clicking The banners in the home feed

    @FindBy(xpath = "//*[@src=\"https://assets.careerscloud.in/banner/images/94cbaa46bc54ec537cc339f5199b390e.webp\"]")
    public static WebElement clickingBannerInHomeFeed;

    // Clicking the course BreadCrumbs for coming back

    @FindBy(xpath = "//span[text()='Course']")
    public static WebElement clickingCourseInBreadCrumbs;

    // Clicking The banners in the home feed

    @FindBy(xpath = "//*[@src=\"https://assets.careerscloud.in/banner/images/2901af2b7017b7d126b7c7493c0a2b8d.webp\"]")
    public static WebElement clickingBannerInHomeFeed1;

    // Clicking The banners in the home feed

    @FindBy(xpath = "//*[@src=\"https://assets.careerscloud.in/banner/images/b26df9a2c61c98268b1ab9e34cb9fbdb.webp\"]")
    public static WebElement clickingBannerInHomeFeed2;

    // Clicking The Close icon In The Course Banner Modal

    @FindBy(xpath = "//*[@class=\"ant-modal-close-x\"]")
    public static WebElement clickingCloseIcon;

    // Clcking The Google Play Button

    @FindBy(xpath = "//span[text()='Google Play']")
    public static WebElement clickingGoooglePlayButton;

    // Clicking The About us In The Footer Section

    @FindBy(xpath = "//a[text()='About Us']")
    public static WebElement clickingAboutUs;

    // Clicking The Authors In The Footer Section

    @FindBy(xpath = "//a[text()='Authors']")
    public static WebElement clickingAuthors;

    // Clicking The contactus In The Footer Section

    @FindBy(xpath = "//span[text()='Contact Us']")
    public static WebElement clickingcontactUs;

    // Entering The text In The Contactus TextField

    @FindBy(name = "queries")
    public static WebElement enteringTextInTextField;

    // Clicking The Send Button

    @FindBy(xpath = "//span[text()='Send']")
    public static WebElement clickingSendButton;

    // Clicking The FAQ Button In The Footer Section

    @FindBy(xpath = "//a[text()='FAQs']")
    public static WebElement clickingFAQButton;

    // Clicking The Terms And Condition Button In The Footer Section

    @FindBy(xpath = "//a[text()='Terms and Conditions']")
    public static WebElement clickingTermsAndConditionButton;

    // Clicking The Terms And Condition Button In The Footer Section

    @FindBy(xpath = "//a[text()='Privacy Policy']")
    public static WebElement clickingPrivacyPolicyButton;

    // Clicking The Careers Button In The Footer Section

    @FindBy(xpath = "//a[text()='Careers']")
    public static WebElement clickingCareersButton;

    // Clicking The sitemap Button In The Footer Section

    @FindBy(xpath = "//a[text()='Sitemap']")
    public static WebElement clickingsitemapButton;


}
