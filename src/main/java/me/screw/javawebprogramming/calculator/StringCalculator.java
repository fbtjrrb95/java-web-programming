package me.screw.javawebprogramming.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    // if text can be cast to number return casted number
    // else return -1
    private int getNumber(String text){
        try{
            return Integer.parseInt(text);
        }catch (Exception e){
            return -1;
        }
    }
    // get tokens sum
    // if invalid token exists, return -1;
    private int getSum(String[] tokens){
        int result = 0;
        int number = -1;
        int validTokenCnt=0;

        for(String token : tokens){
            number = getNumber(token);
            if(number <= -1) {
                break;
            }
            validTokenCnt += 1;
            result += number;
        }

        return validTokenCnt == tokens.length ? result : -1;
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
        String[] tokens = text.split(",|:");
        if(tokens.length >0) {
            int sum = getSum(tokens);
            if(sum >= 0){
                return sum;
            }
        }


        // custom delimeter를 설정한 경우
        tokens = null;
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(matcher.find()){
            String customDelimeter = matcher.group(1);
            tokens = matcher.group(2).split(customDelimeter);
            if(tokens.length >0) {
                int sum = getSum(tokens);
                if(sum >=0){
                    return sum;
                }
            }
        }

        return -1;

    };

};




