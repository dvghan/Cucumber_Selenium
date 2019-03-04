package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import java.io.File;
import org.junit.AfterClass;
import com.cucumber.listener.ExtentCucumberFormatter;
import com.cucumber.listener.Reporter;

/*

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
		glue= {"seleniumgluecode"},
		plugin = {  "pretty", "json:target/cucumber-reports/Cucumber.json",
					"junit:target/cucumber-reports/Cucumber.xml",
					"html:target/cucumber-reports"},
 		monochrome = true
)

public class testrunner {

}
*/

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
		glue= {"seleniumgluecode"},
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"
				, "json:target/cucumber-reports/Cucumber.json"
				, "junit:target/cucumber-reports/Cucumber.xml"				
		}, 
		monochrome = true
)

public class testrunner {
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("config/report.xml"));
    }
}

