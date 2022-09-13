package com.adhiambo.themilkyway

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.platform.app.InstrumentationRegistry
import com.adhiambo.themilkyway.utils.TestUiHelper
import com.adhiambo.themilkyway.utils.checkIfNotVisible
import com.adhiambo.themilkyway.utils.checkIfTextMatches
import com.adhiambo.themilkyway.utils.checkIfVisible
import com.adhiambo.themilkyway.screens.photo.PhotoListActivity
import com.adhiambo.themilkyway.utils.ApiTestConfigs.PORT
import org.junit.Test
import okhttp3.mockwebserver.MockWebServer


class PhotoListActivityTest {

    private val context = InstrumentationRegistry.getInstrumentation().context
    private val server = MockWebServer()

    @Test
    fun showProgressDialogOnScreenLaunch() {
        launch(PhotoListActivity::class.java)

        TestUiHelper.getViewWithId(R.id.photo_list_progressbar).checkIfVisible()
    }

    @Test
    fun showAppNameInActionBarOnScreenLaunch() {
        launch(PhotoListActivity::class.java)

        TestUiHelper.getViewWithText(R.string.app_name).checkIfVisible()
    }

    @Test
    fun showErrorTextWhenErrorOccursOnDataFetch() {
        launch(PhotoListActivity::class.java)
        server.start(PORT)
        server.shutdown()

        TestUiHelper.getViewWithId(R.id.photo_list_error_text).checkIfVisible()
        TestUiHelper.getViewWithId(R.id.photo_list_error_text)
            .checkIfTextMatches(context.getString(R.string.error_failed_to_load_photos))
    }

    @Test
    fun hideProgressBarWhenAnErrorOccursDuringDataFetch() {
        launch(PhotoListActivity::class.java)
        server.start(PORT)
        server.shutdown()

        TestUiHelper.getViewWithId(R.id.photo_list_progressbar).checkIfNotVisible()
    }

    @Test
    fun hideProgressBarWhenDataIsLoaded() {
        launch(PhotoListActivity::class.java)
        //TODO mock server response and assert progressbar is hidden

        TestUiHelper.getViewWithId(R.id.photo_list_progressbar).checkIfNotVisible()
    }

    @Test
    fun showListOfPhotosIfDataIsFetchedSuccessfully(){
        server.start(PORT)
        //TODO mock server response and assert photo, title, center and date are displayed
    }
}