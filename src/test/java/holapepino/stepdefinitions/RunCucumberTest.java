package holapepino.stepdefinitions;


//import com.cucumber.listener.Reporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
        import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/holapepino"},
        glue = {"holapepino.stepdefinitions"},
        plugin = {
                "holapepino.extentreport.PrettyReports:target/extent/"
        }
)


public class RunCucumberTest {

}