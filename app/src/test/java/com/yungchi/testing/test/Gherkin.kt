package com.yungchi.testing.test

import junit.framework.TestCase.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

/**
 * Created by i9400514 on 2020/07/22.
 */
object Gherkin : Spek({
    Feature("Set") {
        val set by memoized { mutableSetOf<String>() }

        Scenario("getting the first item") {
            val item = "foo"
            Given("a non-empty set") {
                set.add(item)
            }

            lateinit var result: String

            When("getting the first item") {
                result = set.first()
            }

            //Error case
            Then("it should fail") {
                assertEquals(item, null)
            }

            Then("it should return the first item") {
                assertEquals(item, result)
            }

            Then("it should return the first item2") {
                assertEquals(item, result)
            }

        }
    }
})