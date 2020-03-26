package com.sunfusheng.mvvm.architecture.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sunfusheng.mvvm.architecture.viewmodel.getViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel by lazy { getViewModel(MainViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.testCoroutine()
    }
}

class MainViewModel : ViewModel() {

    fun testCoroutine() {
        viewModelScope.launch(Dispatchers.Main) {
            delaySeconds(1)
        }
    }

    suspend fun delaySeconds(seconds: Int) {
        withContext(Dispatchers.IO) {
            val timeMillis: Long = if (seconds < 1) 1000L else seconds * 1000L
            delay(timeMillis)
        }
    }
}
