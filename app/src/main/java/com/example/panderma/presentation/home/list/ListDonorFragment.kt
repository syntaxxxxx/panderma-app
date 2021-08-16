package com.example.panderma.presentation.home.list

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
import com.example.panderma.databinding.FragmentListDonorBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListDonorFragment : Fragment() {

    private val viewModel: ListDonorViewModel by viewModel()

    private var _binding: FragmentListDonorBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListDonorBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        collectDonor()
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