package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pages.BasePage;

public class BaseTest extends BasePage {
    static Logger logger = LogManager.getLogger(BaseTest.class.getName());
    TestWithUserLogin testWithUserLogin = new TestWithUserLogin();
    TestWithoutLogin testWithoutLogin = new TestWithoutLogin();

    @Test
    public void baseTestWithLogin() {
        testWithUserLogin.selectProductWithLogin();
    }

    @Test
    public void baseTestWithoutLogin() {
        testWithoutLogin.selectProductWithoutLogin();
    }
}
