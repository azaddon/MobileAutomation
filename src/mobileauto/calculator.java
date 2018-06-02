//Something has been done 
//Again checking
//this is second time
package mobileauto;
//again
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.remote.RemoteWebDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class calculator {

	
        DesiredCapabilities capabilities;
         WebDriver driver;
         AppiumDriverLocalService appiumService;
         

        @BeforeTest
        public void setup() throws MalformedURLException {
        String Appium_Node_Path="C:/Program Files/Appium/node.exe";
        String Appium_JS_Path="C:/Program Files/Appium/node_modules/appium/bin/appium.js";
        //AppiumDriverLocalService appiumService;

        appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().
        	                usingAnyFreePort().usingDriverExecutable(new File(Appium_Node_Path)).
        	                withAppiumJS(new File(Appium_JS_Path)));
        appiumService.start();
        }
        @Test
        public void beforeTest() throws FileNotFoundException, IOException,NullPointerException {
                        
                        String currentdir = System.getProperty("user.dir");
                        File dir = new File(currentdir);
                        String parentpath = dir.getPath();
                        parentpath = parentpath.replace('\\', '/');
                        
                        Properties properties = new Properties();
                        properties.load(new FileInputStream(parentpath+ "/src/config.properties"));

                        capabilities = new DesiredCapabilities();
                        capabilities.setCapability("deviceName", properties.getProperty("deviceName"));
                        capabilities.setCapability("platformVersion", properties.getProperty("platformVersion"));
                        capabilities.setCapability("platformName", properties.getProperty("platformName"));
                        capabilities.setCapability("appPackage", properties.getProperty("appPackage"));
                        capabilities.setCapability("appActivity", properties.getProperty("appActivity"));
                        try {
                                        driver = new  RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                        } catch (MalformedURLException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                        }
        }
        @Test
        public void perform() {
        	
        }



@AfterTest
public void afterTest() {
try {
Thread.sleep(50);
driver.quit();
} catch (InterruptedException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}}
