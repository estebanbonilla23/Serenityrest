@patch_api
Feature: Patch Methods

  @patch_post
  Scenario: patch a post
    Given Thomas is a user
    When He updates partially a post
    Then He can validate the patch response
