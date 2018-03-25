Feature:End To End Testing
  Scenario Outline: User can enter Registration detail so User can login successfully

    Given User is on homepage
    When User click on Register button and Registration page will open
    When User enter First neme "<First Name>"
    And  User enter Last Name "<Last name>"
    And  User enter Phone Number "<Phone Number>"
    And  User enter Email "<Email>"
    And  User enter Address 1st Line "<Address 1st Line>"
    And  User enter City "<City>"
    And  User enter State/Province "<State or Province>"
    And  User enter Postal code "<Postal code>"
    And  User enter Country "<Country>"
    And  User enter User Name "<User Name>"
    And  User enter Password "<Password>"
    And  User enter Confirm Password "<Confirm Password>"
    And  User click on SUBMIT button
    Then User redirect to Register Page
    And User can See Message "<Message>"
    When User is click on SIGN-ON link
    And User enter valid "<User Name>"
    And enter valid "<Password>"
    Then User can successfully Sign In


    Examples:
      |First Name|Last name|Phone Number|Email              |Address 1st Line|City     |State or Province|Postal code|Country|User Name          |Password|Confirm Password|Message|
      |Ankit     |Chikani  |07825376697 |chikani@gmail.com  |Lanchbury Lane  |Ahmedabad|Gujarat          |380013     |INDIA  |chikani@gmail.com|abcd1234|abcd1234        | Note: Your user name is chikani@gmail.com.|

  Scenario Outline: Select the Journey Type


    When User click on Flights
    And  User select journeytype "<JourneyType>"
    And  User Select passenger "<Passenger>"
    And User select departingfrom "<DepartingFrom>"
    And  User Select Arriving to "<Arrivingfrom>"
    And User Select Service class "<ServiceClass>"
    And User select Airline Preference "<Preference>"
    And click on continue
    When user select the prefered Depart Airline"<Outbound Airline>"
    And  User select the prefered Return Airline"<Return-Airline>"
    And User click to continue
    Then User can see expected outbound Airline "<Outbound Airline>"
    And User can also see expected Return Airline "<Return-Airline>"
    And User can confirm Number of Passenger "<Passanger>" on page
    And User can see total Prices "<Flight-Price>"
    When User want to pay and Select Card type "<Card-type>"
    And enter Creditcard number "<Card-Number>"
    And Enter Expiry date "<Month>" and "<Year>"
    And Click on Secure Purchase
    Then User can see Flight confirmation detail
    And  User can varify OutBound Airline "<Outbound Airline>"
    And  User can varify Return airline "<Return-Airline>"
    And User can varify Passenger Number "<Passanger>"
    And Flight Confirmation Number
    And User can Varify Total Prices "<Flight-Price>"

    Examples:
      | JourneyType | Passenger | DepartingFrom | Arrivingfrom | ServiceClass  |Preference         |Outbound Airline       |Return-Airline         | Flight-Price | Card-type      | Card-Number    | Month| Year|
      | roundtrip   | 1         | London        | New York     | Economy class |Blue Skies Airlines|Blue Skies Airlines 360|Blue Skies Airlines 630| $584 USD     |American Express|2345678969982552|  05  |2001 |
      |  oneway     | 2         | Paris         | London       |Business       |No Preference      |Unified Airlines 363   |Blue Skies Airlines 631| $584 USD     |MasterCard      |3694568952364551|  06  |2004 |
      |  oneway     | 3         | Frankfurt     | New York     |First          |Unified Airlines   |Blue Skies Airlines 361|Pangea Airlines 632    | $584 USD     |Visa            |2552366314414567|  08  |2006 |
      |  roundtrip  | 4         | Paris         | London       |Business       |Pangea Airlines    |Pangea Airlines 362    |Unified Airlines 633   | $584 USD     |Diners Club     |7458789665587845|  09  |2008 |


