Feature: 01 - Register New Seller from main page
  description
  Scenario: 01 - How much to sell "Max price"
    Given Predefine USER NAME, EMAIL, PASSWORD, PHONE
    When Click "Sell" tab and input "4211 South Avalon Boulevard, Los Angeles, CA, USA" into compare field
    When Into New Seller Flow step: How soon are you looking to sell, choose "Right Away"
    When Into New Seller Flow step: What kind of home are you looking to sell, choose "Single Family"
    When Into New Seller Flow step: How much do you think your home will sell for, choose "Max price"
    When Enter predefined USER NAME and "4211 South Avalon Boulevard, Los Angeles, CA, USA"
    And Click continue
    When Enter predefined EMAIL
    And Click continue
    When Enter phone "(545) 234-6241"
    And Click continue
    When Click Skip for now
    Then Check than we have more "3" agent for new customer

Scenario: 02 - How much to sell "Min price"
    Given Predefine USER NAME, EMAIL, PASSWORD, PHONE
    When Click "Sell" tab and input "4211 South Avalon Boulevard, Los Angeles, CA, USA" into compare field
    When Into New Seller Flow step: How soon are you looking to sell, choose "1-3 Months"
    When Into New Seller Flow step: What kind of home are you looking to sell, choose "Single Family"
    When Into New Seller Flow step: How much do you think your home will sell for, choose "Min price price"
    When Enter predefined USER NAME and "4211 South Avalon Boulevard, Los Angeles, CA, USA"
    And Click continue
    When Enter predefined EMAIL
    And Click continue
    When Enter phone "(545) 234-6241"
    And Click continue
    When Click Skip for now
    Then Check than we have more "3" agent for new customer

Scenario: 03 - How much to sell "Mid price"
    Given Predefine USER NAME, EMAIL, PASSWORD, PHONE
    When Click "Sell" tab and input "4211 South Avalon Boulevard, Los Angeles, CA, USA" into compare field
    When Into New Seller Flow step: How soon are you looking to sell, choose "4+ Months"
    When Into New Seller Flow step: What kind of home are you looking to sell, choose "Single Family"
    When Into New Seller Flow step: How much do you think your home will sell for, choose "Mid price"
    When Enter predefined USER NAME and "4211 South Avalon Boulevard, Los Angeles, CA, USA"
    And Click continue
    When Enter predefined EMAIL
    And Click continue
    When Enter phone "(545) 234-6241"
    And Click continue
    When Click Skip for now
    Then Check than we have more "3" agent for new customer
