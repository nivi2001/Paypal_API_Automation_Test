Feature: Validate Get Order feature 
	I want to get a PayPal order using this feature
 
Scenario Outline: Validate Get Order feature with valid details
Given I want to get access token from PayPal api 
When I get the order from PayPal api
And I verify the status code as "<statusCode>"

Examples:
|statusCode|
|       200|      