package tapanhpandya.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="D:\\BDDFrameworkProjects\\FirstBDDProject\\src\\main\\java\\tapanhpandya\\Features\\purchase.feature",
		glue="tapanhpandya.stepDefinitions",
		plugin= {"pretty","html:test-output.html"},
		monochrome = true,
		dryRun = false
		)

public class TestRunner {

}
