package PageObject;

import PageObject.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.support.PageFactory;
import utilites.Session;

public class PageBase {

    private static AppiumDriver driver;
  
    public PageBase() {
        try{
        if(driver==null){
            this.driver=new Session().startSession();
            System.out.println("inside");
        }
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static AppiumDriver getDriver(){
        return driver;
    }
    public Object byId(String id, boolean flag) {
        Object ele = null;
        try {
            if (!flag) {
                ele = this.driver.findElementById(id);
            } else {
                ele = this.driver.findElementsById(id);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ele;
    }

    public Object byAccessibilityID(String id, boolean flag) {
        Object ele = null;
        try {
            if (!flag) {
                ele = this.driver.findElementByAccessibilityId(id);
            } else {
                ele = this.driver.findElementsByAccessibilityId(id);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ele;
    }

    public Object byClassName(String name, boolean flag) {
        Object ele = null;
        try {
            if (!flag) {
                ele = this.driver.findElementByClassName(name);
            } else {
                ele = this.driver.findElementsByClassName(name);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ele;
    }

    public Object byName(String name, boolean flag) {
        Object ele = null;
        try {
            if (!flag) {
                ele = this.driver.findElementByName(name);
            } else {
                ele = this.driver.findElementsByName(name);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ele;
    }

    public Object byXpath(String name, boolean flag) {
        Object ele = null;
        try {
            if (!flag) {
                ele = this.driver.findElementByXPath(name);
            } else {
                ele = this.driver.findElementsByXPath(name);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ele;
    }

    public Object byImage(File img, boolean flag) {
        Object ele = null;
        try {

            String path = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(img));
            if (!flag) {
                ele = this.driver.findElementByImage(path);
            } else {
                ele = this.driver.findElementsByImage(path);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ele;
    }

    public Object byTagName(String name, boolean flag) {
        Object ele = null;
        try {
            if (!flag) {
                this.driver.findElementByTagName(name);
            } else {
                this.driver.findElementsByTagName(name);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ele;
    }

   
}
