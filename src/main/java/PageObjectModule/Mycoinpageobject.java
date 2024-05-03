package PageObjectModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Mycoinpageobject {

    // Clicking The My Coin

    @FindBy(xpath = "//*[@id=\"4\"]")
    public static WebElement clickingMycoin;

    // Clicking Coin Earning Arrow

    @FindBy(xpath = "//div[text()='Coin Earning']")
    public static WebElement clickingCoinEarningText;

    // Clicking The close Button

    @FindBy(xpath = "//*[@class=\"ant-modal-close-x\"]")
    public static WebElement clickingCloseIcon;

    // clicking The Google Play Button

    @FindBy(xpath = "//span[text()='Google Play']")
    public static WebElement clickingGooglePlayButton;


}
