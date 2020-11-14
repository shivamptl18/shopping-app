Feature: Shopping Cart Total Cost Calculation
  Scenario: If the Customer lives in a state with tax and
  total cost is greater than $50 shipping is free
    Given Customer has selected items totaling greater than $50
    And The customer lives in a state with tax "IL", "NY", "CA"
    And The customer wants "NEXT_DAY" shipping
    Then The total cost with shipping/tax is 63.6 dollars

