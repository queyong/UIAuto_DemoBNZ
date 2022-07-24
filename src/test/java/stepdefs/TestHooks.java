
package stepdefs;

import com.auto.framework.base.DriverContext;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestHooks {
    @Before
    public void initializeTest(){
        // Code to setup initial configurations
    }

    @After
    public void closeTest(Scenario scenario){
        // Code to teardown initial configurations
        System.out.println(String.format("Test::%s,%s",scenario.getName(),scenario.getStatus()));
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                System.out.println("scenario failed!!");
                // Code to capture and embed images in test reports (if scenario fails)
                String screenshotName = scenario.getName().replaceAll(" ", "_");
                String currentTime = new SimpleDateFormat("-yyyyMMdd_HHmmss").format(new Date());

                File scrFile = ((TakesScreenshot) DriverContext.getDriver()).getScreenshotAs(OutputType.FILE);
                //Building up the destination path for the screenshot to save
                File destinationPath = new File(System.getProperty("user.dir") + "/src/test/report/cucumber-reports/screenshots/" + screenshotName + currentTime + ".png");
                //Copy taken screenshot from source location to destination location
                Files.copy(scrFile, destinationPath);

                //This attach the specified screenshot to the test
                Reporter.addScreenCaptureFromPath(destinationPath.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}