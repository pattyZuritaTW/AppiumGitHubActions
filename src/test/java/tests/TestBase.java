package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase extends AbstractTestNGCucumberTests {
    public static AppiumDriver driver;
    public static void Android_setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.0"); //version del dispositivo físico
        caps.setCapability("deviceName", "Android Emulator"); //nombre del dispositivo
        caps.setCapability("app", System.getProperty("user.dir")+"/apps/ToDo.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
    }



    //43691A82-27C0-49B1-B793-B737197020A4
    //4C9EE21B-E1EF-42F8-972E-305F837ABF7B
    public static void iOS_setUp(String port, String deviceName,
                                 String platformVersion, String udid, String wdaLocalPort) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("app",
                System.getProperty("user.dir")+"/apps/DailyCheck.zip");
        caps.setCapability("wdaLocalPort",wdaLocalPort);
        caps.setCapability("udid",udid);
        driver = new IOSDriver(new URL("http://localhost:"+port+"/wd/hub"),caps);
    }

    public static void tearDown(){
        if(null != driver){
            driver.quit();
        }
    }
}
