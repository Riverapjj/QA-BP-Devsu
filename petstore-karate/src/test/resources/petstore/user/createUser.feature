Feature: Create user

  Background:
    * url baseUrl

    * def user =
    """
      {
        "id": 2,
        "username": "josueTest",
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