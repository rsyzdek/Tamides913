package pl.tamides.tamides913.observers

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class AutoResetLiveData<T>(value: T) : MutableLiveData<T>(value) {
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner, Observer {
            if (value != null) {
                observer.onChanged(it)
                value = null
            }
        })
    }
}