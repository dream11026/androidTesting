package com.yungchi.testing.test.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

/**
 * Created by i9400514 on 2020/08/18.
 */
public class UITest {
    @Given("I start the page")
    public void iStartThePage() {
    }

    @When("I enter valid text {string}")
    public void iEnterValidText(String arg0) {
    }

    @Then("I expect to see text")
    public void iExpectToSeeText() {
        assertEquals(1, 1);
    }
}
