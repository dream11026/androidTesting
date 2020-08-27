package com.yungchi.testing.test

import android.os.Bundle
import com.yungchi.testing.BuildConfig
import cucumber.api.CucumberOptions
import cucumber.api.SnippetType
import cucumber.api.android.CucumberAndroidJUnitRunner

@CucumberOptions(
    //features = ["features"] //change for onCreate
    plugin = ["pretty"]
    , monochrome = true // console output from Cucumber in a readable format
    , snippets = SnippetType.CAMELCASE // SnippetType.CAMELCASE | SnippetType.UNDERSCORE
)
class CucumberBDDTestRunner : CucumberAndroidJUnitRunner() {
    override fun onCreate(bundle: Bundle) {
        val tags = BuildConfig.TEST_TAGS
        if ("".isNotBlank()) {
            bundle.putString(CUCUMBER_TAGS_KEY, tags)
        }
        var scenario = BuildConfig.TEST_SCENARIO
        if (scenario.isNotBlank()) {
            scenario = scenario.replace(" ".toRegex(), "\\\\s")
            bundle.putString(CUCUMBER_SCENARIO_KEY, scenario)
        }

        var features = BuildConfig.TEST_FEATURES
        if (features.isNotBlank()) {
            features = "features/${features.toLowerCase()}"
            bundle.putString(CUCUMBER_FEATURES_KEY, features)
        } else {
            features = "features"
        }

        bundle.putString(CUCUMBER_FEATURES_KEY, features) // "features/"+ main
        super.onCreate(bundle)
    }

    companion object {
        private val TAG: String = CucumberBDDTestRunner::class.java.simpleName
        private const val CUCUMBER_TAGS_KEY = "tags"
        private const val CUCUMBER_FEATURES_KEY = "features"
        private const val CUCUMBER_SCENARIO_KEY = "name"
    }
}