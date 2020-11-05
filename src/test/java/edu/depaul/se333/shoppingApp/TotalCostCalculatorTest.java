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















    @Test
    @DisplayName("test standard shipping when total cost is 50")
    void test1() {
        double result = calculate(50.0, "Colarado",ShippingType.STANDARD);
        assertEquals(60.0, result);
    }

    @Test
    void test2() {
        double result = calculate(60.0, "IL",ShippingType.STANDARD);
        assertEquals(63.6, result);
    }
    @Test
    void test3() {
        double result = calculate(40.0, "NY",ShippingType.STANDARD);
        assertEquals(53.0, result);
    }


    @Test
    @DisplayName("Test boundary when cost is 49.98 on standard shipping")
    void test4() {
        double result = calculate(49.98,"WI",ShippingType.STANDARD);
        assertEquals(59.98, result);
    }

    @Test
    @DisplayName("Test boundary when cost is 50.01 on standard shipping")
    void test5() {
        double result = calculate(50.01,  "WI",ShippingType.STANDARD);
        assertEquals(50.01, result);
    }

   /*
    @Test
    @DisplayName("Test the sales tax and shipping method when total cost is 0")
    void test6() {
        assertThrows(IllegalArgumentException.class, () -> calculate(0.0, "NY",ShippingType.STANDARD));
    }


    @Test
    @DisplayName("Test standard shipping when shipping is out of country")
    void test7() {
        double result = calculate(10.0, "Turkey",ShippingType.STANDARD);
        fail("Sorry!! Shipping State is outside US");
    }*/





}



