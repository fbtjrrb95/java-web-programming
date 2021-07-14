package me.screw.javawebprogramming.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void add_null(){
        assertEquals(0,stringCalculator.add(null));
    }

    @Test
    public void add_빈문자(){
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void add_contains_only_comma(){
        assertEquals(6, stringCalculator.add("1,2,3"));
    }

    @Test
    public void add_contains_only_colon(){
        assertEquals(6,stringCalculator.add("1:2:3"));
    }

    @Test
    public void add_contains_comma_colon(){
        assertEquals(6,stringCalculator.add("1,2:3"));
    }


}