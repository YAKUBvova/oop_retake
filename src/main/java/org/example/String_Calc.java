package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class String_Calc {
    public List<String> delimiters = new ArrayList<>();
    {
        delimiters.add(",");
        delimiters.add("\n");
    }
    public void edit(List<String> del){

        delimiters.addAll(del);
    }
    public void list_clean(){
        while (delimiters.size()>2){
            delimiters.remove(2);
        }
    }
    public String custom_del(String str){
        int start =2 ;
        int end ;
        List<String> res = new ArrayList<>();
        for (int i =2 ; i < str.length();i++){
            if (str.charAt(i)=='['&& str.charAt(i+1)!='\n')start=i+1;
            if (str.charAt(i)==']'&& str.charAt(i-1)!='/'){
                end = i;
                res.add(str.substring(start,end));
                start = i+1;
            }
            if (str.charAt(i)=='\n'){
                if (res.contains("")){throw new UnsupportedOperationException("Error! Enter delimetr!");}
//                res.sort(Collections.reverseOrder());
                edit(res);
                return str.substring(i+1);
            }
        }
        return "";
    }
    public int adding(String numbers){
        int result = 0 ;
        int start = 0 ;
        int end_ ;
        int i = 0;
        List<String> negative_dig = new ArrayList<>();
        while (i<numbers.length()){
            for (String delimiter : delimiters) {
                try {
                    if (numbers.startsWith(delimiter, i)) {
                        end_ = i;
                        i += delimiter.length();
                        if (numbers.charAt(start) == '-') {
                            negative_dig.add(numbers.substring(start, end_));
                        }
                        try {
                            int number = Integer.parseInt(numbers.substring(start, end_));
                            if (number > 1000) {
                                start = end_ + delimiter.length();
                                break;
                            }
                            result += number;
                        } catch (NumberFormatException e) {
                            list_clean();
                            throw new NumberFormatException("Error! Invalid format");
                        }
                        start = end_ + delimiter.length();
                        if (start == numbers.length()) {
                            list_clean();
                            throw new NumberFormatException("Error! Invalid format");
                        }

                    }
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.print("indexOut");
                }
            }
            if (i == numbers.length()-1) {
                if (!(Integer.parseInt(numbers.substring(start))>1000)){
                    result += Integer.parseInt(numbers.substring(start));
                }
                list_clean();
                if (numbers.charAt(start)=='-'){
                    negative_dig.add(numbers.substring(start));
                }
                if (negative_dig.size()>0){
                    throw new UnsupportedOperationException("Error! Negative numbers: "+negative_dig);
                }
                return result ;
            }
            i++;
        }
        list_clean();
        if (numbers.charAt(0)=='-'){
            System.out.println("Error! Nonsupported negative digit: "+numbers);
            return -1;
        }
        return Integer.parseInt(numbers) ;
    }

    public int add (String numbers){
        if (numbers.length() == 0) return 0 ;
        if (numbers.startsWith( "//")){
            numbers=custom_del(numbers);
            if (numbers.equals("")) {
                throw new NumberFormatException("Error! Invalid format");
            }
        }
        return adding(numbers);
    }
}
