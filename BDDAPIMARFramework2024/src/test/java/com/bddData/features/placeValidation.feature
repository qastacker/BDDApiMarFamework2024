
Feature: Validate Place API
  
 Scenario Outline: Verify if place is addedd 
    Given Add place payload with "<name>" "<language>" "<address>"
		When Usercalls "AddPlaceAPI" with post request
    Then User should get api response call with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    
    Examples:
    |name|language|address|
    |Frontline house|French-IN|29 side layout cohen 09|