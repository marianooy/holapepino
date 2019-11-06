
@FirstTest
Feature: Is it Friday yet?

Everybody wants to know when it's Friday
@SpecificTest
Scenario Outline: Today is or is not Friday
Given today is "<day>"
When I ask whether it's Friday yet
Then I should be told "<answer>"

Examples:
   | day          | answer |
   | Friday       | Awiwi  |
   | Sunday       | Nope   |
   | anything else| Nope   |

   @SmokeTest @RegressionTest
   Scenario: Successful Login
      Given This is a blank test

   @RegressionTest
   Scenario: UnSuccessful Login
      Given This is a blank test

   @SmokeTest
   Scenario: Add a product to bag
      Given This is a blank test

   Scenario: Add multiple product to bag
      Given This is a blank test

   @SmokeTest @RegressionTest
   Scenario: Remove a product from bag
      Given This is a blank test

   @RegressionTest
   Scenario: Remove all products from bag
      Given This is a blank test

   @SmokeTest
   Scenario: Increase product quantity from bag page
      Given This is a blank test

   Scenario: Decrease product quantity from bag page
      Given This is a blank test

   @SmokeTest @End2End
   Scenario: Buy a product with cash payment
      Given This is a blank test

   @SmokeTest @End2End
   Scenario: Buy a product with CC payment
      Given This is a blank test

   @End2End
   Scenario Outline: Payment declined
      Given This is a blank test
      Examples:
         |PaymentMethod|
         |CC Card|
         |DD Card|
         |Bank Transfer|
         |PayPal|
         |Cash|

      @MarinTest
      Scenario Outline: Testing User data
         Given user name is "<name>"
         When get <user_id> as user id
         Then token should be <token> number
         Examples:

         |name|user_id|token|
         |marino|  2   |123456789|
         #|lucia |  2   |123456789|
         #|marino|  3   |123456789|
         #|marino|  2   |987654321|
