package com.example.panderma.presentation.home.list.detail

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
import com.example.panderma.databinding.FragmentListDetailsBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListDetailsFragment : Fragment() {

    private val viewModel: ListDetailsViewModel by viewModel()

    private var _binding: FragmentListDetailsBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.donorDetailsResultState.collect {
                    when (it) {
                        is ResultState.Idle -> {
                        }
                        is ResultState.ShowLoading -> {
                            Log.d("collectDonor", "Show Loading")
                        }
                        is ResultState.Success -> {
                            Log.d("collectDonor", it.data.donorDetails.toString())
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
        viewModel.getDonorDetailsBy(1)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}