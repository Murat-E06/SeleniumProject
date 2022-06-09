package com.cydeo.tests.day05_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

    @BeforeClass//only run 1 time to top of the test process
    public void setUpClass(){
        System.out.println("---->BeforeClass is running");
    }

    @AfterClass//only run 1 time to end of the test process
    public void tearDownClass(){
        System.out.println("--->AfterClass is running");
    }

    @BeforeMethod//5(Annotation-dip not açıklama)//runs before each test process
    public void setUpMethod(){//6
        System.out.println("--->Before method is running!"); //7
    }

    @AfterMethod//9
    public void tearDownMethod(){//8 runs before each test process
        System.out.println("--->After method is running!");
    }

    @Test//2(Annotation-dip not açıklama)(priority=1)
    public void test1(){//1
        System.out.println("Test 1 is running...");//4

        //ASSERT EQUALS: campare 2 of the same things
        String actual="apple";
        String expected="apple";//if they are not same it gives Failures: 1

        Assert.assertEquals(actual,expected);

    }

    @Test//(priority=2)
    public void test2(){
        System.out.println("Test 2 is running...");

        //AssertTrue
        String actual="apple";
        String expected="apple2";// it gives Failures: 1

        Assert.assertTrue(actual.equals(expected));// it gives Failures: 1 and false
    }

}
