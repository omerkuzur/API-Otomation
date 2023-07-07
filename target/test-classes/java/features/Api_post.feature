Feature: API test

  Scenario: check body

    Given create request url
    And create body
    And preparation of expected data
    And compare response
    Then assertion processing