package com.qa.PostmanOmdb;

import static org.hamcrest.Matchers.equalTo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class OmdbTestSteps {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
    private static final LogStatus LogStatus = null;
	WebDriver driver;
    private static ExtentReports  reports = new ExtentReports(Constants.report, true);
    public ExtentTest test;

    @Before
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
    }

    @After
    public void teardown()
    {
//        driver.quit();
        reports.endTest(test);
        reports.flush();
    }
    
    @Given("^a film exists with the Title Guardians of the Galaxy Two$")
    public void a_film_exists_with_the_Title_Guardians_of_the_Galaxy_Two() {
    	
//    	driver.get(Constants.web);
    	test=reports.startTest("Omdb Test Report");
    	test.log(LogStatus.INFO,"Browser Started");
    	
    	
    	request =  given().contentType(ContentType.JSON);
    	   	
    	if (  given().contentType(ContentType.JSON)
    	   	    .when()
       	        .get("http://www.omdbapi.com/?apikey=e78cd603&t='Guardians of the Galaxy'")
       	    .then().body("Title", equalTo("Guardians of the Galaxy")) !=null) {
        	test.log(LogStatus.PASS, "a film exists named Guardians of the Galaxy");
        }
        else {
        	test.log(LogStatus.FAIL, " film does not exists named Guardians of the Galaxy");
        }
    	
    }

    @When("^a user retrieves the film by the title Guardians of the Galaxy Two$")
    public void a_user_retrieves_the_film_by_the_title_Guardians_of_the_Galaxy_Two()  {
    response = request.when().get("http://www.omdbapi.com/?apikey=e78cd603&t='Guardians of the Galaxy'");
       
    }

    @Then("^the status code reads (\\d+)$")
    public void the_status_code_reads(int arg1) {
        json = response.then().statusCode(arg1);
    }

    
    @Given("^a film exists with the Title IT$")
    public void a_film_exists_with_the_Title_IT() 
    {
    	test=reports.startTest("Omdb Test Report");
    	request =  given().contentType(ContentType.JSON);
	   	
//    	if (  given().contentType(ContentType.JSON)
//    	   	    .when()
//       	        .get("http://www.omdbapi.com/?apikey=e78cd603&t=IT&Y=2017")
//       	    .then().statusCode(200).body("Title", equalTo("It")) !=null) {
//        	test.log(LogStatus.PASS, "a film exists named It");
//        }
//        else {
//        	test.log(LogStatus.FAIL, "a film does not exists named It");
//        }
//    	System.out.println( given().contentType(ContentType.JSON)
//    	   	    .when()
//       	        .get("http://www.omdbapi.com/?apikey=e78cd603&t=IT&Y=2017").body().prettyPrint());
    	if (  given().contentType(ContentType.JSON)
    	   	    .when()
       	        .get("http://www.omdbapi.com/?apikey=e78cd603&t=IT&Y=2017")
       	    .then().body("Title", equalTo("It")) !=null) {
    		System.out.println("success");
    		
            test.log(LogStatus.PASS, "a film exists named It");
        }
        else {
        	System.out.println("not");
            test.log(LogStatus.FAIL, " film does not exists named It");
        }
    	
    
    }

    @When("^a user retrieves the film by the title IT$")
    public void a_user_retrieves_the_film_by_the_title_IT()  {
    	response = request.when().get("http://www.omdbapi.com/?apikey=e78cd603&t=IT&Y=2017");
    }

    @Then("^the Rated Field is equal to R$")
    public void the_Rated_Field_is_equal_to_R() {
    	json = response.then().body("Rated", equalTo("R"));
    }

    @Given("^a film exists with the Title \"([^\"]*)\"$")
    public void a_film_exists_with_the_Title(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^a user retrieves the film by the title \"([^\"]*)\"$")
    public void a_user_retrieves_the_film_by_the_title(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the Rated Field is equal to \"([^\"]*)\"$")
    public void the_Rated_Field_is_equal_to(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


}
