package com.example.randommenupicker.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.randommenupicker.databinding.FragmentMenuDetailBinding

class MenuDetailFragment : Fragment() {
    private lateinit var binding : FragmentMenuDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuDetailBinding.inflate(inflater, container, false);
        return binding.root
    }


    companion object {
        fun newInstance() : MenuDetailFragment{
            var fragment : MenuDetailFragment = MenuDetailFragment()
            return fragment
        }
    }


}