@Login
Feature: Verifying Omr Branch hotel login Automation

  Background: 
    Given User is on the Omr Branch hotel page

  Scenario Outline: Verifying Omr Branch login with valid data
    When User login the "<username>","<password>"
    Then User should verify success message after login "Welcome A. k. Ajin"

    Examples: 
      | username                    | password |
      | ajinalexander1999@gmail.com | Appa@123 |

  Scenario Outline: Verifying login with valid credential with ENTER key
    When User login the "<username>","<password>" with ENTER key
    Then User should verify success message after login "Welcome A. k. Ajin"

    Examples: 
      | username                    | password |
      | ajinalexander1999@gmail.com | Appa@123 |

  Scenario Outline: Verifying login with invalid credential
    When User login the "<username>","<password>"
    Then User should verify error message after login "Invalid Login details or Your Password might have expired. "

    Examples: 
      | username                    | password |
      | ajinalexander1999@gmail.com | ajin@123 |
