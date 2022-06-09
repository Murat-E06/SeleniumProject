package com.cydeo.tests.day08_propoties_config_reader;

import org.testng.annotations.Test;

public class LearningProperties {
    @Test
    public void java_properties_reading_test(){
         // key=value
        //os.name=Windows 7
        //user.name=Murat
        System.out.println("System.getProperties(\"os.name\") = " + System.getProperty("os.name"));//Windows 7
        System.out.println("System.getProperties(\"user.name\") = " + System.getProperty("user.name"));//Murat
    }
}
