package mobileauto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class calculator {

	
        DesiredCapabilities capabilities;
        AndroidDriver driver;

        @BeforeTest
        public void beforeTest() throws FileNotFoundException, IOException {
                        
                        String currentdir = System.getProperty("user.dir");
                        File dir = new File(currentdir);
                        String parentpath = dir.getPath();
                        parentpath = parentpath.replace('\\', '/');
                        
                        Properties properties = new Properties();
                        properties.load(new FileInputStream(parentpath+ "/src/Config.properties"));

                        capabilities = new DesiredCapabilities();
                        capabilities.setCapability("deviceName", properties.getProperty("deviceName"));
                        capabilities.setCapability("platformVersion", properties.getProperty("platformVersion"));
                        capabilities.setCapability("platformName", properties.getProperty("platformName"));
                        capabilities.setCapability("appPackage", properties.getProperty("appPackage"));
                        capabilities.setCapability("appActivity", properties.getProperty("appActivity"));
                        try {
                                        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                        } catch (MalformedURLException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                        }
        }
        @Test
        public void InvalidEmailId() throws MalformedURLException, InterruptedException {
                        //Thread.sleep(1000);
                        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                        driver.findElementById("com.cgi.defera:id/login_user_edit").sendKeys("android.inteter@example.com");
                        driver.findElement(By.id("com.cgi.defera:id/login_pass_edit")).sendKeys("Temp1234");
                        driver.findElement(By.id("com.cgi.defera:id/login_btn_login")).click();
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
