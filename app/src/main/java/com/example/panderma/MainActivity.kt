package com.example.panderma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.panderma.presentation.home.HomeViewModel
import com.example.panderma.presentation.home.LatestNewsUiState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when(it) {
                        is LatestNewsUiState.Success -> {
                            Log.d("TAG", "result data is ${it.news}")
                        }
                        is LatestNewsUiState.Error -> {
                            Log.d("TAG", "${it.exception}")
                        }
                    }
                }
            }
        }
    }
}