package com.adhiambo.themilkyway.utils

import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers

fun ViewInteraction.checkIfVisible(): ViewInteraction {
    return check(
        ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))
    )
}

fun ViewInteraction.checkIfNotVisible(): ViewInteraction {
    return check(
        ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE))
    )
}

fun ViewInteraction.checkIfTextMatches(text: String?): ViewInteraction {
    return check(ViewAssertions.matches(ViewMatchers.withText(text)))
}