package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Shree\\Documents\\workspace-spring-tool-suite-4-4.24.0.RELEASE\\NaaptolPOM\\src\\test\\resources\\naaptol\\brands.feature", glue = {
		"stepDefinations" }, plugin = { "pretty", "html:target/cucumberReports" }, tags = "@tag1")
public class brands {

}
