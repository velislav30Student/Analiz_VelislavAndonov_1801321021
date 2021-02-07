package uni.pu.fmi;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature", plugin = {"pretty", "html:target/cucumberReports"}, monochrome = true)
public class CucumberStarter {

}
