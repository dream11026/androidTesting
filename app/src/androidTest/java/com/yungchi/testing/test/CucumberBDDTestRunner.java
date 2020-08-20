package com.yungchi.testing.test;

import android.os.Bundle;

import com.yungchi.testing.BuildConfig;

import cucumber.api.CucumberOptions;
import cucumber.api.android.CucumberAndroidJUnitRunner;

@CucumberOptions(features = "features"
        , plugin = {"pretty"}
        , monochrome = true // console output from Cucumber in a readable format
        , strict = true
//        ,snippets = CAMELCASE // CAMELCASE | UNDERSCORE
)
@SuppressWarnings("unused")
public class CucumberBDDTestRunner extends CucumberAndroidJUnitRunner {
    private static final String CUCUMBER_TAGS_KEY = "tags";
    private static final String CUCUMBER_SCENARIO_KEY = "name";

    @Override
    public void onCreate(final Bundle bundle) {

        String tags = com.yungchi.testing.BuildConfig.TEST_TAGS;

        if (!"".equals(tags)) {
            bundle.putString(CUCUMBER_TAGS_KEY, tags);
        }

        String scenario = BuildConfig.TEST_SCENARIO;
        if (!"".equals(scenario)) {
            scenario = scenario.replaceAll(" ", "\\\\s");
            bundle.putString(CUCUMBER_SCENARIO_KEY, scenario);
        }
        super.onCreate(bundle);
    }
}
