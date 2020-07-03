package pl.tamides.tamides913.observers

import androidx.lifecycle.Observer

class NotNullValueObserver<T>(private val observer: (T) -> Unit) : Observer<T?> {
    override fun onChanged(t: T?) {
        if (t == null) {
            return
        }

        observer.invoke(t)
    }
}