package com.example.androidjokeslib;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.util.Log;

import com.example.javajokeslib.JavaJokes;
import com.udacity.gradle.builditbigger.*;
import com.udacity.gradle.builditbigger.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest extends AndroidTestCase{
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkResponse() {
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        try {
            endpointsAsyncTask.execute(mainActivityActivityTestRule.getActivity().getApplicationContext());
            onView(withId(R.id.button_tell_joke)).perform(click());
            onView(withId(R.id.textView)).check(matches(withText(JavaJokes.getJoke())));
        } catch (Exception e) {
            Log.i("AsyncTest", e.getMessage(), e);
        }
    }
}
