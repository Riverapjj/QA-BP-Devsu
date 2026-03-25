Feature: Find user by username

  Scenario: Find user by username

    * url baseUrl

    Given path '/user/', 'josueTest'
    When method GET
    Then status 200
    And match response.username == 'josueTest'

    * print response