/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import static org.testng.Assert.*;

/**
 *
 * @author manoj
 */
public class loginPage extends PageBase {
    @FindBy(id="cta_button") private MobileElement enter_fampay;
    @FindBy(id="phone_number_edit_text") private MobileElement phone_no;
    @FindBy(id="debug_server_url_input") private MobileElement url;
    @FindBy(id="update_debug_url_button") private MobileElement url_button;
    @FindBy(id="submit_button") private MobileElement login;
    public loginPage() {
        
    }
    
    public homePage loginSuccessful(){
        enter_fampay.click();
        phone_no.sendKeys("9501101147");
        String site="https://sachetbnpl-westeros.dev.fampay.co/";
        url.clear();
        url.sendKeys(site);
        url_button.click();
         assertEquals(login.isEnabled(),true, "not enabled");
         login.click();
        return new homePage();
    }
    public void loginChecks(){
        
    }
    
}
