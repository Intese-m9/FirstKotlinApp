package com.example.newsapplication.uifragments.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsapplication.R
import com.example.newsapplication.databinding.FragmentFavoriteBinding

class SplashFragment : Fragment() {



    private var _binding: FragmentFavoriteBinding? = null
    private val mBinding get () = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteBinding.inflate(layoutInflater,container,false)
        return mBinding.root
    }
}