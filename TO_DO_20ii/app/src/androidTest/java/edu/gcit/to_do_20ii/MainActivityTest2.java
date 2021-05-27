package edu.gcit.to_do_20ii;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import edu.gcit.to_do_20ii.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest2 {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest2() {
        ViewInteraction appCompatEditText = onView(
allOf(withId(R.id.editText_main),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
0),
isDisplayed()));
        appCompatEditText.perform(replaceText("17391134"), closeSoftKeyboard());
        
        ViewInteraction appCompatSpinner = onView(
allOf(withId(R.id.label_spinner),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        appCompatSpinner.perform(click());
        
        DataInteraction appCompatCheckedTextView = onData(anything())
.inAdapterView(childAtPosition(
withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
0))
.atPosition(0);
        appCompatCheckedTextView.perform(click());
        
        ViewInteraction appCompatSpinner2 = onView(
allOf(withId(R.id.label_spinner),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        appCompatSpinner2.perform(click());
        
        DataInteraction appCompatCheckedTextView2 = onData(anything())
.inAdapterView(childAtPosition(
withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
0))
.atPosition(2);
        appCompatCheckedTextView2.perform(click());
        
        ViewInteraction editText = onView(
allOf(withId(R.id.editText_main), withText("17391134"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()));
        editText.check(matches(withText("17391134")));
        
        ViewInteraction textView = onView(
allOf(withId(android.R.id.text1), withText("Mobile"),
withParent(allOf(withId(R.id.label_spinner),
withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
isDisplayed()));
        textView.check(matches(withText("Mobile")));
        
        ViewInteraction textView2 = onView(
allOf(withId(R.id.text_phonelabel), withText("17391134 - Mobile"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()));
        textView2.check(matches(withText("17391134 - Mobile")));
        }
    
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup)parent).getChildAt(position));
            }
        };
    }
    }
