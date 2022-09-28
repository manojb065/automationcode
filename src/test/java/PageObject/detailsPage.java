/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilites.waits;

/**
 *
 * @author manoj
 */
public class detailsPage extends PageBase {

    private AppiumDriver driver;
    @FindBy(id="payment_status_text") private MobileElement pay_st; 
    @FindBy(id="com.fampay.in.debug:id/status_text") private MobileElement succ;
    public detailsPage() {
         
        this.driver=super.getDriver();
       
    }
    
    public void checkPaymentStatus(){
        waits w =new waits(this.driver);
        w.WaitUntil(20, succ);
        String l = "Payment successful";
        Assert.assertEquals(succ.getText().matches(l), true , "not successful");
        this.driver.navigate().back();
//        String mes=e.getText();
    
}
}
