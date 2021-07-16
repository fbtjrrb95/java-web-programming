package me.screw.javawebprogramming.calculator;

import org.springframework.expression.spel.InternalParseException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public int add(String text) {
        // 빈 문자열 또는 null 값을 입력할 경우 0을 반환
        if(text == null || text.isEmpty()){
            return 0;
        }
        return sum(toInts(split(text)));
    };

    // todo: refactoring
    private List<Integer> toInts(String[] values){
        return Arrays.asList(values).stream()
                .map(elem->{
                    try {
                        int num = Integer.parseInt(elem);
                        if (num < 0) {
                            throw new RuntimeException("input positive number");
                        }
                        return num;

                    }catch (InternalParseException e){
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList())
                ;
    };

    // get sum of numbers
    // if invalid token exists, return -1;
    private int sum(List<Integer> nums){
        if(nums ==null || nums.size() <0){
            return -1;
        }

        // stream
        return nums.stream()
                .filter(elment -> elment >= 0)
                .reduce(0, Integer::sum);

    };

    private String[] split(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimeter = matcher.group(1);
            return matcher.group(2).split(customDelimeter);
        }
        return text.split(",|:");
    };

};




