package holapepino;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONObject;
/*import sun.java2d.DisposerTarget;*/

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

    Integer user_id;
    String name;
    Integer Token;

    public  int getUserId(){
        JSONObject ob = new JsonData().data();
        user_id = ob.getInt("user_id");
        return user_id;
    }
    public String getUserName(){
        JSONObject ob = new JsonData().data();
        name = ob.getString("name");
        return name;
    }
    public  int getUserToken(){
        JSONObject ob = new JsonData().data();
        Token = ob.getInt("toen");
        return Token;
    }



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
        assertEquals(name, getUserName());
    }

    @When("get {int} as user id")
    public void get_as_user_id(Integer user_id) {
        assertEquals((int)(user_id), getUserId());
    }

    @Then("token should be {int} number")
    public void token_should_be_number(Integer token) {
        assertEquals((int)(token), getUserToken());
    }

}
