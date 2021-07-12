package me.screw.javawebprogramming.calculator;

import java.util.Arrays;

public class StringCalculator {
    // if text can be cast to number return casted number
    // else return -1
    public int getNumber(String text){
        int number = -1;
        try{
            number = Integer.parseInt(text);
        }catch (Exception e){}
        return number;
    }
    public int add(String text) {

        // 빈 문자열 또는 null 값을 입력할 경우 0을 반환
        if(text == null || text.isEmpty()){
            return 0;
        }

        // 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환
        if(text.length() == 1){
            int number = getNumber(text);
            if(number >=0) {
                return number;
            }
        }

        // 구분자 ',' or ':' 입력할 경우 두 숫자의 합을 반환한다.
        String[] numbers = text.split(",|:");
        int result =0;
        int _number =-1;
        for(String n : numbers){
            _number = getNumber(n);
            System.out.println(_number);
            if(_number <= -1) {
                break;
            }
            result +=  _number;
            return result;
        }

        return -1;

    };

};




