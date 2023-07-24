@delete_api
Feature: Delete Methods

  @delete_post
  Scenario: delete a post
    Given Thomas is a user
    When He deletes a post
    Then He can validate the delete response
