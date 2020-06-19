package pl.tamides.tamides913

import android.webkit.WebView
import android.webkit.WebViewClient

class WebClient : WebViewClient() {
    var onPageFinishedAction: ((view: WebView?, url: String?) -> Unit)? = null

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        onPageFinishedAction?.invoke(view, url)
    }
}