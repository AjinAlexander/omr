@ExploreHotel
Feature: Verifying OMR Branch Explore hotel page Automation

  Background: 
    Given User is on the Omr Branch hotel page

  Scenario Outline: Verifying Omr Branch Explore hotel page with all options
    When User login the "<username>","<password>"
    Then User should verify success message after login "Welcome A. k. Ajin"
    When User enter all field "<state>","<city>","<roomType>","<checkin>","<checkout>","<no_room>","<no_adult>" and "<no_child>"
    Then User should verify success message after select hotel "Select Hotel"

    Examples: 
      | username                    | password | state       | city | roomType | checkin    | checkout   | no_room | no_adult | no_child |
      | ajinalexander1999@gmail.com | Appa@123 | Maharashtra | Pune | Standard | 2023-04-25 | 2023-04-27 | 1-One   | 2-Two    |        1 |

  Scenario Outline: Verifying Omr Branch Explore hotel page with mandatory options
    When User login the "<username>","<password>"
    Then User should verify success message after login "Welcome A. k. Ajin"
    When User enter mandatory field "<state>","<city>","<checkin>","<checkout>","<no_room>" and "<no_adult>"
    Then User should verify success message after select hotel "Select Hotel"

    Examples: 
      | username                    | password | state       | city | checkin    | checkout   | no_room | no_adult |
      | ajinalexander1999@gmail.com | Appa@123 | Maharashtra | Pune | 2023-04-25 | 2023-04-27 | 1-One   | 2-Two    |

  Scenario Outline: Verifying Omr Branch Explore hotel page without any field
    When User login the "<username>","<password>"
    Then User should verify success message after login "Welcome A. k. Ajin"
    When User clicks search button
    Then User should verify error message after no options select "Please select state" , "Please select city" , "Please select Check-in date" , "Please select Check-out date" ,"Please select no. of rooms" and "Please select no. of adults"

    Examples: 
      | username                    | password |
      | ajinalexander1999@gmail.com | Appa@123 |

  Scenario Outline: Verifying Omr Branch Explore hotel page multiple  room type
    When User login the "<username>","<password>"
    Then User should verify success message after login "Welcome A. k. Ajin"
    When User enter all field "<state>","<city>","<roomType>","<checkin>","<checkout>","<no_room>","<no_adult>" and "<no_child>"
    Then User should verify success message after select hotel "Select Hotel"
    And User should verify selected filter room type is displayed "<roomType>"

    Examples: 
      | username                    | password | state       | city | roomType              | checkin    | checkout   | no_room | no_adult | no_child |
      | ajinalexander1999@gmail.com | Appa@123 | Maharashtra | Pune | Standard/Deluxe/Suite | 2023-04-25 | 2023-04-27 | 1-One   | 2-Two    |        1 |
