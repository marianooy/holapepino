package holapepino;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sun.java2d.DisposerTarget;

import static org.junit.Assert.*;
class IsItFriday {
    static String isItFriday(String today){
        return "Friday".equals(today) ? "Awiwi" : "Nope";
    }
}
class myCollections {

}

public class Stepdefs {
    private class anotherCollection{

    }
    private String today;
    private String actualAnswer;

    @Given("today is {string}")
    public void today_is(String today) {
        this.today = today;
    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }
    @Given("This is a blank test")
    public void this_is_a_blank_test() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

}
