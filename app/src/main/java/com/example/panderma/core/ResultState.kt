package com.example.panderma.core

sealed class ResultState<out T: Any> {
    data class Success<out T: Any>(val data: T): ResultState<T>()
    data class Error<T : Any>(val throwable: Throwable): ResultState<T>()
    class Idle<T: Any>: ResultState<T>()
    class ShowLoading<T: Any>: ResultState<T>()
    class HideLoading<T: Any>: ResultState<T>()
}
