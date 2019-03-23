#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#@ParamSearch
Feature: Parameterised Wikipedia Search
  Verify if user is able to search Wikipedia

  Scenario Outline: direct search for good article
    Given Enter search term '<searchTerm>'
    When Do search
    Then Multiple results are shown for '<result>'

    Examples:
      | searchTerm | result                     					|
      | Alphanso   | Mercury usually refers to: 					|
      | Amitabh    | Amitabh or Amitabha may refer to:  	|