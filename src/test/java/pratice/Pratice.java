

package pratice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import utilites.BasicOps;
import utilites.Session;
import utilites.deviceOps;
import utilites.waits;


//io.appium.android.apis C:\Users\manoj\Desktop\pratice\src\main\java\resource\screenshot\
class ses{
   public String call(){
      System.out.println("calling ses");
      return "calling ses";
   }
}

class base{
   static String mesg;
   base(){
      if(mesg==null){
        mesg=new ses().call();
      }else{
        System.out.println("printing exsisted  "+mesg);
        mesg="exsisted";
      }
   }
   
}
class v1 extends base{
   v1(){
   System.out.println("from v1");
   System.out.println(super.mesg);
   }
}
class v2 extends base{
   v2(){
   System.out.println("from v1");
   System.out.println(super.mesg);
   }
}
public class Pratice {

    public static void main(String[] args) throws IOException {
        v2 v;
//        System.out.println(v);
    }
}
