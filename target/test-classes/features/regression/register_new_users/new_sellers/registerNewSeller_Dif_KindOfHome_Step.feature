Feature: 01 - Register New Seller from main page
  description
  Scenario: 01 - What kind of home "Single Family"
    Given Predefine USER NAME, EMAIL, PASSWORD, PHONE
    When Click "Sell" tab and input "1130 Bluffs Parkway, Canton, GA, USA" into compare field
    When Into New Seller Flow step: How soon are you looking to sell, choose "Right Away"
    When Into New Seller Flow step: What kind of home are you looking to sell, choose "Single Family"
    When Into New Seller Flow step: How much do you think your home will sell for, choose "Max price"
    When Enter predefined USER NAME and "1130 Bluffs Parkway, Canton, GA, USA"
    And Click continue
    When Enter predefined EMAIL
    And Click continue
    When Enter phone "(545) 234-6241"
    And Click continue
    When Click Skip for now
    Then Check than we have more "3" agent for new customer

Scenario: 02 - What kind of home "Condo or Townhouse"
    Given Predefine USER NAME, EMAIL, PASSWORD, PHONE
    When Click "Sell" tab and input "1130 Bluffs Parkway, Canton, GA, USA" into compare field
    When Into New Seller Flow step: How soon are you looking to sell, choose "1-3 Months"
    When Into New Seller Flow step: What kind of home are you looking to sell, choose "Condo or Townhouse"
    When Into New Seller Flow step: How much do you think your home will sell for, choose "Max price"
    When Enter predefined USER NAME and "1130 Bluffs Parkway, Canton, GA, USA"
    And Click continue
    When Enter predefined EMAIL
    And Click continue
    When Enter phone "(545) 234-6241"
    And Click continue
    When Click Skip for now
    Then Check than we have more "3" agent for new customer

Scenario: 03 - What kind of home "Multi-Family"
    Given Predefine USER NAME, EMAIL, PASSWORD, PHONE
    When Click "Sell" tab and input "1130 Bluffs Parkway, Canton, GA, USA" into compare field
    When Into New Seller Flow step: How soon are you looking to sell, choose "4+ Months"
    When Into New Seller Flow step: What kind of home are you looking to sell, choose "Multi-Family"
    When Into New Seller Flow step: How much do you think your home will sell for, choose "Max price"
    When Enter predefined USER NAME and "1130 Bluffs Parkway, Canton, GA, USA"
    And Click continue
    When Enter predefined EMAIL
    And Click continue
    When Enter phone "(545) 234-6241"
    And Click continue
    When Click Skip for now
    Then Check than we have more "3" agent for new customer

Scenario: 04 - What kind of home "Mobile Home"
    Given Predefine USER NAME, EMAIL, PASSWORD, PHONE
    When Click "Sell" tab and input "1130 Bluffs Parkway, Canton, GA, USA" into compare field
    When Into New Seller Flow step: How soon are you looking to sell, choose "Already Listed"
    When Into New Seller Flow step: What kind of home are you looking to sell, choose "Mobile Home"
    When Into New Seller Flow step: How much do you think your home will sell for, choose "Max price"
    When Enter predefined USER NAME and "1130 Bluffs Parkway, Canton, GA, USA"
    And Click continue
    When Enter predefined EMAIL
    And Click continue
    When Enter phone "(545) 234-6241"
    And Click continue
    When Click Skip for now
    Then Check than we have more "3" agent for new customer

Scenario: 05 - What kind of home "Vacant Lot"
    Given Predefine USER NAME, EMAIL, PASSWORD, PHONE
    When Click "Sell" tab and input "1130 Bluffs Parkway, Canton, GA, USA" into compare field
    When Into New Seller Flow step: How soon are you looking to sell, choose "Already Listed"
    When Into New Seller Flow step: What kind of home are you looking to sell, choose "Vacant Lot"
    When Into New Seller Flow step: How much do you think your home will sell for, choose "Max price"
    When Enter predefined USER NAME and "1130 Bluffs Parkway, Canton, GA, USA"
    And Click continue
    When Enter predefined EMAIL
    And Click continue
    When Enter phone "(545) 234-6241"
    And Click continue
    When Click Skip for now
    Then Check than we have more "3" agent for new customer

Scenario: 06 - What kind of home "Commercial"
    Given Predefine USER NAME, EMAIL, PASSWORD, PHONE
    When Click "Sell" tab and input "1130 Bluffs Parkway, Canton, GA, USA" into compare field
    When Into New Seller Flow step: How soon are you looking to sell, choose "Already Listed"
    When Into New Seller Flow step: What kind of home are you looking to sell, choose "Commercial"
    When Into New Seller Flow step: How much do you think your home will sell for, choose "Max price"
    When Enter predefined USER NAME and "1130 Bluffs Parkway, Canton, GA, USA"
    And Click continue
    When Enter predefined EMAIL
    And Click continue
    When Enter phone "(545) 234-6241"
    And Click continue
    When Click Skip for now
    Then Check than we have more "3" agent for new customer
