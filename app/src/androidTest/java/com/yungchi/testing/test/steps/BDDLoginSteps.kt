package com.yungchi.testing.test.steps

import android.app.Activity
import android.util.Log
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.yungchi.testing.BuildConfig
import com.yungchi.testing.MainActivity
import com.yungchi.testing.R
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.junit.Assert

class BDDLoginSteps {
    var rule: ActivityTestRule<*> =
        ActivityTestRule(MainActivity::class.java, false, false)
    //    private Context context = ApplicationProvider.getApplicationContext();
    //    @Mock
    //    Context mockContext;
    /**
     * We launch the activity in Cucumber's [Before] hook.
     * See the notes above for the reasons why we are doing this.
     *
     * @throws Exception any possible Exception
     */
    @Before
    @Throws(Exception::class)
    fun launchActivity() {
        rule.launchActivity(null)
    }

    /**
     * All the clean up of application's data and state after each scenario must happen here
     */
    @After
    @Throws(Exception::class)
    fun finishActivity() {
        activity.finish()
    }

    /**
     * Gets the activity from our test rule.
     *
     * @return the activity
     */
    private val activity: Activity
        get() = rule.activity

    @Given("I start the application")
    fun iStartTheApplication() {
    }

    @When("I enter valid account {string}")
    fun iEnterValidAccount(account: String) {
        onView(withId(R.id.et_account))
            .perform(typeText(account), closeSoftKeyboard())
    }

    @And("I enter valid password {int}")
    fun iEnterValidPasswordPassword(password: Int) {
        onView(withId(R.id.et_password))
            .perform(typeText(password.toString()), closeSoftKeyboard())
    }

    @Then("I click login button")
    fun iClickLoginButton() {
        onView(withId(R.id.btn_login)).perform(click())
    }

    @Then("I expect to see successful login message")
    fun iExpectToSeeSuccessfulLoginMessage() {
        println("ui test iExpectToSeeSuccessfulLoginMessage")
        Log.d("ui test", "iExpectToSeeSuccessfulLoginMessage")

        onView(withId(R.id.tv_hint))
            .check(matches(withText("login success")))

        when (BuildConfig.HOST) {
            "release" -> {
                Assert.assertEquals("release", BuildConfig.HOST)
            }
            "stage" -> {
                Assert.assertEquals("stage", BuildConfig.HOST)
            }
            "debug" -> {
                Assert.assertEquals("debug", BuildConfig.HOST)
            }
        }
    }
}