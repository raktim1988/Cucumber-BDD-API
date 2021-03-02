package starter.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;
import starter.status.ApplicationStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static starter.WebServiceEndPoints.STATUS;
import static starter.status.AppStatus.RUNNING;

/* Author: Raktim Biswas
* Step Definition Class */

public class ApplicationStatusStepDefinitions {

    @Steps
    ApplicationStatus theApplication;

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
            }
    @Given("the application is running")
    public void the_application_is_running() {
        assertThat(theApplication.currentStatus()).isEqualTo(RUNNING);
    }

    @When("I check the application status")
    public void i_check_the_application_status() {
        theApplication.readStatusMessage();
    }

    @Then("the API response should return {string}")
    public void the_api_response_should_return(String responseString) {
        Integer statusCode= RestAssured.get(STATUS.getUrl()).statusCode();
        assertThat(statusCode.toString().equals(responseString));
            }
    @Then("the API response should not return {string}")
    public void the_api_response_should_not_return(String checkString) {
        Integer statusCode= RestAssured.get(STATUS.getUrl()).statusCode();
        assertThat(!statusCode.toString().equals(checkString));
    }
}
