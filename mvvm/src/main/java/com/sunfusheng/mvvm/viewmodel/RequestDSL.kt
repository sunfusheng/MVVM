package com.sunfusheng.mvvm.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author sunfusheng
 * @since 2020/2/29
 */
class RequestDSL<Response> {
  internal var onStart: (() -> Unit)? = null
  internal lateinit var onRequest: suspend () -> Response
  internal var onResponse: ((Response) -> Unit)? = null
  internal var onError: ((Exception) -> Unit)? = null
  internal var onFinally: (() -> Unit)? = null

  infix fun onStart(block: (() -> Unit)?) {
    this.onStart = block
  }

  infix fun onRequest(block: suspend () -> Response) {
    this.onRequest = block
  }

  infix fun onResponse(block: ((Response) -> Unit)?) {
    this.onResponse = block
  }

  infix fun onError(block: ((Exception) -> Unit)?) {
    this.onError = block
  }

  infix fun onFinally(block: (() -> Unit)?) {
    this.onFinally = block
  }

  internal fun launch(viewModelScope: CoroutineScope) {
    viewModelScope.launch(Dispatchers.Main) {
      onStart?.invoke()
      try {
        val response = withContext(Dispatchers.IO) {
          onRequest()
        }
        onResponse?.invoke(response)
      } catch (e: Exception) {
        e.printStackTrace()
        onError?.invoke(e)
      } finally {
        onFinally?.invoke()
      }
    }
  }
}