package com.yungchi.testing.test

import android.os.Bundle
import android.util.Log
import com.yungchi.testing.BuildConfig
import cucumber.api.CucumberOptions
import cucumber.api.SnippetType
import cucumber.api.android.CucumberAndroidJUnitRunner
import java.io.File

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

//        grantPermission()

        bundle.putString(
            "plugin", getPluginConfigurationString()
        ); // we programmatically create the plugin configuration
        super.onCreate(bundle)
    }

//    private fun grantPermission() {
//        val permissions: ArrayList<String> = ArrayList()
//        permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE)
//        permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
//
//        val command = java.lang.String.format(
//            "pm grant %s ",
//            targetContext.packageName
//        )
//        //add here your other permissions
//        for (i in 0 until permissions.size) {
//            val commandPermissions = command + permissions[i]
//            getInstrumentation().uiAutomation.executeShellCommand(commandPermissions)
//            // wait a bit until the command is finished
//            SystemClock.sleep(1000)
//        }
//    }

    /**
     * Since we want to checkout the external storage directory programmatically, we create the plugin configuration
     * here, instead of the [CucumberOptions] annotation.
     *
     * @return the plugin string for the configuration, which contains XML, HTML and JSON paths
     */
    private fun getPluginConfigurationString(): String? {
        val cucumber = "cucumber"
        val separator = "--"
        var reportDir = getAbsoluteFilesPath()
        Log.d(TAG, "getAbsoluteFilesPath $reportDir")
        return "pretty" +
                separator + "html:" + reportDir+ "/" + cucumber + ".html" +
                separator + "junit:" + reportDir + "/" + cucumber + ".xml" +
                separator + "json:" + reportDir + "/" + cucumber + ".json"
    }

    /**
     * The path which is used for the report files.
     *
     * @return the absolute path for the report files
     */
    private fun getAbsoluteFilesPath(): String {
        ///storage/emulated/0/Android/data/[packageName]/reports
        val directory: File? = targetContext.getExternalFilesDir(null)
//        val directory: File? = Environment.getExternalStoragePublicDirectory(null)
        return File(directory, "reports").getAbsolutePath()
    }

    companion object {
        private val TAG: String = CucumberBDDTestRunner::class.java.simpleName
        private const val CUCUMBER_TAGS_KEY = "tags"
        private const val CUCUMBER_SCENARIO_KEY = "name"
    }
}