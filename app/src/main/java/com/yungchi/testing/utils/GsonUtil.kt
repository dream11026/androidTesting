package com.yungchi.testing.utils

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GsonUtil {
    companion object {

        val gson: Gson by lazy {
            Gson()
        }

        /**
         * 將List<Map<String, String>>轉型成List<T>資料
         *
         * @param list List<Map<String, String>>
         * @return rtnList T
         */
        inline fun <reified T> listToBean(list: List<Map<String, String>>): T {
            var type = genericType<T>()
            return gson.fromJson(gson.toJson(list), type)
        }

        /**
         * 將Any轉型成T資料
         *
         * @param data: Any
         * @return rtnData T
         */
        inline fun <reified T> anyToBean(data: Any): T {
            var type = genericType<T>()
            return gson.fromJson(gson.toJson(data), type)
        }

        /**
         * 將List<Map<String, String>>轉型成MutableLiveData<T>資料
         *
         * @param list List<Map<String, String>>
         * @return rtnList MutableLiveData<T>
         */
        inline fun <reified T> listToMutableLiveDataBean(list: List<Map<String, String>>): MutableLiveData<T> {
            val data: T = listToBean(list)
            return MutableLiveData<T>().apply { postValue(data) }
        }

        /**
         * 將Any轉型成MutableLiveData<T>資料
         *
         * @param data: Any
         * @return rtnData MutableLiveData<T>
         */
        inline fun <reified T> anyToMutableLiveDataBean(data: Any): MutableLiveData<T> {
            val data: T = anyToBean(data)
            return MutableLiveData<T>().apply { postValue(data) }
        }

        inline fun <reified T> genericType() = object : TypeToken<T>() {}.type
    }

}
