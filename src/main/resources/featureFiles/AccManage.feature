Feature: Account Management

  Background: Returning on Homepage
  Given user is logged in acc

  Scenario: Business User - Add contact number in Profile Management
    When Click on Profile Management in the Account Management page
    And Click the Add Contact Number button
    And Select the country code, enter a contact number, and click SAVE
    Then Verify that the newly added contact number is displayed on the My Profile page

  Scenario: Business User - Add New Address in Profile Management
    When Click on Profile Management in the Account Management page
    And Click the Add address button
    And Fill in all required fields.
    And click on the save button
    Then Verify that the newly added address is displayed on the My Profile page

    Scenario: Business User - Verify new address reflects in CC and Pay by Invoice flows
      When Add a new address via Billing Preferences.
      And Navigate to the CC payment flow and verify the new address is displayed
      Then Navigate to the Pay by Invoice flow and verify the new address is displayed.

