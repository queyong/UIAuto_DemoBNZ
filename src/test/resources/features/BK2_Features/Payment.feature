Feature: Test scenarios for Payment

  @TBD
  Scenario Outline: Verify successful transfer in Payments page
    When I Navigate to Payments Page
    And I make following transfer
      | amount      | accountFrom     |  accountTo      |
      | <amount>    | <accountFrom>   |   <accountTo>   |
    Then I see the balance of following account are correct
     | accountFrom     |  accountTo     |
     | <accountFrom>   |  <accountTo>   |

    Examples:
      | amount    | accountFrom   |  accountTo    |
      | 500       | Everyday      |   Bills        |
      | 500       | Everyday      |   Bills        |
      | 500       | Everyday      |   Bills        |