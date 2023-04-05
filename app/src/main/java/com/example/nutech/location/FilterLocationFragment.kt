package com.example.nutech.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.example.nutech.R
import com.example.nutech.databinding.FragmentFilterLocationBinding


class FilterLocationFragment : Fragment() {
    private lateinit var binding: FragmentFilterLocationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.fragment_filter_location,
            container,
            false
        )
        getAnimation()
        binding.inToolbar.btnBackToExplore.setOnClickListener {
            requireActivity().onBackPressed()
        }
        return binding.root
    }

    private fun getAnimation() {
        sharedElementEnterTransition =
            TransitionInflater.from(requireContext()).inflateTransition(R.transition.change_bounds)
        sharedElementReturnTransition =
            TransitionInflater.from(requireContext()).inflateTransition(R.transition.change_bounds)
    }

}