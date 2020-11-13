package edu.depaul.se333.shoppingApp;
import static edu.depaul.se433.shoppingapp.TotalCostCalculator.calculate;
import static org.junit.jupiter.api.Assertions.*;

import edu.depaul.se433.shoppingapp.ShippingType;
import edu.depaul.se433.shoppingapp.TotalCostCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.ParameterizedTest;


import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.ParameterizedTest;
public class TotalCostCalculatorTest {

    private TotalCostCalculator calculator;


    @BeforeEach
    void setup(){

       calculator = new TotalCostCalculator();


    }





        @DisplayName("Verify Weak Normal Test")
        @ParameterizedTest
        @CsvFileSource(resources = "/weak_normal.csv", numLinesToSkip = 1)
        void weakNormalTest ( double initialCost, String state, ShippingType shipping,double expected){
            double weak = calculate(initialCost, state, shipping);
            assertEquals(expected, weak);

        }

        @DisplayName("Verify Strong Normal Test")
        @ParameterizedTest
        @CsvFileSource(resources = "/strong_normal.csv", numLinesToSkip = 1)
        void strongNormal ( double initialCost, String state, ShippingType shipping,double expected){
            double strong = calculate(initialCost, state, shipping);
            assertEquals(expected, strong);

        }


        @DisplayName("Verify Weak Robust Test")
        @ParameterizedTest
        @CsvFileSource(resources = "/weak_robust.csv", numLinesToSkip = 1)
        void weakRobust ( double initialCost, String state, ShippingType shipping,double expected){
            double weakR = calculate(initialCost, state, shipping);
            assertEquals(expected, weakR);

        }


        @DisplayName("Verify Strong Robust Test")
        @ParameterizedTest
        @CsvFileSource(resources = "/strong_robust.csv", numLinesToSkip = 1)
        void StrongRobust ( double initialCost, String state, ShippingType shipping,double expected){
            double strongR = calculate(initialCost, state, shipping);
            assertEquals(expected, strongR);

        }


        /*BOUNDARY TEST??*/

    /*Test boundary cost of 49.98, 50.00, 50.01 when shipping is STANDARD and state with TAX*/
    @Test
    @DisplayName("Test boundary when cost is 49.98 on standard shipping and state with TAX")
    void test1() {
        double result = calculate(49.98,"IL",ShippingType.STANDARD);
        assertEquals(63.57, result,2);
    }

    @Test
    @DisplayName("Test boundary when cost is 50.00 on standard shipping and state with TAX")
    void test2() {
        double result = calculate(50.00,  "NY",ShippingType.STANDARD);
        assertEquals(63.6, result,2);
    }

    @Test
    @DisplayName("Test boundary when cost is 50.01 on standard shipping and state with TAX")
    void test3() {
        double result = calculate(50.01,  "CA",ShippingType.STANDARD);
        assertEquals(53.01, result,2);
    }



    /*Test boundary cost of 49.98, 50.00, 50.01 when shipping is NEXT_DAY and state with TAX*/
    @Test
    @DisplayName("Test boundary when cost is 49.98 on next_day shipping and state with TAX")
    void test4() {
        double result = calculate(49.98,"IL",ShippingType.NEXT_DAY);
        assertEquals(79.47, result,2);
    }

    @Test
    @DisplayName("Test boundary when cost is 50.00 on next_day shipping and state with TAX")
    void test5() {
        double result = calculate(50.00,  "NY",ShippingType.NEXT_DAY);
        assertEquals(79.5, result,2);
    }

    @Test
    @DisplayName("Test boundary when cost is 50.01 on next_day shipping and state with TAX")
    void test6() {
        double result = calculate(50.01,  "CA",ShippingType.NEXT_DAY);
        assertEquals(53.01, result,2);
    }



    /*Test boundary cost of 49.98, 50.00, 50.01 when shipping is STANDARD and state with NO TAX*/
    @Test
    @DisplayName("Test boundary when cost is 49.98 on standard shipping and state with NO TAX")
    void test7() {
        double result = calculate(49.98,"CO",ShippingType.STANDARD);
        assertEquals(59.98, result,2);
    }

    @Test
    @DisplayName("Test boundary when cost is 50.00 on standard shipping and state with NO TAX")
    void test8() {
        double result = calculate(50.00,  "WI",ShippingType.STANDARD);
        assertEquals(60.00, result,2);
    }

    @Test
    @DisplayName("Test boundary when cost is 50.01 on standard shipping and state with NO TAX")
    void test9() {
        double result = calculate(50.01,  "GA",ShippingType.STANDARD);
        assertEquals(50.01, result,2);
    }


    /*Test boundary cost of 49.98, 50.00, 50.01 when shipping is NEXT_DAY and state with NO TAX*/
    @Test
    @DisplayName("Test boundary when cost is 49.98 on next_day shipping and state with NO TAX")
    void test10() {
        double result = calculate(49.98,"FL",ShippingType.NEXT_DAY);
        assertEquals(74.97, result,2);
    }

    @Test
    @DisplayName("Test boundary when cost is 50.00 on next_day shipping and state with NO TAX")
    void test11() {
        double result = calculate(50.00,  "AZ",ShippingType.NEXT_DAY);
        assertEquals(75.00, result,2);
    }
    @Test
    @DisplayName("Test boundary when cost is 50.01 on next_day shipping and state with NO TAX")
    void test12() {
        double result = calculate(50.01,  "MO",ShippingType.NEXT_DAY);
        assertEquals(50.01, result,2);
    }


    
   /*
    @Test
    @DisplayName("Test the sales tax and shipping method when total cost is 0")
    void test4() {
        assertThrows(IllegalArgumentException.class, () -> calculate(0.0, "NY",ShippingType.STANDARD));
    }


    @Test
    @DisplayName("Test standard shipping when shipping is out of country")
    void test5() {
        double result = calculate(10.0, "Turkey",ShippingType.STANDARD);
        fail("Sorry!! Shipping State is outside US");
    }*/





}



