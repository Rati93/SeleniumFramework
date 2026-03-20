Feature: E-commerce user journey
Scenario: User buy a product  

Given User launches the browser
When User navigates to the application
And User logs in with valid credentials
And User searches for "Laptop"
And User adds the product to cart
Then product should be visible in cart