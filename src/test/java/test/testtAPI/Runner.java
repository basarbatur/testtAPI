package test.testtAPI;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\Basar\\eclipse-workspace\\testtAPI\\src\\test\\resources\\api.feature"   //without file name it executes all tests
		,glue="test.testtAPI"
		,dryRun=false
		,monochrome=true
		//,tags= {"denemegoogle"} //groups we want to run;
		,plugin = {"json:build/cucumber-reports/cucumber.json"}
		)
		


public class Runner {

}
