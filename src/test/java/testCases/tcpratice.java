/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testCases;

import org.testng.annotations.*;

/**
 *
 * @author manoj
 */
public class tcpratice {
@AfterSuite
public void afterSuit(){
    System.out.println("after suit");
}
@BeforeSuite
public void beforeSuit(){
    System.out.println("before suit");
}
@BeforeTest
public void beforeTest(){
    System.out.println("before test");
}
@AfterTest
public void afterTest(){
    System.out.println("after test");
}
@BeforeMethod
public void beforeMethod(){
    System.out.println("before test");
}
@AfterMethod
public void afterMethod(){
    System.out.println("after test");
}
@Test
public void t1(){
    System.out.println("running t1");
}
@Test
public void t2(){
    System.out.println("running t2");
}
@Test
public void t3(){
    System.out.println("running t3");
}

}
