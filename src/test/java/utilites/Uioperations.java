
package utilites;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import java.time.Duration;

public class Uioperations {
    private final TouchAction action;
    public Uioperations(AppiumDriver driver) {
    this.action=new TouchAction(driver);
    }
    
    public TouchAction press(int x,int y,MobileElement... ele){
        if(ele.length==0)
        return this.action.press(PointOption.point(x, y));
        else
        return this.action.press(ElementOption.element((MobileElement)ele[0]));
    }
    public TouchAction longPress(int x,int y,MobileElement... ele){
        if(ele.length>0){
           return this.action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(ele[0])));
        }
        return this.action.longPress(PointOption.point(x, y));
    }
    public TouchAction tap(int x,int y,MobileElement... ele){
        if(ele.length>0){
            return this.action.tap(TapOptions.tapOptions().withElement(ElementOption.element(ele[0])));
        }
        return this.action.tap(PointOption.point(x, y));
    }
    public TouchAction move(int x,int y,boolean flag){
        if(!flag)
           return this.action.moveTo(PointOption.point(x,y));
          else
          return this.action.moveTo(ElementOption.point(x, y));
        
    }
    public TouchAction slideOrScroll(int startx,int starty ,int endx,int endy) {
        return this.press(startx, starty).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endx, endy))
                .release().perform();
    }
 
    public TouchAction slideElement (MobileElement ele,int x,int y) {
      
        return this.press(0, 0, ele).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(x, y))
                .release().perform();
    }
    public TouchAction preform(){
       return this.action.perform();
    }
    public TouchAction release(){
        return this.action.release();
    }
    public TouchAction waitTill(int sec){
        return this.action.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(sec)));
    }
    
}
