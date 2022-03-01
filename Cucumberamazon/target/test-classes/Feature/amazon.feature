Feature: Test amazon add to cart

  @searchproduct
  Scenario: Search a product in amazon
    Given Open Chrome and launch
    When Search for a product
    Then Product list should be displayed

  @addproducttocart
  Scenario: Add the searched product cart in amazon
    Given product is selected in the site
    When clicked on add to cart button
    Then product will be added to cart
