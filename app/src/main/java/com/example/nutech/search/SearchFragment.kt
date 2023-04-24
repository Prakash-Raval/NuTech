package com.example.nutech.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nutech.R
import com.example.nutech.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    /*
    * varibles
    * */

    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.fragment_search,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolBar()
    }

    /*
    * setting up toolbar
    * */
    private fun setToolBar(){
        binding.inToolbar.btnBackToExplore.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}