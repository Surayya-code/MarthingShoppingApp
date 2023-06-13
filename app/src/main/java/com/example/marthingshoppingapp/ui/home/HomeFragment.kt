package com.example.marthingshoppingapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marthingshoppingapp.adapter.CategoriesAdapter
import com.example.marthingshoppingapp.databinding.FragmentHomeBinding
import com.example.marthingshoppingapp.model.fakeStoreProduct.CategoriesResponse
import com.example.marthingshoppingapp.service.ApiUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
  private var _binding:FragmentHomeBinding?=null
    private val binding get()=_binding!!
    private val service=ApiUtil.getProductService()
    private val categoriesAdapter=CategoriesAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       setup()
    }

    private fun setup(){
       setRV()
        service.getFakeCategories().enqueue(object : Callback<CategoriesResponse> {
            override fun onResponse(
                call: Call<CategoriesResponse>,
                response: Response<CategoriesResponse>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                        categoriesAdapter.updateList(it)
                    }
                }else{
                    Toast.makeText(requireContext(),"Error",Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<CategoriesResponse>, t: Throwable) {
                Toast.makeText(requireContext(),t.localizedMessage,Toast.LENGTH_LONG).show()
            }
        })
    }

  private fun setRV(){
  with(binding){
      rvCategories.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
      rvCategories.adapter=categoriesAdapter
  }
  }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}