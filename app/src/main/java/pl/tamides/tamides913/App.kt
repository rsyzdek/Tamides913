package pl.tamides.tamides913

import android.app.Application
import android.content.Context

class App : Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        appContext = base ?: throw IllegalStateException("Application context is null")
    }

    companion object {
        lateinit var appContext: Context
    }
}