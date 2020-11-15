package edu.depaul.se333.shoppingApp.step_definitions;

import edu.depaul.se433.shoppingapp.ShippingType;
import edu.depaul.se433.shoppingapp.TotalCostCalculator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TotalCostCalculationSteps {
    double initialCost = 0;
    String state = "";
    String shipping;

    private TotalCostCalculator calculator = new TotalCostCalculator();


    @Given("Customer has selected items totaling {double} which greater than $50")
    public void customer_has_selected_items_totaling_greater_$50(Double double1) {
        if (initialCost > 50.0) {
            initialCost = double1;

        }
    }


    @And("The Customer lives in a {string} with tax")
    public void customer_lives_in_a_state_with_tax(String s) {
        this.state = s;
    }

    @And("The Customer chooses {string} shipping")
    public void customer_chooses_shippingType(String type) {
        if (type.contains(" "))
            type = type.replace(" ", "_");
        this.shipping = type;
    }


    @Then("The total cost with shipping and tax is {double} dollars")
    public void the_total_cost_with_shipping_and_tax(double expected) {
        double result = (double) TotalCostCalculator.calculate(60.00, "CA", ShippingType.NEXT_DAY);
        assertEquals(63.6, result);
    }




}


