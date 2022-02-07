package com.morningstar.l1_guess

import android.util.Log
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MeterialActivityTest {
    @Rule
    @JvmField
    //<這裡面填寫針對什麼事情做一rule>, 鎖定在MaterialActivity, 透過@JvmField 定義成一個java 屬性
    val activityTestRule =ActivityTestRule<MaterialActivity>(MaterialActivity::class.java)
    val TAG = MeterialActivityTest::class.java.simpleName
    @Test
    fun guessWrong(){
        val resources = activityTestRule.activity.resources
        val secret = activityTestRule.activity.secretnumber.secret // 直指到變數
        val n =5
        for(n in 1..10) {
            if (n != secret) {
                //perform() 代表的是針對view的動作
                onView(withId(R.id.ed_number)).perform(clearText())
                onView(withId(R.id.ed_number)).perform(typeText(n.toString()))
                onView(withId(R.id.btn_ok)).perform(click())
                val message =
                    if (n < secret) resources.getString(R.string.bigger)
                    else
                        resources.getString(R.string.samll)
                Log.d(TAG, "guessWrong: message=" + message)
                onView(withText(message)).check(ViewAssertions.matches(isDisplayed()))
                onView(withText(resources.getString(R.string.ok))).perform(ViewActions.click())
            }
        }





    }
}