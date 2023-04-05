@SelectHotel
Feature: Verifying OMR Branch Select hotel page Automation

  Background: 
    Given User is on the Omr Branch hotel page

  Scenario Outline: Verifying navigate to book hotel upon accepting the alert
    When User login the "<username>","<password>"
    Then User should verify success message after login "Welcome A. k. Ajin"
    When User enter all field "<state>","<city>","<roomType>","<checkin>","<checkout>","<no_room>","<no_adult>" and "<no_child>"
    Then User should verify success message after select hotel "Select Hotel"
    When User select the hotel
    And User accept the alert message
    Then User should verify success message after book hotel "Book Hotel" and save the hotel name

    Examples: 
      | username                    | password | state       | city | roomType | checkin    | checkout   | no_room | no_adult | no_child |
      | ajinalexander1999@gmail.com | Appa@123 | Maharashtra | Pune | Standard | 2023-03-25 | 2023-03-27 | 1-One   | 2-Two    |        1 |

  Scenario Outline: Verifying navigate to book hotel upon dismiss the alert
    When User login the "<username>","<password>"
    Then User should verify success message after login "Welcome A. k. Ajin"
    When User enter all field "<state>","<city>","<roomType>","<checkin>","<checkout>","<no_room>","<no_adult>" and "<no_child>"
    Then User should verify success message after select hotel "Select Hotel"
    When User select the hotel
    And User dismiss the alert message
    Then User should verify success message after select hotel "Select Hotel"

    Examples: 
      | username                    | password | state       | city | roomType | checkin    | checkout   | no_room | no_adult | no_child |
      | ajinalexander1999@gmail.com | Appa@123 | Maharashtra | Pune | Standard | 2023-03-25 | 2023-03-27 | 1-One   | 2-Two    |        1 |

  Scenario Outline: Verifying sorting funtionality hotel price from High to low
    When User login the "<username>","<password>"
    Then User should verify success message after login "Welcome A. k. Ajin"
    When User enter all field "<state>","<city>","<roomType>","<checkin>","<checkout>","<no_room>","<no_adult>" and "<no_child>"
    Then User should verify success message after select hotel "Select Hotel"
    When User click the radio button High to low
    Then User should verify decending order

    Examples: 
      | username                    | password | state       | city | roomType | checkin    | checkout   | no_room | no_adult | no_child |
      | ajinalexander1999@gmail.com | Appa@123 | Maharashtra | Pune | Standard | 2023-03-25 | 2023-03-27 | 1-One   | 2-Two    |        1 |

  Scenario Outline: Verifying room type filter is listed
    When User login the "<username>","<password>"
    Then User should verify success message after login "Welcome A. k. Ajin"
    When User enter all field "<state>","<city>","<roomType>","<checkin>","<checkout>","<no_room>","<no_adult>" and "<no_child>"
    Then User should verify success message after select hotel "Select Hotel"
    And User should verify hotel name ends with "<roomType>"

    Examples: 
      | username                    | password | state       | city | roomType | checkin    | checkout   | no_room | no_adult | no_child |
      | ajinalexander1999@gmail.com | Appa@123 | Maharashtra | Pune | Standard | 2023-03-25 | 2023-03-27 | 1-One   | 2-Two    |        1 |
