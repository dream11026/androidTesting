package com.yungchi.testing.test

import junit.framework.TestCase.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

/**
 * Created by i9400514 on 2020/07/22.
 */
object Spec : Spek({
    describe("A set") {
        val set by memoized { mutableSetOf<String>() }

        context("is empty") {
            beforeEachTest {
                set.add("item")
            }

            //Error case
            it("should have a size > 0") {
//                assertTrue(set.size == 0)
                assertEquals("", null)
            }

            it("should contain item") {
                println("unit test when error Spec")
                assertEquals("item", set.first())
            }

            it("should contain item2") {
                assertEquals("item", set.first())
            }
        }
    }
})