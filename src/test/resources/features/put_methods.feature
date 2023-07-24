@put_api
Feature: Put Methods

  @put_post
  Scenario: put a post
    Given Thomas is a user
    When He updates a post
    Then He can validate the put response
