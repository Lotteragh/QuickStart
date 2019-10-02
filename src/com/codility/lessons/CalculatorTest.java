package com.codility.lessons;

/**
 * CalcularTest
 */
public class CalculatorTest {
    @Test
    public void evaluatesExpression(){
        Calculator cal = new Calculator();
        int sum = cal.evaluate("1+2");
        //assertEquals(3, sum);
    }
    
}