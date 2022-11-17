package com.example.hahowspringboot.lab07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    public void add(){
        Calculator calculator=new Calculator();
        int result = calculator.add(1, 1);
//      斷言值不為null
        assertNotNull(result);
//      斷言/檢查值是否相等
        assertEquals(2,result);
//      assertEquals(10,result,"加法有問題");
//      斷言值為true
        assertTrue(result>1);
    }
    @Test
    public void divide(){
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class,() -> {
            int result = calculator.divide(1, 0);
        } );
    }
}