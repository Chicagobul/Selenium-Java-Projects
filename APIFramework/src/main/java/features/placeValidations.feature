Feature: Validating Place API's

  @AddPlace @Regression
  Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
    Given Add Place Payload with "<name>" "<language>" "<address>"
    When User calls "AddPlaceAPI" with "Post" http request
    Then The API call got success with Status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_id created maps to "<name>" using "getPlaceAPI"

    Examples:
      | name           | language | address            |
      | Acoustic House | English  | World cross center |
     # | Clock House    | German   | Sea cross center   |
  #in feature file we use '#' to comment anything

   @DeletePlace @Regression
   Scenario: Verify if DeletePlace functionality is working
     Given DeletePlace Payload
     When User calls "deletePlaceAPI" with "Post" http request
     Then The API call got success with Status code 200
     And "status" in response body is "OK"

   # @AddPlace and @DeletePlace are the tag names we have given to our scenarios
   # Our scenarios can have multiple tags such as we can use @Regression tag also with add or delete place