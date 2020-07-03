package pl.tamides.tamides913

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService
import pl.tamides.tamides913.databinding.ActivityMainBinding
import pl.tamides.tamides913.observers.NotNullValueObserver

class MainActivity : AppCompatActivity() {
    val viewModel: MainViewModel by viewModels()
    lateinit var views: ActivityMainBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityMainBinding.inflate(layoutInflater)
        setContentView(views.root)

        SQLiteStudioService.instance().start(this)

//        views.browser.settings.javaScriptEnabled = true
//        views.browser.settings.builtInZoomControls = true
//        views.browser.settings.blockNetworkImage = true
//        views.browser.webViewClient = WebClient().apply {
//            onPageFinishedAction = { browser: WebView?, url: String? ->
//                browser?.evaluateJavascript(Scripts.logInScript) { html ->
////                    var aaa = Jsoup.parse(html.replace("\\u003C", "<").replace("&quot;", "\"").replace("\n", " "))
////                    var aaa = Jsoup.parse(html.replace("\\u003C", "<"))
////                    var a = html
//                }
//            }
//        }
//
//        views.browser.loadUrl("https://www.lordswm.com/")

        val steps = 10
        for (i: Int in 0 until steps) {
            Log.d("moje", "asdas   $i")
        }

        viewModel.loadingProgressLiveData.observe(this, NotNullValueObserver { progress ->
            if (progress < 100) {
                showLoadingProgress(progress)
            } else {
                hideLoadingProgress()
            }
        })

        viewModel.start()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        val hdWidth = resources.getDimensionPixelSize(R.dimen.hd_width)
        val hdHeight = resources.getDimensionPixelSize(R.dimen.hd_height)

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            views.browser.layoutParams.width = hdHeight
            views.browser.layoutParams.height = hdWidth
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            views.browser.layoutParams.width = hdWidth
            views.browser.layoutParams.height = hdHeight
        }
    }

    fun showLoadingProgress(progress: Int) {
        if (views.loadingProgress.visibility == View.INVISIBLE) {
            views.loadingProgressBackground.visibility = View.VISIBLE
            views.loadingProgress.visibility = View.VISIBLE
        }

        views.loadingProgress.progress = progress
        views.loadingProgress.text = "$progress %"
    }

    fun hideLoadingProgress() {
        views.loadingProgressBackground.visibility = View.INVISIBLE
        views.loadingProgress.visibility = View.INVISIBLE
    }
}