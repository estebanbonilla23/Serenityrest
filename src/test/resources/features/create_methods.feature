@post_api
Feature: Post Methods

  @create_post
  Scenario: create a post
    Given Thomas is a user
    When He sent the post method
    Then He can validate the post response
