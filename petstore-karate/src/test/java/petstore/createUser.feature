Feature: Create user

  Background:
    * url "https://petstore.swagger.io/v2"

    * def user =
    """
      {
        "id": 0,
        "username": "Riverapj",
        "firstName": "Josue",
        "lastName": "Rivera",
        "email": "josue@gmail.com",
        "password": "1234456",
        "phone": "12345678",
        "userStatus": 1
      }
    """

  Scenario: Create user

    Given path '/user'
    And request user
    When method POST
    Then status 200

