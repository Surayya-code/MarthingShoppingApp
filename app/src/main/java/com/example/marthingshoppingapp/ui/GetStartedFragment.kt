package com.example.marthingshoppingapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.marthingshoppingapp.R
import com.example.marthingshoppingapp.databinding.FragmentGetStartedBinding
import com.google.android.material.snackbar.Snackbar


class GetStartedFragment : Fragment() {
  private var _binding: FragmentGetStartedBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentGetStartedBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnStarted.setOnClickListener() {
        findNavController().navigate( GetStartedFragmentDirections.actionGetStartedFragmentToSignUpFragment())
       }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}