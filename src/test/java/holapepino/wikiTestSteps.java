package holapepino;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class wikiTestSteps {

    private WebDriver driver;

    @Before
    public void before() throws MalformedURLException {
        //driver.close();
    }

    @Given("Enter search term {string}")
    public void enterSearchTerm(String searchTerm) {
        driver = new FirefoxDriver();
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        WebElement searchField = driver.findElement(By.id("searchInput"));
        searchField.sendKeys(searchTerm);
    }

    @When("Do search")
    public void doSearch() {
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        searchButton.click();
    }

    @Then("Single result is shown for {string}")
    public void singleResultIsShownFor(String searchResult) {
        WebElement results = driver.findElement(By.cssSelector("div#mw-content-text.mw-content-ltr > div.mw-parser-output p"));
        assertFalse(results.getText().contains(searchResult + " may refer to: "));
        assertTrue(results.getText().startsWith(searchResult));
    }

    @Given("Open http:\\/\\/en.wikipedia.org")
    public void openHttpEnWikipediaOrg() {
        
    }

    @And("Do login")
    public void doLogin() {
    }
        /*@After
    public void after(){
        driver.quit();
    }*/
}
