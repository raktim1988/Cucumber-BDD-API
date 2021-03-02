# Getting started with REST API testing with Serenity and Cucumber 6

This POC assignment show you how to get started with REST-API testing using Serenity and Cucumber 6.

## Get the code

Git:

    git clone https://github.com/raktim1988/Cucumber-BDD-API.git

Sample Report : 

     https://reports.cucumber.io/reports/b3568bd6-4c71-45d2-be73-be7356bd17f8 

CI Pipeline through gitlab:

    

## A simple GET scenario
The project comes with two APIs

The first scenario captures the `/api/status` endpoint
The second scenario captures the neagtive scenario for the ` /api/status ` endpoint

Both variations of the sample project uses the sample Cucumber scenario.
In this scenario, Sergey (who likes to search for stuff) is performing a search on the DuckDuckGo search engine:

```Gherkin BDD
  Scenario: Application status end-point
    Given the application is running
    When I check the application status
    Then the API response should return "200"
```
used logback feature for logging