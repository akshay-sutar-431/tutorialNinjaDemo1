Feature: Register Account functionality
Background:
	Given User launch the browser
	When User open the application URL "http://tutorialsninja.com/demo"
	And User click on My Account drop menu and click on Register option
Scenario: Verify Registering an Account by providing only the Mandatory fields
	And User enter the new account details into mandatory fields
	And click on Continue button
	Then User should logged in, taken to Account page and proper details should displayed on the page
	And close browser

Scenario: Verify proper notification messages are displayed for the mandatory fields, when you don't provide any fields in the 'Register Account' page and submit
	When User open the application URL "http://tutorialsninja.com/demo"
	And User click on My Account drop menu and click on Register option
	And Don't enter anything into the fields and click on Continue button
	Then Warning messages should be displayed for the respective fields
	And close browser

