package org.example;


public class String_Calc {

    public int add (String numbers){
        if (numbers.length() == 0) return 0 ;
        if (numbers.contains(",")) {
            return Integer.parseInt(numbers.substring(0,numbers.indexOf(",")))+
                   Integer.parseInt(numbers.substring(numbers.indexOf(",")+1));
        }
        else return Integer.parseInt(numbers);
    }
}
