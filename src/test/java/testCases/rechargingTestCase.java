
package testCases;

import PageObject.PageBase;
import PageObject.homePage;
import PageObject.rechargePage;
import PageObject.detailsPage;
import PageObject.loginPage;
import io.appium.java_client.AppiumDriver;
import java.io.IOException;
import org.testng.ITest;
import org.testng.annotations.*;
import utilites.BasicOps;
import utilites.Session;
import utilites.deviceOps;
import utilites.waits;

/**
 *
 * @author manoj
 */
public class rechargingTestCase {
    private static AppiumDriver driver;
    private Session s;
    private PageBase p;
    public rechargingTestCase() {
    }
    @BeforeSuite
    public void setSession() throws IOException{
        System.out.println("before suit");
        p=new PageBase();
    }
    @BeforeTest
    public void record(){
        BasicOps ops = new BasicOps();
        ops.startRecord();
    }
    @AfterSuite
    public void endSession(){
        deviceOps ops = new deviceOps(p.getDriver());
        ops.resetOrRemoveApp("remove","com.fampay.in.debug");
       
        System.out.println("ended session");
    }
    @Test
    public void recharge() throws InterruptedException{
        System.out.println("rechring test ase are executed");
    waits w =new waits(p.getDriver());
        w.Wait(30);
        loginPage login =new loginPage();
        homePage home = login.loginSuccessful();
        rechargePage recharge = home.recharge();
        detailsPage detail =recharge.pay();
        detail.checkPaymentStatus();
        
    }
    
    
    @AfterTest
    public void cleanApp(){
        System.out.println("after test");
        BasicOps ops = new BasicOps();
        ops.stopRecord("testing.mp4");
    }
//    
//    @BeforeClass
//    public static void setUpClass() throws Exception {
//    }
//
//    @AfterClass
//    public static void tearDownClass() throws Exception {
//    }
//
//    @BeforeMethod
//    public void setUpMethod() throws Exception {
//    }
//
//    @AfterMethod
//    public void tearDownMethod() throws Exception {
//    }
    
}
