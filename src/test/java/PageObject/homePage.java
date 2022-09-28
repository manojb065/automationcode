/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PageObject;

import PageObject.rechargePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import java.util.List;
import java.util.regex.Pattern;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import static org.testng.Assert.assertEquals;
import utilites.deviceOps;
import utilites.waits;

/**
 *
 * @author manoj
 */
public class homePage extends PageBase {
    private AppiumDriver driver;
    private String expression = "%s.*%s\\s[0-9]\\s(?:Jan(?:uary)?|Feb(?:ruary)?|Mar(?:ch)?|Apr(?:il)?|May|June?|July?|Aug(?:ust)?|Sep(?:tember)?|Oct(?:ober)?|Nov(?:ember)?|Dec(?:ember)?)";
    private Pattern p ;
    @FindBy(id="user_fam_icon") private MobileElement user_pro;
    @FindBys(@FindBy(id="com.fampay.in.debug:id/title")) private List<MobileElement> hc ;
    public homePage() {
        
        this.driver=super.getDriver();
    }
    public rechargePage recharge(){
        waits w =new waits(this.driver);
        w.WaitUntil(30,user_pro);
        assertEquals(user_pro.isDisplayed(), true, "user profile not found");
        deviceOps ops = new deviceOps(this.driver);
        ops.hideKeyboard();
        
//        hc.get(1).click();
        return new rechargePage();
    }
    private boolean find(String mesg,String... args){
        expression=String.format(expression, args);
        p=Pattern.compile(expression);
        return p.matcher(mesg).find();
    }
    public rechargePage earlyRepayment(){
        assertEquals(hc.get(1).isEnabled(), true,"not enabled");
        assertEquals(find(hc.get(1).getText(),"early","Due"), true);
        hc.get(1).click();
        return new rechargePage();
    }
    public rechargePage onDueRepayment(){
        assertEquals(hc.get(1).isEnabled(), true,"not enabled");
        assertEquals(find(hc.get(1).getText(),"now","Due"), true);
        hc.get(1).click();
        return new rechargePage();
    }
    public rechargePage exceedDueRepayment(){
        assertEquals(hc.get(1).isEnabled(), true,"not enabled");
        assertEquals(find(hc.get(1).getText(),"overdue","Due"), true);
        hc.get(1).click();
        return new rechargePage();
    }
}
