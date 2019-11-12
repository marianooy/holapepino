# new feature
# Tags: optional

Feature: Search Wikipedia
  Background: testing wiki search input
    Given Open http://en.wikipedia.org
    And Do login
  @WebTestMarin
  Scenario Outline: Direct search article
    Given Enter search term "<searchTerm>"
    When Do search
    Then Single result is shown for "<result>"

    Examples:
    |searchTerm|result               |
    |mercury   |Mercury usually refers to:|
    |max       |Max or MAX may refer to:    |
