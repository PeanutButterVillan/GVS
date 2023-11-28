@UI
Feature: Visa checks

  Background:
    Given I am on the Check UK visa website
    And I start visa check

  Scenario: An Australian coming to the UK for Tourism.
    When I select a nationality of 'Australia'
    And I select reason 'Tourism'
    Then I will be informed 'You will not need a visa to come to the UK'

  Scenario: A Chilean coming to the UK for Work and plans on staying for longer than 6 months.
    When I select a nationality of 'Chile'
    And I select reason 'Work'
    And I state I am intending to stay for 'more' than 6 months
    And I select job type 'Health'
    Then I will be informed 'You need a visa to work in health and care'

  Scenario: A Colombian national coming to the UK to join a partner for a long stay. They do have an Article 10 or 20 card.
    When I select a nationality of 'Colombia'
    And I select reason 'Family'
    Then I will be informed as an Article 10 or 20 holder to apply for a free 'family permit'