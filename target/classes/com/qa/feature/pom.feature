Feature: FreeCrm Application testing

Scenario: Landing Page Test

Given user in landing page
When title is Free Crm 
Then validate current url
Then validate the login button
Then validate the sign up button
Then click on login button
Then closes the browser

Scenario: Login page test

Given user in login page
Then user enters email and password
Then user is in homepage
Then verify username
Then close the browser


Scenario: Create contact test

Given user in homepage
Then click on contact link
Then click on add contact 
Then enters firstname and lastname

|firstname|lastname|
|ramakrishna|kuruva|

Then click on save button
Then close the browser