Feature: Create user

  Background:
    * url "https://petstore.swagger.io/v2"

    * def user =
    """
      {
        "id": 2,
        "username": "Riverapjj2",
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

    * def userId = response.id

  Scenario: Updated email and name

    * def updateRequest =
    """
      {
        "id": 2,
        "username": "Riverapjj2",
        "firstName": "Alexander",
        "lastName": "Palacios",
        "email": "alexander@gmail.com",
        "password": "1234456",
        "phone": "12345678",
        "userStatus": 1
      }
    """

    Given path '/user/', user.username
    And request updateRequest
    When method PUT
    Then status 200

    Given path '/user/', updateRequest.username
    When method GET
    Then status 200

  Scenario: Delete user

    Given path '/user/', user.username
    When method DELETE
    Then status 200
    * path '/user/', user.username
    * method GET
    * status 404