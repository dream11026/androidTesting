package com.yungchi.testing.test.steps

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.junit.Assert

/**
 * Created by i9400514 on 2020/08/18.
 */
class UITest {
    @Given("I start the page")
    fun iStartThePage() {
    }

    @When("I enter valid text {string}")
    fun iEnterValidText(arg0: String?) {
    }

    @Then("I expect to see text")
    fun iExpectToSeeText() {
        Assert.assertEquals(1, 1)
    }
}