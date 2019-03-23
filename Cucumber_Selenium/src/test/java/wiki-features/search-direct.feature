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
@SimpleSearch
Feature: Wikipedia Search
  Verify if user is able to search Wikipedia

  Scenario: direct search for good article
    Given Enter search term 'Freddie Mercury'
    When Do search
    Then Single result is shown for 'Freddie Mercury'
    And This is good article

#  Scenario: direct search for not good article
#    Given Enter search term 'Cucumber'
#    When Do search
#    Then Single result is shown for 'Cucumber'
#    And This is not good article

#@ParamSearch
#  Scenario Outline: Parameterised search for good article
#    Given Enter search term '<searchTerm>'
#    When Do search
#    Then Multiple results are shown for '<result>'

#    Examples:
#      | searchTerm | result                     |
#      | mercury    | Mercury usually refers to: |
#      | max        | Max or MAX may refer to:   |