package com.example.marthingshoppingapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marthingshoppingapp.databinding.CategoryItemsBinding

//class ProductAdapter:RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

//    private val categoryList= arrayListOf<ProductResponse>()
//inner class ProductViewHolder(private val itemsCategoryBinding: CategoryItemsBinding):RecyclerView.ViewHolder(itemsCategoryBinding.root){
//
//    fun bind(productResponse: ProductResponse){
//        itemsCategoryBinding.cardCategory=productResponse.category
//    }
//}
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
//      val layout=CategoryItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//        return ProductViewHolder(layout)
//    }
//
//    override fun getItemCount(): Int {
//        return  categoryList.size
//    }
//
//    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
//        holder.bind(categoryList[position])
//    }
//
//    fun updateList(newList:List<ProductResponse>){
//        categoryList.clear()
//        categoryList.addAll(newList)
//        notifyDataSetChanged()
//    }
//}