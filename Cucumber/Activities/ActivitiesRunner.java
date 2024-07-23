package testRunners;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    //tags = "@activity1"
    //tags = "@activity2"
    //tags = "@activity3"
    //tags = "@activity4"
   // tags = "@activity5"
    
   // tags = "@SimpleAlert",
    plugin = {"pretty"},
    monochrome = true
    
    //Activity6 for Pretty Reports
    
    	/*	@RunWith(Cucumber.class)
    @CucumberOptions(
        features = "Features",
        glue = {"stepDefinitions"},
        tags = "@SimpleAlert",
        plugin = {"pretty"},
        monochrome = true
    )                         */
    
    
    // Activity6 for HTML reports
   /*@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@SimpleAlert",
    plugin = {"html: test-reports"},
    monochrome = true */
    
    //Activity6 for Jason reports
    /*@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@SimpleAlert",
    plugin = {"json: test-reports/json-report.json"},
    monochrome = true
) */
    
)
public class ActivitiesRunner {

}
