package wiki_gluecode;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import com.cucumber.listener.ExtentCucumberFormatter;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/wiki-features",
		tags="@SimpleSearch, @ParamSearch",  format = {"pretty"},
		glue = {"wiki_gluecode"},
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/wiki-report.html"
				, "json:target/cucumber-reports/wiki-Cucumber.json"
				, "junit:target/cucumber-reports/wiki-Cucumber.xml"	
		} 
		, monochrome = true
)

public class RunWikipediaTest {
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("config/report.xml"));
    }
}
