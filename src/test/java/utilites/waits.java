/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilites;

import io.appium.java_client.AppiumDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author manoj
 */
public class waits {
    private AppiumDriver driver = null;
    public waits(AppiumDriver d) {
        this.driver=d;
    }
    
    public void pageLoad(int time){
        this.driver.manage().timeouts().pageLoadTimeout(time,TimeUnit.SECONDS);
    } 
    
    public void Wait(int time){
        this.driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
    }
    
    public void WaitUntil(long time,WebElement ele){
       new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOf(ele));
    }
    
}
