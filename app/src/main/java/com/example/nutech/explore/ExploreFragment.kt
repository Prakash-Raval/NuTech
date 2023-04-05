package com.example.nutech.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils.loadAnimation
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.nutech.R
import com.example.nutech.databinding.FragmentExploreBinding
import com.example.nutech.extension.startAnimation


class ExploreFragment : Fragment() {
    private lateinit var binding: FragmentExploreBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.fragment_explore,
            container,
            false
        )
        setAnimation()
        return binding.root
    }

    private fun setAnimation() {
        binding.txtFilter.setOnClickListener {
            val extras = FragmentNavigatorExtras(binding.txtFilter to "textview")
            val action = R.id.action_explore_to_filterLocationFragment
            findNavController().navigate(action, null, null, extras)
        }


        binding.btnSearch.setOnClickListener {
            binding.btnSearch.isVisible = false
            binding.viewCircle.isVisible = true
            val animation =
                loadAnimation(requireContext(), R.anim.circle_explosion_animation).apply {
                    duration = 700
                    interpolator = AccelerateDecelerateInterpolator()
                }
            binding.viewCircle.startAnimation(animation) {
                binding.root.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.black
                    )
                )
                binding.viewCircle.isVisible = false

            }
            findNavController().navigate(R.id.action_explore_to_searchFragment)

        }
    }
}