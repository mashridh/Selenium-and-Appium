package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePageObjects;

import java.net.MalformedURLException;
import java.net.URL;

public class LsacTest {
    //WebDriver driver = new ChromeDriver();
    static AppiumDriver<MobileElement> driver = null;

    static HomePageObjects Hpages = new HomePageObjects(driver);
    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"ANDROID");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Manu_Emulator");
        cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, cap);
    }

    @Test
    public void lsacQuiz()
    {
        driver.get("https://familiar.lsac.org/module/73d37cc1-fc7d-48bc-b153-40f1afacf6fb");
        Hpages.FirstSession();
        Hpages.gotoQuestions();

        for (int i = 0; i<= 22; i++){
            Hpages.OptionA();
            Hpages.NextPage();
        }
        Hpages.more();
        Hpages.CompleteSection();
    }

    @Test// Second scenario just to click on the section2 to begin
    public void lsacQuiz2()
    {
        Hpages.Begin_section2();
    }

    @AfterTest
    public void teardown(){

    }
}
