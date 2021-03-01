package starter.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Steps;
import org.jruby.RubyProcess;
import starter.status.ApplicationStatus;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static starter.WebServiceEndPoints.STATUS;
import static starter.status.AppStatus.RUNNING;

public class ApplicationStatusStepDefinitions {

    @Steps
    ApplicationStatus theApplication;

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
        int statusCode= RestAssured.get(STATUS.getUrl()).statusCode();
        System.out.println("Check:" + statusCode);
    }
    @After
    public void endTheAct() {
        System.out.println("Test");
    }

}
