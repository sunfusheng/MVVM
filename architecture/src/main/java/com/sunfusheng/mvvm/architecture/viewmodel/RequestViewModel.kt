package com.sunfusheng.mvvm.architecture.viewmodel

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

/**
 * @author sunfusheng
 * @since 2020/2/29
 */
open class RequestViewModel : ViewModel() {
    companion object {
        const val JOB_TAG = "RequestViewModel.JOB_TAG"
    }

    private val mRequestStateMap by lazy { HashMap<String, MutableLiveData<RequestState<*>>>() }

    fun requestState(jobTag: String = JOB_TAG): MutableLiveData<RequestState<*>>? {
        return mRequestStateMap[jobTag]
    }

    @Synchronized
    private fun getRequestStateLiveData(jobTag: String = JOB_TAG): MutableLiveData<RequestState<*>> {
        var requestState = requestState(jobTag)
        if (requestState == null) {
            requestState = MutableLiveData()
            mRequestStateMap[jobTag] = requestState
        }
        return requestState
    }

    private fun <Response> requestInternal(apiDSL: RequestDSL<Response>.() -> Unit) {
        RequestDSL<Response>().apply(apiDSL).launch(viewModelScope)
    }

    protected fun <Response> request(
        jobTag: String = JOB_TAG,
        requestDSL: RequestDSL<Response>.() -> Unit
    ) {
        requestInternal<Response> {
            val invoker = RequestDSL<Response>().apply(requestDSL)
            val requestState = getRequestStateLiveData(jobTag)

            onStart {
                invoker.onStart?.invoke()
                requestState.value = OnStart<Response>()
            }
            onRequest {
                invoker.onRequest()
            }
            onResponse { response ->
                invoker.onResponse?.invoke(response)
                requestState.value = OnResponse(response)
            }
            onError { exception ->
                invoker.onError?.invoke(exception)
                requestState.value = OnError<Response>(exception)
            }
            onFinally {
                invoker.onFinally?.invoke()
                requestState.value = OnFinally<Response>()
            }
        }
    }

    protected fun <Response> requestLiveData(
        context: CoroutineContext = Dispatchers.Main,
        timeoutInMs: Long = 5000L,
        request: suspend () -> Response
    ): LiveData<RequestState<Response>> {
        return liveData(context, timeoutInMs) {
            emit(OnStart())
            try {
                emit(withContext(Dispatchers.IO) {
                    OnResponse(request())
                })
            } catch (e: Exception) {
                e.printStackTrace()
                emit(OnError<Response>(e))
            } finally {
                emit(OnFinally())
            }
        }
    }

    override fun onCleared() {
        mRequestStateMap.clear()
        super.onCleared()
    }
}

sealed class RequestState<T>
class OnStart<T> : RequestState<T>()
data class OnResponse<T>(val response: T) : RequestState<T>()
data class OnError<T>(val exception: Exception) : RequestState<T>()
class OnFinally<T> : RequestState<T>()