package Code_Assignment_TestPackage.Runners.runners;


import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/Features/",
        dryRun=false,
        monochrome=true, //clear output
        tags= "@CodeAssignment",
        plugin= {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//                "json:target/jsonReports/cucumber-reports.json","html:target/cucumber-ui-reports.html",
                "rerun:target/failedrerun.txt"
        }
//sanity and regression tags= {"@sanity,@regression"}-sanity or regression

)
public class TestRunner {


}


