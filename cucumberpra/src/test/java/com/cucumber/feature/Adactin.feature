Feature: Adactin Hotel Automation

Scenario: To Verify valid Login Details
Given User Launch the Hotel Application
When User Enter The "yuvaraniarun" in UserName Field
And User Enter The "1258iou" in Password Field
And User click the Login button


Scenario Outline: To verify q2,q3,q4Whether The check-Out date field accepts a later date then check-in date
When User select the Location to book hotel
And User Select the Hotel to book
And User Select the Room Type to book
And User Select the Number of Rooms to book
And User Select the "<Check-in date>" Check-in to book
And User Select the "<Check-out date>" Check-out to book
And User Select the number of Adults
And User Select the number of children
And User Search the hotel to book
Then User verify the error message Check-in date should not be later than check-out  date

Examples:
|Check-in date|Check-out date|
|20/01/2020   |15/01/2020    |
|20/02/2020   |22/02/2020    |

Scenario: verify the Location same as above given location
Then User Verify the Location Displayed is same as hotel search form 
Then User verify the number of days booked is same as hotel search form
Then User Verify the number of rooms booked is same as hotel search form
Then User Verify the Room Type is same or nor
Then User Verify the Total Price is same or not









