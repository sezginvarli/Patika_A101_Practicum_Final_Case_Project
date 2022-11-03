package utilities;

import java.util.Set;

public class ReusableMethods {


    public static void switchDriver () {
        String window1Handle = Driver.getDriver().getWindowHandle();

        Set<String> allWindows = Driver.getDriver().getWindowHandles();

        for (String eachHandle : allWindows) {

            if (!eachHandle.equals(window1Handle)) {
                Driver.getDriver().switchTo().window(eachHandle);
            }
        }


    }

}
