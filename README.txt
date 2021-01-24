"Blaze Demo Flight Booking" Web site is automated in "Data Driven Framework" with Page Object Model as Design Pattern in a Java Maven Project. 
Also TestNG is used for Reporting and scripts are automated in Chrome Browser. Framework consists of two Suites. 
One for testing End to End Flow for booking ticket by reading Data from Excel. 
And another is for testing SmokeSuite after each build or every day.

How to Run The Project:
1. Place the chromedriver.exe in the path "C:/bin" 
2. Navigate to testng.xml
3. Navigate to Line No: 7 and update value of name attribute to "E2E" (for running E2E Suite) or "smoke" (for running Smoke suite).
4. Add another line if both of the suite need to be tested by specifying value of name attribute as E2E or smoke.
5. Save the File. Right Click testng.xml and select "Run As->TestNG Suite".

Maven Dependencies:
Dependencies for following Libraries are added in pom.xml and details as follows:
1. Selenium - Java
2. TestNG
3. Apache POI

Page Objects:
Details about Page Objects created in framework as follows:
1. Home Page.
2. Reserve Page.
3. Purchase Page.
4. Confirmation Page.

Test Scripts Automated:

--> E2E Scenario
--> Scenarios to be tested as part of Smoke Test as follows:

1. From Dropdown should have the expected cities.
2. To Dropdown should have the expected cities.
3. Search Results page should have 5 Fields "Choose, Flight #, Airline, Depart: <Source>, Arrives: <Destination>, Price".
4. Purchase page should have Text Fields "Name, Address, City, State, Zip Code, Card Type, Credit Card Number, Month, Year, Name on Card".
5. Purchase page should have inlineText for "Name, Address, City, State, Zip Code, Card Type, Name on Card".
6. Purchase page should have Default values for "Card Type, Month and Year".

All the above scenarios are ideal candidates for Automation.

But Scenario "1 to 4" are automated for the following reasons:
-> Scenario 1 & 2: All the city names need to be present in From and To Dropdown. 
   Absence of City in From and To Dropdown might lead the End customer to use a different booking website resulting in loss of revenue for "Blaze Demo"

-> Scenario 3: Search Results page should have all the required Headers. Absence of header might make end user difficult to understand the search results.
-> Scenario 4: Purchase page should be populated with the mandatory field associated to Passenger Details and Credit Card Transaction.
   Absence of field associated with Credit Card will cause a revenue loss as the customer might prefer another travel portal.          
