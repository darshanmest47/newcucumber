package Testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "E:\\ec5\\newcucu\\src\\test\\resources\\features",
		glue = {"stepdefs","Apphooks"},
		monochrome = true,
		dryRun = false,
				plugin = {"pretty",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"timeline:test-output-thread/"

						
				}
		
		)

public class Testrunner {

}
