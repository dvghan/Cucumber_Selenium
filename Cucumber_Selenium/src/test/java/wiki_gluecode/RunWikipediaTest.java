package wiki_gluecode;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import com.cucumber.listener.ExtentCucumberFormatter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Cucumber_Selenium.Cucumber_Selenium.Student;
import Cucumber_Selenium.Cucumber_Selenium.StudyGroup;
import org.junit.Assert;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/wiki-features",
		//tags="@SimpleSearch, @ParamSearch",  format = {"pretty"},
		tags="@SimpleSearch",  format = {"pretty"},
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

		final List<Student> testStudents = new ArrayList<Student>();
		
		testStudents.add(new Student(1, "Student No.1", 60));
		testStudents.add(new Student(2, "Student No.2", 70));
		testStudents.add(new Student(3, "Student No.2", 80));
		
		// Start the unit test
		final StudyGroup testGroup = new StudyGroup();
		for(Student student: testStudents) {
			testGroup.addStudent(student);
		}
		Assert.assertEquals(testGroup.getGroupSize(), testStudents.size());   

		Student testStudent = testStudents.get(0);
		Student returnedStudent = testGroup.getStudent(testStudent.getId());
		Assert.assertSame(returnedStudent, testStudent);
		Assert.assertEquals(returnedStudent.getId(), testStudent.getId());
		Assert.assertEquals(returnedStudent.getName(), testStudent.getName());
		Assert.assertEquals(returnedStudent.getScore(), testStudent.getScore());
		
		testGroup.removeStudent(testStudent.getId());
		Assert.assertEquals(testGroup.getGroupSize(), testStudents.size() - 1);
		
		testGroup.clear();
		Assert.assertEquals(testGroup.getGroupSize(), 0);		

    }
}
