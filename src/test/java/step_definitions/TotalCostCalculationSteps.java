package step_definitions;

import edu.depaul.se433.shoppingapp.ShippingType;
import edu.depaul.se433.shoppingapp.TotalCostCalculator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.ArrayList;
import java.util.Random;

import static edu.depaul.se433.shoppingapp.TotalCostCalculator.calculate;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TotalCostCalculationSteps {
    private double initalCost  = 0;
    private String state = "";
    private ShippingType shipping;

    private TotalCostCalculator calculator = new TotalCostCalculator();


    @Given("Customer has selected items totaling greater than ${double} ")
    public void customer_has_selected_items_totaling_greater_$50(Double double1) {
        if (initalCost > 50.0) {
            initalCost = double1;

        }
    }

    @And("Customer lives in a {stateWithTax} that has Tax")
    public void customer_lives_in_a_state_that_has_tax() {
        ArrayList<String> statesWithTax = new ArrayList<String>();
        statesWithTax.add("IL");
        statesWithTax.add("NY");
        statesWithTax.add("CA");


        state = statesWithTax.get(new Random().nextInt(statesWithTax.size()));
    }

    @And("Customer wants {shipping} Shipping")
    public void customer_wants_next_day_shipping() {
        shipping = ShippingType.NEXT_DAY;
    }

    @Then("The total cost with shipping/tax is {double} dollars")
    public void the_total_cost_with_shipping_and_tax(double expected){
        double result = calculate(60.00,  "CA",ShippingType.NEXT_DAY);
        assertEquals(63.6, expected,2);
    }



}


