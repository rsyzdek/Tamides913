package pl.tamides.tamides913

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.tamides.tamides913.observers.AutoResetLiveData

class MainViewModel : ViewModel() {
    val loadingProgressLiveData: AutoResetLiveData<Int?> = AutoResetLiveData(null)

    fun start() {
        viewModelScope.launch(Dispatchers.IO) {
            var progress = 0
            loadingProgressLiveData.postValue(progress)

            var i = 1
            while (progress < 100) {
                progress = 10 * i
                i += 2
                loadingProgressLiveData.postValue(progress)
                Thread.sleep(1000)
            }
        }
    }
}