@Home
Feature: work around various features present on the homepage


 Scenario: User should be able to change the Pincode for delivery purpose
 Given the user is present on home page of amazon
 When the user click the change pincode button
 And the user enters a valid pincode <pincode> and submits
 Then the displayed pincode should get changed to <pincode>
 
 Examples:
    |pincode|
    |"143001"|
    |"400001"|
    |"175105"|
    