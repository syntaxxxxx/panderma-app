package com.example.panderma.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.panderma.core.ResultState
import com.example.panderma.databinding.FragmentHomeBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                collectBanner()
                collectCategory()
                collectDonor()
            }
        }
    }

    private suspend fun collectBanner() {
        viewLifecycleOwner.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.bannerResultState.collect {
                    when (it) {
                        is ResultState.Idle -> {
                        }
                        is ResultState.ShowLoading -> {
                            Log.d("collectBanner", "Show Loading")
                        }
                        is ResultState.Success -> {
                            Log.d("collectBanner", it.data.banner.toString())
                        }
                        is ResultState.Error -> {
                            Log.d("collectBanner", it.throwable.toString())
                        }
                        is ResultState.HideLoading -> {
                            Log.d("collectBanner", "Hide Loading")
                        }
                    }
                }
            }
        }
    }

    private fun collectCategory() {
        viewLifecycleOwner.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.categoryResultState.collect {
                    when (it) {
                        is ResultState.Idle -> {
                        }
                        is ResultState.ShowLoading -> {
                            Log.d("collectCategory", "Show Loading")
                        }
                        is ResultState.Success -> {
                            Log.d("collectCategory", it.data.category.toString())
                        }
                        is ResultState.Error -> {
                            Log.d("collectCategory", it.throwable.toString())
                        }
                        is ResultState.HideLoading -> {
                            Log.d("collectCategory", "Hide Loading")
                        }
                    }
                }
            }
        }
    }

    private fun collectDonor() {
        viewLifecycleOwner.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.donorResultState.collect {
                    when (it) {
                        is ResultState.Idle -> {
                        }
                        is ResultState.ShowLoading -> {
                            Log.d("collectDonor", "Show Loading")
                        }
                        is ResultState.Success -> {
                            Log.d("collectDonor", it.data.donor.toString())
                        }
                        is ResultState.Error -> {
                            Log.d("collectDonor", it.throwable.toString())
                        }
                        is ResultState.HideLoading -> {
                            Log.d("collectDonor", "Hide Loading")
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}