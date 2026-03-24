Feature: Create user

  Background:
    * url "https://petstore.swagger.io/v2"

    * def user =
    """
      {
        "id": 0,
        "username": "Riverapjj",
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

    * print 'username created: ', user.username

  Scenario: Find user by username

    Given path '/user/', user.username
    When method GET
    Then status 200
    And match response.username == user.username
