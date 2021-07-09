package me.screw.javawebprogramming.calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator cal;

    @BeforeEach
    public void setup(){
        cal = new Calculator();
    }

    @Test
    public void add() {
        assertEquals(9,cal.add(6,3));
    }

    @Test
    public void subtract() {
        assertEquals(3, cal.subtract(6,3));
    }

    @Test
    public void multiply() {
        assertEquals(18,cal.multiply(6,3));
    }

    @Test
    public void divide() {
        assertEquals(2,cal.divide(6,3));
    }
}