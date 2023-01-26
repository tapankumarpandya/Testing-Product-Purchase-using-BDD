Feature: Purchase product from Ecommerce website

  Scenario Outline: Purchase a product from an Ecommerce website
    Given User is already on Login Page
		When Title of login page is Lets Shop
		Then User enters "<username>" and "<password>"
		Then User clicks on login button
		And user is on home page.
		Then user adds "<product>" to cart.
		Then user clicks on "<cart>"
		Then user clicks to "<checkout>" button.
		Then user enters "<country>" and selects country from dropdown.
		Then user finally "<placeorder>".
		And user receives order confirmation number on the next page.
		


    Examples: 
      | username  | password | product  | cart | checkout | country | placeorder |
      | tpan311@gmail.com | Tp@123456 | button[class='btn w-10 rounded'] | //button[@routerlink='/dashboard/cart'] | //button[text()='Checkout'] | //input[@placeholder='Select Country'] | //a[text()='Place Order '] |
