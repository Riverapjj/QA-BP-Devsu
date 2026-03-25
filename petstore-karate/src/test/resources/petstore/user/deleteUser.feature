Feature: Delete user

  Scenario: Delete user

    * url baseUrl

    Given path '/user/', 'josueTest'
    When method DELETE
    Then status 200
    * path '/user/', 'josueTest'
    * method GET
    * status 404