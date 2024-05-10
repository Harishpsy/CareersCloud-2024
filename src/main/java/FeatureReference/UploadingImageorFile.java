package FeatureReference;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadingImageorFile {
    public void uploadimage() throws InterruptedException, AWTException {
        //      Uploading the image

        Thread.sleep (3000);
        String file = "C:\\Users\\Lenovo Desktop 03\\Downloads\\Telegram Desktop\\Untitled155.png";
        StringSelection selection = new StringSelection (file);
        Toolkit.getDefaultToolkit ().getSystemClipboard ().setContents (selection, null);

        // Pressing the keyboard button

        Robot robot = new Robot ();

        //Pressing The Key

        Thread.sleep (3000);
        robot.keyPress (KeyEvent.VK_CONTROL);
        robot.keyPress (KeyEvent.VK_V);

        // Releasing the Key

        Thread.sleep (3000);
        robot.keyRelease (KeyEvent.VK_V);
        robot.keyRelease (KeyEvent.VK_CONTROL);

        // Clicking The Enter Key

        Thread.sleep (3000);
        robot.keyPress (KeyEvent.VK_ENTER);

        // Releasing The Enter Key

        Thread.sleep (3000);
        robot.keyRelease (KeyEvent.VK_ENTER);


    }

}
