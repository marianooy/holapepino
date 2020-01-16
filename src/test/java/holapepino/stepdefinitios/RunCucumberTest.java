package holapepino.stepdefinitios;


//import com.cucumber.listener.Reporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
        import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/holapepino"},
        glue = {"holapepino.stepdefinitios"},
        plugin = {
                "holapepino.extentreport.PrettyReports:target/extent/prettyreport.html"
        }
)


public class RunCucumberTest {

}