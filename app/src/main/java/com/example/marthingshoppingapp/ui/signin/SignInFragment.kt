package com.example.marthingshoppingapp.ui.signin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.marthingshoppingapp.databinding.FragmentSignInBinding
import com.example.marthingshoppingapp.model.fakeStoreProduct.TokenResponse
import com.example.marthingshoppingapp.service.ApiUtil
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInFragment : Fragment() {
   private var _binding:FragmentSignInBinding?=null
    private val binding get()=_binding!!
    private val service=ApiUtil.getService()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding= FragmentSignInBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSignIN.setOnClickListener(){
            setup()
            val username = binding.usernameTextInput.text.toString()
            val password = binding.textPasswordInput.text.toString()
            if(username.isEmpty() && password.isEmpty()){
                Snackbar.make(it,"Email bos ola bilmez!", Snackbar.LENGTH_LONG).show()
                Snackbar.make(it,"Ad bos ola bilmez!", Snackbar.LENGTH_LONG).show()
            }else{
                findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToHomeFragment())
            }
        }
    }

    private fun setup(){
      binding.btnSignIN.setOnClickListener{
          login()
      }
    }

    private fun login(){
        val username = binding.usernameTextInput.text.toString()
        val password = binding.textPasswordInput.text.toString()

      service.userLogin(username,password).enqueue(object : Callback<TokenResponse> {
          override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
              Toast.makeText(requireContext(),"username and password incorrect",Toast.LENGTH_LONG).show()
          }


          //mor_2314
          //83r5^_mor_

          override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
              Toast.makeText(requireContext(),t.localizedMessage,Toast.LENGTH_LONG).show()
          }

      })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}