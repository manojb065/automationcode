/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilites;

import io.appium.java_client.AppiumDriver;
import helpper.Helper;
import io.appium.java_client.HasOnScreenKeyboard;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AuthenticatesByFinger;
import java.time.Duration;
import org.openqa.selenium.Platform;
/**
 *
 * @author manoj
 */
public class deviceOps {
    private final AppiumDriver driver;
    private final Platform platform;
    public deviceOps(AppiumDriver driver) {
    this.driver=driver;
        platform = this.driver.getCapabilities().getPlatform();
    }
    
    public boolean isInstalled(String bundleid){
        return this.driver.isAppInstalled(bundleid);
    }
    
    public void App(String ops){
        try{
        if(ops.equalsIgnoreCase("start"))
        this.driver.launchApp();
        else if(ops.equalsIgnoreCase("stop"))
        this.driver.close();
        else
            System.out.println("invalid option");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        }
    
    public void runBackground(int time){
        this.driver.runAppInBackground(Duration.ofSeconds(time));
    }
    
    public void activeOrTerminateApp(String... ops){
        try{
            if(ops[0].equalsIgnoreCase("active")){
                this.driver.activateApp(ops[1]);
            }else if(ops[0].equalsIgnoreCase("terminate")){
                this.driver.terminateApp(ops[1]);
            }else{
                throw new Exception("invalid options");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    public String resetOrRemoveApp(String... ops){
        try{
            if(ops[0].equalsIgnoreCase("reset"))
           this.driver.resetApp();
            
            else if(ops[0].equalsIgnoreCase("remove")){
                if(ops.length>1){
                    this.driver.removeApp(ops[1]);
                }else
                throw new Exception("package is not provided");
            }
        }catch(Exception e){
        return e.getMessage();
    }
        return "app closed";
    }
    
    public void lockDevice(int... sec) {
        if(this.platform==Platform.ANDROID){
       if(((AndroidDriver)this.driver).isDeviceLocked())
        if(sec.length>0){
            ((AndroidDriver)this.driver).lockDevice(Duration.ofSeconds(sec[0]));
        }else{
            ((AndroidDriver)this.driver).lockDevice();
        }
        }
    }
    
     public void unLockDevice(){
         
        if(this.platform==Platform.ANDROID)
         ((AndroidDriver)this.driver).unlockDevice();
     }
    public void notification(){
        
        if(this.platform==Platform.ANDROID)
        ((AndroidDriver)this.driver).openNotifications();
    }
    
    public void authFinger(){
        AuthenticatesByFinger fig = (AuthenticatesByFinger)this.driver;
        fig.fingerPrint(1);
    }
    public boolean checkKeyboard(){
        
        if(this.platform==Platform.ANDROID){
        HasOnScreenKeyboard key=(AndroidDriver)this.driver;
        return key.isKeyboardShown();
        }
        return false;
    }
     public void hideKeyboard(){
         if(checkKeyboard())
         this.driver.hideKeyboard();
     }
    
    public String installApp(String appPath){
        try{
        if(Helper.isPathExsist(appPath)){
            this.driver.installApp(appPath);
        }
        }catch(Exception e){
            return e.getMessage();
        }
        
            return "installed successfully";
    }

    
    
    
     
}
