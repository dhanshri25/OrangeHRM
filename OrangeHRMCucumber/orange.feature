Feature: Check for Login in Orange HRM site
Site is having good design 
and Add the skill named as 'Automation Testing'
Take Screenshot
Delete the skill 'Automation Testing'
Close browser

Scenario: Check for login and logout Functionality
Given Browser should open
When We should be in Login Page
When We enter Username and Password
Then User click login button
Then We should be in User's Admin
Then We should be in User's Qualification
Then Go to skill
Then Click on add button
When Add skill name
Then Click on save button
Then Take Screenshot
Then Delete Skill
Then Close browser