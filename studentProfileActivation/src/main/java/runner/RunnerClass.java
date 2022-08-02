package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="featureFile",
glue={"stepDefinition", "hooks"},
dryRun=false,
tags="@au",
plugin= {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "html:report/htmlreport", "json:report/jsonreport.json", "junit:report/junitreport"},
monochrome=true)

public class RunnerClass extends AbstractTestNGCucumberTests{

}
