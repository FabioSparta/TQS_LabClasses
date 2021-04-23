Feature: Buy a ticket for a plane trip
  Scenario: Verify redirection and page title after selecting origin and destination
    When I navigate to "https://blazedemo.com/"
    And I select "Portland" as origin
    And I select "Dublin" as destination
    And click on Find Flights
    Then Im redirected to "https://blazedemo.com/reserve.php"
    And the page's title is "Flights from Portland to Dublin:"

