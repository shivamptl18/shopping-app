Feature: Shopping Cart Total Cost Calculation
  Scenario: If the Customer lives in a state with tax and
  total cost is greater than $50 shipping is free
    Given Customer has selected items totaling 60.00 which greater than $50
    And The Customer lives in a "state" with tax
    And The Customer chooses "NEXT_DAY" shipping
    Then The total cost with shipping and tax is 63.6 dollars



