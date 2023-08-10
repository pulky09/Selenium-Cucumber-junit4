package tests.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.HomePage;
import org.example.LoginPage;
import org.openqa.selenium.WebDriver;
import tests.hooks.CucumberHooks;
import static org.junit.Assert.*;


public class LoginSteps {

        private LoginPage loginPage;
        private final CucumberHooks hooks;

        public LoginSteps(CucumberHooks hooks){
                this.hooks = hooks;
        }


        @Given("I want to navigate to the home page")
        public void i_want_to_navigate_to_the_home_page(){
                HomePage homePage = new HomePage(hooks.getDriver());
                homePage.navigateTo();
                loginPage = homePage.clickSignInLink();
        }

        @Given("I want to login using my {string} and {string}")
        public void iWantToLoginUsingMyAnd(String userName, String password) {
              loginPage.login(userName,password);
        }

        @Then("I should be on the customer login page")
        public void iShouldBeOnTheCustomerLoginPage() {
                assertEquals("Home Page",hooks.getDriver().getTitle());
        }


}

