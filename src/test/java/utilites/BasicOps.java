/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilites;

import PageObject.PageBase;
import helpper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.logging.LogEntries;


/**
 *
 * @author manoj
 */
public class BasicOps extends PageBase{
   private AppiumDriver driver;
   private final Platform platform;
   

    public BasicOps() {
        this.driver=super.getDriver();
        platform = this.driver.getCapabilities().getPlatform();
    }
    
     public void clickElement(MobileElement ele) {
        try {
            ele.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void sendText(MobileElement ele, String text) {
        try{
        ele.sendKeys(text);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void submit(MobileElement ele) {
        try{
        ele.submit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public boolean sameElement(MobileElement e1,MobileElement e2){
        return e1.equals(e2);
    }
    public void clearText(MobileElement ele) {
        try{
        ele.clear();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public String getAttribute(MobileElement ele,String attName){
        try{
            return ele.getAttribute(attName);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public String getText(MobileElement ele){
         try{
            return ele.getText();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public String getTagName(MobileElement ele){
         try{
            return ele.getTagName();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public boolean isSelected(MobileElement ele){
         try{
            return ele.isSelected();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public boolean isEnabled(MobileElement ele){
         try{
            return ele.isEnabled();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public boolean isDisplayed(MobileElement ele){
         try{
            return ele.isDisplayed();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public Point getLocation(MobileElement ele){
         try{
            return ele.getLocation();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public String startRecord(){
//        if(this.platform==Platform.ANDROID){
        AndroidStartScreenRecordingOptions opt = new AndroidStartScreenRecordingOptions();
        opt.withTimeLimit(Duration.ofMinutes(30));
        ((AndroidDriver)this.driver).startRecordingScreen(new AndroidStartScreenRecordingOptions().withTimeLimit(Duration.ofMinutes(30)));
//        }
        return "strated";
    }
    
    public String stopRecord(String name){
//        if(this.platform==Platform.ANDROID){
            
        System.out.println("started to save");
        String video = ((AndroidDriver)this.driver).stopRecordingScreen();
String fileName = System.getProperty("recordingPath")+"\\"+name;
            System.out.println(fileName);
helpper.Helper.saveRecording(fileName, video);
        
//        }
//File.WriteAllBytes(fileName, video);
return "saved redorcing";
    }
    public ScreenOrientation getOrientation(){
        return this.driver.getOrientation();
    }
    
    public Location getGeoLOc(){
        return this.driver.location();
    }
    
    public String setGeoLoc(Location loc){
        try{
         this.driver.setLocation(loc);
    }catch(Exception e){
            System.out.println(e.getMessage());
            return "Error in changing location";
            }
        return "changed successfully";
    }
    
    
    public LogEntries setLog(String level){
        return this.driver.manage().logs().get(level);
    }
    
   public Map<String,Object> DeviceSeeting(){
       return this.driver.getSettings();
   }
   public Dimension  getScreenSize(){
       return this.driver.manage().window().getSize();
   }
  public String screenShot(String path){
      String res=null;
      try{
      Helper.saveFile(path,((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE));
      }catch(Exception e){
          System.out.println(e.getMessage()+" error");
          res="error in capturing screen shot";
      }
      return res;
      }
}
