Feature: Create quote page
  #Background:
  #Given User is logged in with UserName "abhishek.mehta@rws.com" and Password "Oriental@1234567"

  Scenario: Create a quotation
    When User click on create Quote Button
    And confirm the languages for translation
    And click on send me a quote
    Then User receives a quote

#  Scenario: Verify email template for the PJM team when user reject a quote
#    When User click on Review Button
#    And  Select the reason for Cancellation
#    And clicks on send button
#    Then User Quote has been rejected

  Scenario: Verify email template for the PJM team when user approve a quote
    When User click on Approve Button
    And  Accept T&C and click on the Approve Quote Button
    And  Select address and review summary
    And  Enter Payment details and make payment
    Then Verify transaction has been succesfull