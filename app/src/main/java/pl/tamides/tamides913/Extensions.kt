package pl.tamides.tamides913

import android.content.Context
import android.content.Context.WINDOW_SERVICE
import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.room.Room
import pl.tamides.tamides913.database.AppDatabase

fun getScreenWidth(context: Context): Int {
    val displayMetrics = DisplayMetrics()
    val windowManager = context.getSystemService(WINDOW_SERVICE) as WindowManager
    windowManager.defaultDisplay.getMetrics(displayMetrics)
    return displayMetrics.widthPixels
}

fun db() = Room.databaseBuilder(
        App.appContext,
        AppDatabase::class.java, "Tamides913Database"
).build()