package com.adhiambo.themilkyway.utils

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.CoreMatchers

object TestUiHelper {
    fun getViewWithId(
        @IdRes resId: Int,
        @IdRes containingViewId: Int? = null
    ): ViewInteraction {
        val viewMatchers = mutableListOf(ViewMatchers.withId(resId)).also { matchers ->
            containingViewId?.let {
                matchers.add(ViewMatchers.isDescendantOfA(ViewMatchers.withId(containingViewId)))
            }
        }

        return Espresso.onView(CoreMatchers.allOf(viewMatchers))
    }

    fun getViewWithText(@IdRes resId: Int): ViewInteraction {
        return Espresso.onView(ViewMatchers.withText(resId))
    }

    fun getViewWithText(text: String): ViewInteraction {
        return Espresso.onView(ViewMatchers.withText(text))
    }
}