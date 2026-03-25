Feature: Update email and name

    Scenario: Update email and name

        * url baseUrl

        * def updateRequest =
        """
              {
                "id": 2,
                "username": "josueTest",
                "firstName": "Alexander",
                "lastName": "Palacios",
                "email": "alexander@gmail.com",
                "password": "1234456",
                "phone": "12345678",
                "userStatus": 1
              }
            """

        Given path '/user/', 'josueTest'
        And request updateRequest
        When method PUT
        Then status 200
        * path '/user/', updateRequest.username
        * method GET
        * status 200