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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.panderma.core.ResultState
import com.example.panderma.databinding.FragmentHomeBinding
import com.mikepenz.fastadapter.adapters.GenericFastItemAdapter
import com.mikepenz.fastadapter.adapters.GenericItemAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val itemAdapter by lazy { GenericItemAdapter() }
    private val fastAdapter by lazy { GenericFastItemAdapter() }

    private val itemAdapter2 by lazy { GenericItemAdapter() }
    private val fastAdapter2 by lazy { GenericFastItemAdapter() }

    private val itemAdapter3 by lazy { GenericItemAdapter() }
    private val fastAdapter3 by lazy { GenericFastItemAdapter() }

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

        binding?.bannerRecyclerview?.run {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = fastAdapter
        }

        fastAdapter.addAdapter(1, itemAdapter)

        binding?.run {
            categoryRecyclerView.run {
                layoutManager = GridLayoutManager(requireContext(), 2, LinearLayoutManager.HORIZONTAL, false)
                adapter = fastAdapter2
            }
        }

        fastAdapter2.addAdapter(1, itemAdapter2)

        binding?.run {
            donorRecyclerview.run {
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = fastAdapter3
            }
        }

        fastAdapter3.addAdapter(1, itemAdapter3)

        collectBanner()
        collectCategory()
        collectDonor()

    }

    private fun collectBanner() {
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
                            if (!it.data.banner.isNullOrEmpty()) {
                                if (fastAdapter.itemCount > 0) {
                                    fastAdapter.remove(fastAdapter.itemCount - 1)
                                }

                                it.data.banner.map { banner ->
                                    Log.d("testing", "${banner.image}")
                                    fastAdapter.add(BannerItem(banner))
                                }

                            } else if (fastAdapter.itemCount == 0) {
                                Log.d("test", "payah")
                            }
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

                            if (!it.data.category.isNullOrEmpty()) {
                                if (fastAdapter2.itemCount > 0) {
                                    fastAdapter2.remove(fastAdapter2.itemCount - 1)
                                }

                                it.data.category.map { category ->
                                    Log.d("testing", "${category.icon}")
                                    fastAdapter2.add(CategoryItem(category))
                                }

                            } else if (fastAdapter.itemCount == 0) {
                                Log.d("test", "payah")
                            }

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
                            Log.d("collectDonor", it.data.donor?.data.toString())
                            if (!it.data.donor?.data.isNullOrEmpty()) {
                                if (fastAdapter3.itemCount > 0) {
                                    fastAdapter3.remove(fastAdapter3.itemCount - 1)
                                }

                                it.data.donor?.data?.map { donor ->
                                    fastAdapter3.add(DonorItem(donor))
                                }

                            } else if (fastAdapter3.itemCount == 0) {
                                Log.d("test", "payah")
                            }
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

//fastAdapter.onClickListener = { _, _, item, _ ->
//    when (item) {
//        is ItemListFamily -> {
//            handleOnClickListener(isShowing, item.patient)
//        }
//        is  ItemFamilyMemberList -> {
//            handleOnClickListener(isShowing, item.patient)
//        }
//    }
//    true
//}