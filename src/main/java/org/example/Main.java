package org.example;

public class Main {
    public static void main(String[] args){
        String_Calc str = new String_Calc();
        int result = str.add("//[f]\n1\n22f3,-5,-6,5");
        System.out.println(result);
    }

}