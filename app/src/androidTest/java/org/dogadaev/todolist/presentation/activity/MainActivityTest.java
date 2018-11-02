package org.dogadaev.todolist.presentation.activity;

import android.view.View;

import org.dogadaev.todolist.R;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    private MainActivity mainActivity = null;

    @Before
    public void setUp() throws Exception {
        mainActivity = mainActivityActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View view = mainActivity.findViewById(R.id.main_recycler);
        assertNotNull(view);
    }

    @Test
    public void testMainButton() {
        assertNotNull(mainActivity.findViewById(R.id.main_button));
        onView(withId(R.id.main_button)).perform(click());
    }

    @After
    public void tearDown() throws Exception {
        mainActivity = null;
    }
}