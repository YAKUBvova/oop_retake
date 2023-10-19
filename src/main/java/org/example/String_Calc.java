package org.example;

import java.util.ArrayList;
import java.util.List;

public class String_Calc {
    public int adding(String numbers){
        int result = 0 ;
        int start = 0 ;
        int end_ ;
        int i = 0;
        while (i<numbers.length()){

                try{
                    if (numbers.startsWith(",", i)) {
                        end_ = i;
                        i += 1;
                        try {
                            int number = Integer.parseInt(numbers.substring(start, end_));
                            result += number;
                        } catch (NumberFormatException e) {
                            throw new NumberFormatException("Error! Invalid format");
                        }
                        start = end_ + 1;
                        if (start == numbers.length()) {
                            throw new NumberFormatException("Error! Invalid format");
                        }

                    }
                }catch (StringIndexOutOfBoundsException e){
                    System.out.print("indexOut");
                }

            if (i == numbers.length()-1) {
                result += Integer.parseInt(numbers.substring(start));
                return result ;
            }
            i++;
        }
        return Integer.parseInt(numbers) ;
    }

    public int add (String numbers){
        if (numbers.length() == 0) return 0 ;
        return adding(numbers);
    }
}
