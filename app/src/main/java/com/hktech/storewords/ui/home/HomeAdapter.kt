package com.hktech.storewords.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hktech.storewords.R
import com.hktech.storewords.data.db.entity.Word
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.hktech.storewords.BR

class HomeAdapter :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var items = emptyList<Word>()

    fun setData(items: List<Word>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(
                layoutInflater,
                R.layout.recyclerview_item,
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            val item = items[position]
            holder.bind(item)
        }
    }

    class ViewHolder(
        private val binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Word) {
            binding.setVariable(BR.word, item)
            binding.executePendingBindings()
        }
    }

    class DetailClickListener(val clickListener: (user: Word) -> Unit) {
        fun onClick(user: Word) {
            clickListener(user)
        }
    }
}
