package com.yungchi.testing.test

import junit.framework.TestCase.assertEquals
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

/**
 * Created by i9400514 on 2020/07/22.
 */
object Spec : Spek({
    describe("A set") {
        // mock creation
        val mockedList: List<String> = Mockito.mock(MutableList::class.java) as MutableList<String>
        `when`(mockedList[0]).thenReturn("one")

        val set by memoized { mutableSetOf<String>() }

        context("is empty") {
            beforeEachTest {
                set.add("item")
            }

            it("mockedList[0] should have one string") {
                println("mockedList ${mockedList}")
                println("mockedList[0] ${mockedList[0]}")
                println("mockedList[1] ${mockedList[1]}")
                assertEquals(mockedList[0], "one")
                assertEquals(mockedList[1], null)
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