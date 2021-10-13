package cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/featureFiles"},
        glue = {"cucumber/stepdef"},
        plugin = {"pretty", "json:target/cucumber-report.json"}
)
public class StudentsRunner {

}
