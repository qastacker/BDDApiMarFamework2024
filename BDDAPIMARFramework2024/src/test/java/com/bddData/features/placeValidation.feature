
Feature: Validate Place API
  
 Scenario: Verify if place is addedd 
    Given Add place payload
		When Usercalls "AddPlaceAPI" with post request
    Then User should get api response call with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"