package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;

@CucumberOptions(strict = true, plugin = { "json:target/cucumber-report.json",
        "html:target/cucumber-report" }, tags = "@smokeTest", features = "src/test/resources/cucumber/mail_base.feature", glue = {
        "com.epam.byta.frameworks.demo.steps" })

public class RunnerClass extends AbstractTestNGCucumberTests {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();

        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("SeleniumHW");
        List<String> files = new ArrayList<>(new ArrayList<>() {
            {
                add("testng.xml");
            }
        });
        xmlSuite.setSuiteFiles(files);

        List<XmlSuite> suites = new ArrayList<>();
        suites.add(xmlSuite);
        testNG.setXmlSuites(suites);
        testNG.run();
    }
}
