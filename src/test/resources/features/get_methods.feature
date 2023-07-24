@get_api
Feature: Get Methods

  @get_all_users
  Scenario: get all users
    Given Esteban is a user
    When He consults all the users
    Then He can validate the users response

  @get_all_posts
  Scenario: get all posts
    Given Thomas is a user
    When He consults all the posts
    Then He can validate the posts response
