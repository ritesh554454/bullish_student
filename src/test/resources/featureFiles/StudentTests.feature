Feature: Test Student Rest API

  Scenario: Perform test on GET API on student app
    Given Launch the get API
    When Response code is 200 OK
    Then Total student count in response is "10"


  Scenario Outline: Perform test on PUT API on student app
    Given Launch the put API "<id>" "<firstName>"
    When Response code is 200 OK
    Then Launch the get API
    And Total student count in response is "<count>"
    And Validate given param value in get response "<param_name>" "<param_value>" "<id>"
    @put
    Examples:
      | id | firstName   |  count | param_name   |  param_value  |
      | 1  | Test_update |   10   |  firstName   |  Test_update  |
      | 2  | Test_update2|   10   |  firstName   |  Test_update2 |


  Scenario Outline: Perform test on POST API on student app
    Given Launch the post API "<id>" "<firstName>" "<lastName>" "<class>" "<nationality>"
    When Response code is 200 OK
    Then Launch the get API
    And Total student count in response is "<count>"
    And Validate given param value in get response "<param_name>" "<param_value>" "<id>"
    @post
    Examples:
      | id | firstName | lastName       | class | nationality |  count  |  param_name  |  param_value    |
      | 11 | Test11    | TestLastName11 | 7 C   | Singapore   |    11   |  firstName   |  Test11         |
      | 12 | Test12    | TestLastName12 | 8 C   | Singapore   |    12   |  lastName    |  TestLastName12 |


  Scenario Outline: Perform test on DELETE API on student app
    Given Launch the delete API with id "<id>"
    When Response code is 200 OK
    Then Launch the get API
    And Total student count in response is "<count>"
    @delete
    Examples:
    | id |  count |
    | 11 |  11    |
    | 12 |  10    |
