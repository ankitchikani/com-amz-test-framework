package demotour;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationStepdefs {

    public static WebDriver driver;

    @Given("^User is on homepage$")
    public void userIsOnHomepage() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/");
        driver.manage().window().maximize();
        //*Random randomG = new Random();
        //int randomInt = randomG.nextInt(100);
        //String assertText = driver.findElement(By.name("userName")).getAttribute("value"); //Fetch actual text
        //System.out.println(assertText);
    }

    @When("^User click on Register button and Registration page will open$")
    public void userClickOnRegisterButtonAndRegistrationPageWillOpen() throws Throwable {
        driver.findElement(By.linkText("REGISTER")).click();
    }

    @When("^User enter First neme \"([^\"]*)\"$")
    public void userEnterFirstNeme(String arg0) throws Throwable {
        driver.findElement(By.name("firstName")).sendKeys(arg0);
    }

    @And("^User enter Last Name \"([^\"]*)\"$")
    public void userEnterLastName(String arg0) throws Throwable {
        driver.findElement(By.name("lastName")).sendKeys(arg0);

    }

    @And("^User enter Phone Number \"([^\"]*)\"$")
    public void userEnterPhoneNumber(String arg0) throws Throwable {
        driver.findElement(By.name("phone")).sendKeys(arg0);

    }

    @And("^User enter Email \"([^\"]*)\"$")
    public void userEnterEmail(String arg0) throws Throwable {
        driver.findElement(By.id("userName")).sendKeys(arg0);
    }

    @And("^User enter Address (\\d+)st Line \"([^\"]*)\"$")
    public void userEnterAddressStLine(int arg0, String arg1) throws Throwable {
        driver.findElement(By.name("address1")).sendKeys(arg1);

    }

    @And("^User enter City \"([^\"]*)\"$")
    public void userEnterCity(String arg0) throws Throwable {
        driver.findElement(By.name("city")).sendKeys(arg0);
    }

    @And("^User enter State/Province \"([^\"]*)\"$")
    public void userEnterStateProvince(String arg0) throws Throwable {
        driver.findElement(By.name("state")).sendKeys(arg0);


    }

    @And("^User enter Postal code \"([^\"]*)\"$")
    public void userEnterPostalCode(String arg0) throws Throwable {
        driver.findElement(By.name("postalCode")).sendKeys(arg0);
    }

    @And("^User enter Country \"([^\"]*)\"$")
    public void userEnterCountry(String arg0) throws Throwable {
        new Select(driver.findElement(By.name("country"))).selectByVisibleText(arg0);
    }

    @And("^User enter User Name \"([^\"]*)\"$")
    public void userEnterUserName(String arg0) throws Throwable {
        driver.findElement(By.name("email")).sendKeys(arg0);

    }

    @And("^User enter Password \"([^\"]*)\"$")
    public void userEnterPassword(String arg0) throws Throwable {
        driver.findElement(By.name("password")).sendKeys(arg0);
    }

    @And("^User enter Confirm Password \"([^\"]*)\"$")
    public void userEnterConfirmPassword(String arg0) throws Throwable {
        driver.findElement(By.name("confirmPassword")).sendKeys(arg0);
    }

    @And("^User click on SUBMIT button$")
    public void userClickOnSUBMITButton() throws Throwable {
        driver.findElement(By.name("register")).click();
    }

    @Then("^User redirect to Register Page$")
    public void userRedirectToRegisterPage() throws Throwable {
        String Page = driver.getCurrentUrl();
        System.out.println("CurrentPage: " + Page);
        assert (Page.contains("http://newtours.demoaut.com/create_account_success.php"));

    }

    @And("^User can See Message \"([^\"]*)\"$")
    public void userCanSeeMessage(String arg0) throws Throwable {
        String Note = driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
        System.out.println(Note);
        assert (Note.contains(arg0));
    }


    @When("^User is click on SIGN-ON link$")
    public void userIsClickOnSIGNONLink() throws Throwable {
        driver.findElement(By.linkText("sign-in")).click();
        String CurrentUrl = driver.getCurrentUrl();
        assert (CurrentUrl.contains("http://newtours.demoaut.com/mercurysignon.php"));
    }

    @And("^User enter valid \"([^\"]*)\"$")
    public void userEnterValid(String arg0) throws Throwable {
        driver.findElement(By.name("userName")).sendKeys(arg0);
    }

    @And("^enter valid \"([^\"]*)\"$")
    public void enterValid(String arg0) throws Throwable {
        driver.findElement(By.name("password")).sendKeys(arg0);
    }

    @Then("^User can successfully Sign In$")
    public void userCanSuccessfullySignIn() throws Throwable {
        driver.findElement(By.name("login")).click();
    }

    @When("^User click on Flights$")
    public void userClickOnFlights() throws Throwable {
        driver.findElement(By.linkText("Flights")).click();
    }

    @And("^User select journeytype \"([^\"]*)\"$")
    public void userSelectJourneytype(String arg0) throws Throwable {
        List<WebElement> type = driver.findElements(By.name("tripType"));
        for (WebElement element : type) {
            if (element.getAttribute("value").equalsIgnoreCase(arg0)) {
                element.click();
                break;
            }
        }
    }

    @And("^User Select passenger \"([^\"]*)\"$")
    public void userSelectPassenger(String arg0) throws Throwable {
        new Select(driver.findElement(By.name("passCount"))).selectByValue(arg0);

    }

    @And("^User select departingfrom \"([^\"]*)\"$")
    public void userSelectDepartingfrom(String arg0) throws Throwable {
        new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText(arg0);
    }

    @And("^User Select Arriving to \"([^\"]*)\"$")
    public void userSelectArrivingTo(String arg0) throws Throwable {
        new Select(driver.findElement(By.name("toPort"))).selectByVisibleText(arg0);
    }

    @And("^User Select Service class \"([^\"]*)\"$")
    public void userSelectServiceClass(String arg0) throws Throwable {
        List<WebElement> type = driver.findElements(By.name("servClass"));
        for (WebElement element : type) {
            if (element.getAttribute("value").equalsIgnoreCase(arg0)) {
                element.click();
                if (arg0 == "Economy class") {
                    element.getAttribute("value").contains("Coach");
                    element.click();
                }
                break;
            }
        }

    }

    @And("^click on continue$")
    public void clickOnContinue() throws Throwable {
        driver.findElement(By.name("findFlights")).click();
    }




    @And("^User select Airline Preference \"([^\"]*)\"$")
    public void userSelectAirlinePreference(String arg0) throws Throwable {
        new Select(driver.findElement(By.name("airline"))).selectByVisibleText(arg0);
    }


    @When("^user select the prefered Depart Airline\"([^\"]*)\"$")
    public void userSelectThePreferedDepartAirline(String arg0) throws Throwable {
        List<WebElement> selection = driver.findElements(By.name("outFlight"));
        for (WebElement element : selection) {
            if (element.getAttribute("value").startsWith(arg0)) {
                element.click();
                break;
            }
        }
    }

    @And("^User select the prefered Return Airline\"([^\"]*)\"$")
    public void userSelectThePreferedReturnAirline(String arg0) throws Throwable {
        List<WebElement> selection = driver.findElements(By.name("inFlight"));
        for (WebElement element : selection) {
            if (element.getAttribute("value").startsWith(arg0)) {
                element.click();
                break;
            }
        }
    }

    @And("^User click to continue$")
    public void userClickToContinue() throws Throwable {
        driver.findElement(By.name("reserveFlights")).click();
    }

    @Then("^User can see expected outbound Airline \"([^\"]*)\"$")
    public void userCanSeeExpectedOutboundAirline(String arg0) throws Throwable {
       String Actual= driver.findElement(By.xpath(".//table/tbody/tr[3]/td[1]/font/b")).getText();
        System.out.println("Outbound Airline name: "+Actual);
        assert(Actual.contains(arg0));
    }

    @And("^User can also see expected Return Airline \"([^\"]*)\"$")
    public void userCanAlsoSeeExpectedReturnAirline(String arg0) throws Throwable {
        /*String Actual= driver.findElement(By.cssSelector(".data_left>font>font>font>b")).getText();
        System.out.println("Return airline name: "+Actual);
        assert(Actual.contains(arg0));*/
    }


    @And("^User can confirm Number of Passenger \"([^\"]*)\" on page$")
    public void userCanConfirmNumberOfPassengerOnPage(String arg0) throws Throwable {
       /*String Actual= driver.findElement(By.xpath(".//table/tbody/tr[7]/td[2]/font")).getText();
       System.out.println("Passenger no.: "+Actual);
       assert (Actual.contains(arg0));*/
    }

    @And("^User can see total Prices \"([^\"]*)\"$")
    public void userCanSeeTotalPrices(String arg0) throws Throwable {
       /* String Actual= driver.findElement(By.xpath(".//table/tbody/tr[9]/td[2]/font/b")).getText();
        System.out.println("Total Price: "+Actual);
        assert (Actual.contains(arg0));*/

    }

    @When("^User want to pay and Select Card type \"([^\"]*)\"$")
    public void userWantToPayAndSelectCardType(String arg0) throws Throwable {
        driver.findElement(By.name("creditCard")).click();
        new Select(driver.findElement(By.name("creditCard"))).selectByVisibleText(arg0);
    }

    @And("^enter Creditcard number \"([^\"]*)\"$")
    public void enterCreditcardNumber(String arg0) throws Throwable {
        driver.findElement(By.name("creditnumber")).sendKeys(arg0);
    }

    @And("^Enter Expiry date \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enterExpiryDateAnd (String arg0, String arg1) throws Throwable {
      driver.findElement(By.name("cc_exp_dt_mn")).click();
      new Select(driver.findElement(By.name("cc_exp_dt_mn"))).selectByVisibleText(arg0);
      driver.findElement(By.name("cc_exp_dt_yr")).click();
      new Select(driver.findElement(By.name("cc_exp_dt_yr"))).selectByVisibleText(arg1);
    }

    @And("^Click on Secure Purchase$")
    public void clickOnSecurePurchase() throws Throwable {
        driver.findElement(By.name("buyFlights")).click();
    }

    @Then("^User can see Flight confirmation detail$")
    public void userCanSeeFlightConfirmationDetail() throws Throwable {

    }

    @And("^User can varify OutBound Airline \"([^\"]*)\"$")
    public void userCanVarifyOutBoundAirline(String arg0) throws Throwable {

    }

    @And("^User can varify Return airline \"([^\"]*)\"$")
    public void userCanVarifyReturnAirline(String arg0) throws Throwable {

    }

    @And("^User can varify Passenger Number \"([^\"]*)\"$")
    public void userCanVarifyPassengerNumber(String arg0) throws Throwable {

    }

    @And("^Flight Confirmation Number$")
    public void flightConfirmationNumber() throws Throwable {

    }

    @And("^User can Varify Total Prices \"([^\"]*)\"$")
    public void userCanVarifyTotalPrices(String arg0) throws Throwable {

    }
}
