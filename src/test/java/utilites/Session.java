/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilites;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author manoj
 */
public class Session {
    private Properties pros;
    protected AppiumDriver driver =null;
    public AppiumDriver startSession() throws MalformedURLException, IOException{
        
        System.out.println("session creation started ");
        pros = new Properties();
        String path = System.getProperty("user.dir")+"\\src\\test\\java";
        System.out.println(path);
        System.setProperty("path", path);
        System.setProperty("recordingPath", path+"\\resource\\screenRecording");
        System.setProperty("screenshotPath", path+"\\resource\\screenShot");
        pros.load(new FileInputStream(path+"\\resource\\config\\androidConfig.properties"));
    DesiredCapabilities caps = new DesiredCapabilities();
    
    if( "Android".equals(pros.getProperty("platformName"))){
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, pros.getProperty("automationName"));
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, pros.getProperty("deviceName"));
                caps.setCapability(MobileCapabilityType.UDID, pros.getProperty("udid"));
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        caps.setCapability(MobileCapabilityType.APP, pros.getProperty("app"));
        caps.setCapability("autoGrantPermissions", "true");
        driver = new AndroidDriver(new URL(pros.getProperty("url")),caps);
            System.out.println("session created ");
    }else{  // ios to do
        
    }

        return driver;
}
    public String endSession(){
        if(this.driver==null){
            return "No session created";
        }else{
            this.driver.quit();
            return "Session ended";
        }
    }
}
