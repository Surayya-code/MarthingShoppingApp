package com.example.marthingshoppingapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marthingshoppingapp.databinding.CategoryItemsBinding
import com.example.marthingshoppingapp.databinding.ItemProductsBinding
import com.example.marthingshoppingapp.model.fakeStoreProduct.FProductResponse
import com.example.marthingshoppingapp.model.fakeStoreProduct.FProductResponseItem
import com.squareup.picasso.Picasso

class ProductAdapter:RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private val productList= arrayListOf<FProductResponseItem>()
inner class ProductViewHolder(private val itemsProductsBinding: ItemProductsBinding):RecyclerView.ViewHolder(itemsProductsBinding.root){
    fun bind(item: FProductResponseItem){
        itemsProductsBinding.productData=item
        Picasso.get().load(item.images[0]).into(itemsProductsBinding.imageProduct)
    }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
      val layout=ItemProductsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return  productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    fun updateList(newList:List<FProductResponseItem>){
        productList.clear()
        productList.addAll(newList)
        notifyDataSetChanged()
    }
}