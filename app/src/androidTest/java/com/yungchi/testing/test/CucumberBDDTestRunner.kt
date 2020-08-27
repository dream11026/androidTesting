package com.yungchi.testing.test

import android.os.Bundle
import com.yungchi.testing.BuildConfig
import cucumber.api.CucumberOptions
import cucumber.api.SnippetType
import cucumber.api.android.CucumberAndroidJUnitRunner

@CucumberOptions(
    features = ["features"]
    , plugin = ["pretty"]
    , monochrome = true // console output from Cucumber in a readable format
    , snippets = SnippetType.CAMELCASE // SnippetType.CAMELCASE | SnippetType.UNDERSCORE
)
class CucumberBDDTestRunner : CucumberAndroidJUnitRunner() {
    override fun onCreate(bundle: Bundle) {
        val tags = BuildConfig.TEST_TAGS
        if ("" != tags) {
            bundle.putString(CUCUMBER_TAGS_KEY, tags)
        }
        var scenario = BuildConfig.TEST_SCENARIO
        if ("" != scenario) {
            scenario = scenario.replace(" ".toRegex(), "\\\\s")
            bundle.putString(CUCUMBER_SCENARIO_KEY, scenario)
        }

        super.onCreate(bundle)
    }

    companion object {
        private val TAG: String = CucumberBDDTestRunner::class.java.simpleName
        private const val CUCUMBER_TAGS_KEY = "tags"
        private const val CUCUMBER_SCENARIO_KEY = "name"
    }
}