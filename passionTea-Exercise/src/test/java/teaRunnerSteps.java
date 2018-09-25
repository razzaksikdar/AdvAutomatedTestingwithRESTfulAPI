import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import cucumber.api.java.gl.E;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertEquals;

public class teaRunnerSteps
{

    WebDriver driver;
    private static ExtentReports  report = new ExtentReports(Constants.path_teaReport, true);
    public ExtentTest test;

    @Before
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void teardown()
    {
        driver.quit();
        report.endTest(test);
        report.flush();
    }

    @Given("^the correct web address$")
    public void the_correct_web_address()
    {
        //user = "Lauren"
        //pass = "password"
        driver.get(Constants.path_teaWebsite);
        test = report.startTest("PassionTea Website Test Reports");
        test.log(LogStatus.INFO, "Browser Started");

        if(driver.getCurrentUrl().equals(Constants.path_teaWebsite))
        {
            test.log(LogStatus.PASS, "Webpage accessed correctly");
        }
        else
        {
            test.log(LogStatus.FAIL, "Test Failed!");
        }

        assertEquals(driver.getCurrentUrl(), Constants.path_teaWebsite);
    }

    @When("^I navigate to the 'Menu' page$")
    public void i_navigate_to_the_Menu_page()
    {
//        WebElement menu = driver.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a"));
//  		menu.click();

        menupage menupg = PageFactory.initElements(driver, menupage.class);
        menupg.menuclick();

        assertEquals(driver.getCurrentUrl(), "http://www.practiceselenium.com/menu.html");
        test.log(LogStatus.INFO, "Menu page accessed correctly");
        test.log(LogStatus.PASS, "Successfully navigated to Main Menu page");
    }

    @Then("^I can browse a list of the available products\\.$")
    public void i_can_browse_a_list_of_the_available_products()
    {
        test.log(LogStatus.PASS, "Product Available to User");

        assertEquals("Green Tea", driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong")).getText());
        assertEquals("Red Tea", driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231072\"]/div/p/span/span/strong")).getText());
        assertEquals("Oolong Tea", driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231735\"]/div/p/span/span/strong")).getText());

        try
        {
            Thread.sleep(750);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    @When("^I click the checkout button$")
        public void i_click_the_checkout_button()
    {
//        WebElement menu = driver.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a"));
//		menu.click();
//		WebElement checkout = driver.findElement(By.xpath("//*[@id=\"wsb-button-00000000-0000-0000-0000-000451955160\"]/span"));
//		checkout.click();

        menupage menupg = PageFactory.initElements(driver, menupage.class);
        menupg.menuclick();

        checkoutPage checkoutPg = PageFactory.initElements(driver, checkoutPage.class);
        checkoutPg.checkoutclick();

        test.log(LogStatus.PASS, "Successfully navigated to Checkout page");
        assertEquals(driver.getCurrentUrl(), Constants.path_teaCheckout);
    }

    @Then("^I am taken to the checkout page$")
    public void i_am_taken_to_the_checkout_page()
    {
        if(driver.getCurrentUrl().equals(Constants.path_teaCheckout))
        {
            test.log(LogStatus.PASS, "Checkout page Available to User");
        }
        else
        {
            test.log(LogStatus.FAIL, "Test Failed!");
        }

        assertEquals(driver.getCurrentUrl(), Constants.path_teaCheckout);
    }
}
