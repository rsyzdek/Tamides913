package pl.tamides.tamides913

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import pl.tamides.tamides913.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val viewModel: MainViewModel by viewModels()
    lateinit var views: ActivityMainBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityMainBinding.inflate(layoutInflater)
        setContentView(views.root)

        views.browser.settings.javaScriptEnabled = true
        views.browser.settings.builtInZoomControls = true
        views.browser.settings.blockNetworkImage = true
        views.browser.webViewClient = WebClient().apply {
            onPageFinishedAction = { browser: WebView?, url: String? ->
                browser?.evaluateJavascript(Scripts.logInScript) { html ->
//                    var aaa = Jsoup.parse(html.replace("\\u003C", "<").replace("&quot;", "\"").replace("\n", " "))
//                    var aaa = Jsoup.parse(html.replace("\\u003C", "<"))
//                    var a = html
                }
            }
        }

        views.browser.loadUrl("https://www.lordswm.com/")
    }
}