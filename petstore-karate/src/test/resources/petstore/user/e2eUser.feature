Feature: E2E CRUD users

  Scenario: E2E CRUD users

    * call read('createUser.feature')
    * call read('getUser.feature')
    * call read('updateUser.feature')
    * call read('deleteUser.feature')