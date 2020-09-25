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
    describe("檢查set") {
        // mock creation
        val mockedList: List<String> = Mockito.mock(MutableList::class.java) as MutableList<String>
        `when`(mockedList[0]).thenReturn("one")

        val set by memoized { mutableSetOf<String>() }

        context("is empty") {
            beforeEachTest {
                set.add("item")
            }

            it("清單項目驗證") {
                println("mockedList ${mockedList}")
                println("mockedList[0] ${mockedList[0]}")
                println("mockedList[1] ${mockedList[1]}")
                assertEquals(mockedList[0], "one")
                assertEquals(mockedList[1], null)
            }

            //Error case
            it("設置錯誤TEST CASE用") {
                assertEquals("", null)
            }

            it("檢查資料內容") {
                println("unit test when error Spec")
                assertEquals("item", set.first())
            }
        }
    }
})