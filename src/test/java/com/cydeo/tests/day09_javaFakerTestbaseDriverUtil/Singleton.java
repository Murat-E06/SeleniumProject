package com.cydeo.tests.day09_javaFakerTestbaseDriverUtil;

public class Singleton {

    //#1. Create private const.
    private Singleton(){}

    //#2. Create private static String
    //prevent access and provide a getter method
    private static String word;

    //This utility method will return the "word" in the way we want to return
    public static String getWord(){

        if(word==null){
            System.out.println("First time call. Word object is null. "+"Assigning value to it now!");
            word="something";
        }else {
            System.out.println("Word has already value.");
        }
        return word;

    }

}
