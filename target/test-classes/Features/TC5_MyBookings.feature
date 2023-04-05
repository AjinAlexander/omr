@MyBookings
Feature: Verifying OMR Branch My Bookings Page hotel page Automation

  Background: 
    Given User is on the Omr Branch hotel page

  Scenario Outline: Verifying cancel the order
    When User login the "<username>","<password>"
    Then User should verify success message after login "Welcome A. k. Ajin"
    When User enter all field "<state>","<city>","<roomType>","<checkin>","<checkout>","<no_room>","<no_adult>" and "<no_child>"
    Then User should verify success message after select hotel "Select Hotel"
    When User select the hotel
    And User accept the alert
    Then User should verify success message after book hotel "Book Hotel" and save the hotel name
    When user add guest details "<selectSaluation>","<firstName>","<lastName>","<mobileNo>" and "<email>"
    And User add GST details "<registrationNo>","<companyName>" and "<companyAddress>"
    And User add special request "<specialRequest>"
    And User add payment details,proceed with card type "<cardType>"
      | selectCard | cardNo           | cardName       | cardMonth | cardYear | cvvNo |
      | Visa       | 5555555555552222 | Ajin Alexander | January   |     2025 |   123 |
      | Amex       | 5555555555552222 | Dinesh         | June      |     2024 |   658 |
      | Mastercard | 5555555555552222 | Manoj          | July      |     2026 |   984 |
      | Discover   | 5555555555552222 | Sriram         | August    |     2027 |   574 |
    Then User should verify success message after book hotel "Booking is Confirmed" and save the order id
    When User navigate into my booking tabs
    Then User should verify the booked hotel is present
    When User cancel the order id
    Then User should verify success message after my bookings page "Your booking cancelled successfully"

    Examples: 
      | username                    | password | state       | city | roomType | checkin    | checkout   | no_room | no_adult | no_child | selectSaluation | firstName | lastName  | mobileNo   | email                        | registrationNo | companyName            | companyAddress | specialRequest | cardType   |
      | ajinalexander1999@gmail.com | Appa@123 | Maharashtra | Pune | Standard | 2023-03-25 | 2023-03-27 | 1-One   | 2-Two    |        1 | Mr.             | Ajin      | Alexander | 9857469215 | ajinaleaxander1999@gmail.com |     9043592058 | Greens Tech OMR Branch | Thoraipakkam   | extra cot      | Debit Card |
