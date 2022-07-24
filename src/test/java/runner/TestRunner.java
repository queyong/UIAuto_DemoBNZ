package runner;

import com.auto.framework.base.DriverContext;
import com.auto.framework.config.Setting;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefs"},
        tags = {"@Demo"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:src/test/report/cucumber-reports/extent_report.html"},
        monochrome = true
        )

public class TestRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
//        System.out.println("test class start!!");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
        System.out.println("name::"+cucumberFeature.getCucumberFeature().getPath());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
//        System.out.println("test class end!!");
        DriverContext.quit();
        testNGCucumberRunner.finish();
    }

    @AfterClass(alwaysRun = true)
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(Setting.reportConfigPath));
    }

}