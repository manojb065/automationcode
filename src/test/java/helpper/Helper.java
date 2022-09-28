/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpper;

import io.appium.java_client.AppiumDriver;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.Base64;
import org.apache.commons.io.FileUtils;
/**
 *
 * @author manoj
 */
public class Helper {
    private static File f;
    private static String name;
    public static void saveFile(String path,File file) throws IOException{
        if(isPathExsist(path)){  
            
        FileUtils.copyFile(file,new File(path+"\\"+file.getName().replace(".png", ".jpeg")));
        }else
        throw new IOException(path+" does exsist");
    }
    
    public static void saveRecording(String path,String file){
//        f=new File(path);
     
        System.out.println("entered started to save");
        try {
//               f.createNewFile();
                byte[] decodedBytes = Base64.getDecoder().decode(file.getBytes());
          FileOutputStream out = new FileOutputStream(path);
         System.out.println(" saveing ...");
            out.write(decodedBytes);
            System.out.println("written");
// 
//            System.out.println("Successfully"
//                               + " byte inserted");
// 
            out.close();
        }
 
        // Catch block to handle the exceptions
        catch (Exception e) {
 
            // Display exception on console
            System.out.println("Exception: " + e);
        }
    }
    public static boolean isPathExsist(String path){
        f =new File(path);
//        name=f.getName();
        
        return f.exists();
    } 
    
    
    
}


