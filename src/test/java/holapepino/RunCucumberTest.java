package holapepino;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/holapepino"},
        plugin = {
                "json:target/cucumber/wikipedia.json",
                "html:target/cucumber/wikipedia.html",
                "pretty"
        },
        tags = {"not @tag"}
)


public class RunCucumberTest{
}
