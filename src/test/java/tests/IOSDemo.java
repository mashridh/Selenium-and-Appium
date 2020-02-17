package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePageObjects;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSDemo {
    static AppiumDriver<MobileElement> driver = null;
    public WebDriverWait wait;

    static HomePageObjects Hpages = new HomePageObjects(driver);

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0.1");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
        capabilities.setCapability(MobileCapabilityType.UDID, "auto");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, 30);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
    @Test
    public void testFindingAnElement() {
        driver.get("https://familiar.lsac.org/");
        Hpages.FirstSession();
        Hpages.gotoQuestions();

        for (int i = 0; i<= 22; i++){
            Hpages.OptionA();
            Hpages.NextPage();
        }
        Hpages.more();
        Hpages.CompleteSection();
    }

    @Test(priority = 1)// Second scenario just to click on the section2 to begin
    public void lsacQuiz2()
    {
        Hpages.Begin_section2();
    }
}
