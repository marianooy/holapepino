package holapepino;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import holapepinouser.FakeUser;

/*import sun.java2d.DisposerTarget;*/

import static org.junit.Assert.*;
class IsItFriday {
    static String isItFriday(String today){
        return "Friday".equals(today) ? "Awiwi" : "Nope";
    }
}

public class Stepdefs {

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
    public String this_is_a_blank_test() {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();
        return "It´s fine from home change!";
    }
    @Given("user name is {string}")
    public void user_name_is(String name) {
        assertEquals(name, FakeUser.getUserName());
    }

    @When("get {int} as user id")
    public void get_as_user_id(Integer user_id) {
        assertEquals((int)(user_id), FakeUser.getUserId());
    }

    @Then("token should be {int} number")
    public void token_should_be_number(Integer token) {
        assertEquals((int)(token), FakeUser.getUserToken());
    }



}
