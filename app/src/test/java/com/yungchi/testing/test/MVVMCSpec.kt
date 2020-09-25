package com.yungchi.testing.test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.yungchi.testing.test.MVVMCSpec.viewModel
import com.yungchi.testing.viewmodel.LoginActivityViewModel
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.mockito.InjectMocks
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

/**
 * Created by i9400514 on 2020/07/22.
 */
object MVVMCSpec : Spek({
    describe("MVVMC sample") {
//        val context: Context = ApplicationProvider.getApplicationContext()

//        var mEventTypeList = Mockito.spy(MutableLiveData<List<EventTypeSpinModel>>())
//        var eventTypePosition = Mockito.spy(MutableLiveData<Int>())
//        val viewModel: LoginActivityViewModel = Mockito.spy(LoginActivityViewModel::class.java)

//        val viewModel by memoized { LoginActivityViewModel() }

        context("unit test MVVMC") {
            beforeEachTest {
//                Mockito.`when`(viewModel.mEventTypeList.value).thenReturn(listOf<EventTypeSpinModel>(
//                    EventTypeSpinModel(
//                        "11",
//                        "11",
//                        "11",
//                        "11"
//                    ), EventTypeSpinModel(
//                        "22",
//                        "22",
//                        "22",
//                        "22"
//                    )
//                ))
            }
            it("檢核EVENT清單") {
                //TODO observeForever有問題
//                viewModel.mEventTypeList.observeForever(Observer { data ->
//                    assertEquals("11", data[0])
//                })

                viewModel.mEventTypeList.binding(false) { data ->
                    var temp = data?.get(0)
                    assertEquals("11", temp?.CLS_CODE)
                    assertEquals("11",  temp?.CLS_NM)
                }
                viewModel.initEventTypeList()
            }

        }
    }
}) {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

//    @Mock
//    lateinit var mEventTypeList: MutableLiveData<List<EventTypeSpinModel>>

    @InjectMocks
    lateinit var viewModel: LoginActivityViewModel

    init {
        MockitoAnnotations.initMocks(this)
    }
}

inline fun <reified T> lambdaMock(): T = mock(T::class.java)