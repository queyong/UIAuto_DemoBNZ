@Demo
Feature:Test scenarios for Payees page

  Background:
    When I navigate demo main page
    When I click Menu button
    And I click "Payees" item from Menu


  Scenario:Verify user can navigate to Payees page using the navigation menu
    Then I can see Payees page is loaded


  Scenario Outline:Verify user can add new payee in the Payees page
    When I click Add button
    And I add following Payee details into the table
      | name        | account   |
      | <userName>  | <account> |
    And I click Add button in the table
    Then I can see the "Payee added" is displayed
    And I can see the following Payee is added in the list
      | name        | account   |
      | <userName>  | <account> |

    Examples:
      | userName  | account              |
      | testUser  | 01-1111-1234567-001  |


  Scenario:Verify payee name is a required field
    When I click Add button
    And I click Add button in the table
    And I can see the error message in the table
    And I add following Payee details into the table
      | name        | account               |
      | testUser    | 01-1111-1234567-001  |
    Then the error messages in the table are gone

    Scenario Outline:Verify that payees can be sorted by name
      When I click Add button
      And I add following Payee details into the table
        | name        | account               |
        | <userName>    | <account>  |
      And I click Add button in the table
      And I can see the following Payee is added in the list
        | name      | account   |
        | <userName>  | <account>  |
      Then I can see the list is sorted in "ascending" order
      And I click the Name header
      Then I can see the list is sorted in "descending" order

      Examples:
        | userName  | account              |
        | testUser  | 01-1111-1234567-001  |