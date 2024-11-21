package ScreenShot;

import Master.MainObjects.BaseObjects;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot extends BaseObjects {

    public static String captureScreenshot(String actionName) throws IOException {
        String timestamp = new SimpleDateFormat ( "yyyyMMdd_HHmmss" ).format ( new Date () );
        String screenshotPath = "./screenshots/" + actionName + "_" + timestamp + ".png";

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs ( OutputType.FILE );

        File destination = new File ( screenshotPath );
        Files.createDirectories ( destination.getParentFile ().toPath () );
        Files.copy ( screenshotFile.toPath () , destination.toPath () );
        test.info ( actionName , MediaEntityBuilder.createScreenCaptureFromPath ( screenshotPath ).build () );

        return screenshotPath;
    }
}