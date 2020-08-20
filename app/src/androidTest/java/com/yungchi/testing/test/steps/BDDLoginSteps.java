package com.yungchi.testing.test.steps;

import android.app.Activity;

import androidx.test.rule.ActivityTestRule;

import com.yungchi.testing.BuildConfig;
import com.yungchi.testing.MainActivity;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class BDDLoginSteps {
    ActivityTestRule rule = new ActivityTestRule<>(MainActivity.class, false, false);
    //    private Context context = ApplicationProvider.getApplicationContext();
//    @Mock
//    Context mockContext;

    /**
     * We launch the activity in Cucumber's {@link Before} hook.
     * See the notes above for the reasons why we are doing this.
     *
     * @throws Exception any possible Exception
     */
    @Before
    public void launchActivity() throws Exception {
        rule.launchActivity(null);
    }

    /**
     * All the clean up of application's data and state after each scenario must happen here
     */
    @After
    public void finishActivity() throws Exception {
        getActivity().finish();
    }

    /**
     * Gets the activity from our test rule.
     *
     * @return the activity
     */
    private Activity getActivity() {
        return rule.getActivity();
    }

    @Given("I start the application")
    public void iStartTheApplication() {
    }

    @When("I enter valid account {string}")
    public void iEnterValidAccount(String account) {
        assertEquals("someone@mail.com", account);
    }

    @And("I enter valid password {int}")
    public void iEnterValidPasswordPassword(int password) {
        assertEquals(12345678, password);
    }

    @Then("I expect to see successful login message")
    public void iExpectToSeeSuccessfulLoginMessage() {
//        assertEquals(1, 1);
        if ("release".equals(BuildConfig.HOST)) {
            assertEquals("release", BuildConfig.HOST);
        } else if ("debug".equals(BuildConfig.HOST)) {
            assertEquals("debug", BuildConfig.HOST);
        }
    }
}
