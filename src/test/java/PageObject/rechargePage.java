/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import java.util.List;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilites.Uioperations;
import utilites.deviceOps;
import utilites.waits;

/**
 *
 * @author manoj
 */
public class rechargePage extends PageBase {
    private AppiumDriver driver;
    @FindBy(id="proceed_to_pay_button") private MobileElement ppay;
    @FindBy(id="pay_button") private MobileElement repay;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout") private MobileElement pay;
    public rechargePage() {
        this.driver=super.getDriver();
    }
    
    public detailsPage pay(){
        Uioperations op = new Uioperations(driver);
        op.slideElement(pay,this.driver.manage().window().getSize().height,this.driver.manage().window().getSize().width);
        return new detailsPage();
    }
    
    public detailsPage earlyRepay() throws InterruptedException{
        ppay.click();
        repay.click();
//        deviceOps op = new deviceOps(this.driver);
        //unlock figner print
//        op.authFinger();
        ((List<MobileElement>)((List<MobileElement>)byId("netbanking_wrapper", true)).get(0).findElementsByClassName("android.widget.LinearLayout")).get(0).click();
         ((MobileElement)byId("pay_button", false)).click();
        MobileElement e =((List<MobileElement>)byClassName("android.widget.Button", true)).get(0);
         waits w =new waits(this.driver);
         w.WaitUntil(0, e);
         e.click();
        return new detailsPage();
    }
    public detailsPage onDueRepay(){
     boolean flag= ((MobileElement)byId("due_date_text", false)).getText().matches("Due on*");
        Assert.assertEquals(flag, true,"invalid message");
        flag=((MobileElement)byId("famcoins_text", false)).getText().equalsIgnoreCase("Continue earning FamCoins on your transactions, by repaying on time");
        Assert.assertEquals(flag, true,"invalid message");
        ppay.click();
        repay.click();
//        deviceOps op = new deviceOps(this.driver);
        //unlock figner print
//        op.authFinger();
        ((List<MobileElement>)((List<MobileElement>)byId("netbanking_wrapper", true)).get(0).findElementsByClassName("android.widget.LinearLayout")).get(0).click();
         ((MobileElement)byId("pay_button", false)).click();
        MobileElement e =((List<MobileElement>)byClassName("android.widget.Button", true)).get(0);
         waits w =new waits(this.driver);
         w.WaitUntil(0, e);
         e.click();
        return new detailsPage();
    }
    public detailsPage exceedDueRepay(){
         boolean flag= ((MobileElement)byId("due_date_text", false)).getText().equalsIgnoreCase("Due date exceeded");
        Assert.assertEquals(flag, true,"invalid message");
        flag=((MobileElement)byId("famcoins_text", false)).getText().equalsIgnoreCase("You are not earning FamCoins on your transactions. Repay now to bring it back!");
        Assert.assertEquals(flag, true,"invalid message");
        ppay.click();
        repay.click();
//        deviceOps op = new deviceOps(this.driver);
        //unlock figner print
//        op.authFinger();
        ((List<MobileElement>)((List<MobileElement>)byId("netbanking_wrapper", true)).get(0).findElementsByClassName("android.widget.LinearLayout")).get(0).click();
         ((MobileElement)byId("pay_button", false)).click();
        MobileElement e =((List<MobileElement>)byClassName("android.widget.Button", true)).get(0);
         waits w =new waits(this.driver);
         w.WaitUntil(0, e);
         e.click();
        return new detailsPage();
    }
    
}
