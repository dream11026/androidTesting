package com.yungchi.testing.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * 客製資料 bingding Spinner Adapter
 */
abstract class BaseSpinAdapter<Data, DB : ViewDataBinding>(
    context: Context,
    private var data: List<Data> = emptyList(),
    private val eventMap: Map<Int, Any> = emptyMap(), //事件集合
    @LayoutRes private val itemId: Int = 0,//Layout ID
    private val variableId: Int = 0
) //data ID
    : BaseAdapter() {

    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    inner class BaseSpinViewHolder<Data, DB : ViewDataBinding>(private val viewDataBinding: DB) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        fun bind(execResult: Data) {
            //事件
            eventMap.forEach { (int, action) ->
                viewDataBinding.setVariable(int, action)
            }

            viewDataBinding.setVariable(variableId, execResult)//資料
            viewDataBinding.executePendingBindings()//立即綁訂
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val holder: BaseSpinViewHolder<Data, DB>
        val view: View
        val data: Data = data[position]
        val binding: DB

        if (convertView == null) {
            binding = DataBindingUtil.inflate(mInflater, itemId, parent, false)
            onBindItem(data, binding, position)
            holder = BaseSpinViewHolder(binding)
            view = binding.root
            view.tag = holder
        } else {
            view = convertView
            binding = DataBindingUtil.getBinding(view)!!
            onBindItem(data, binding, position)
            holder = view.tag as BaseSpinViewHolder<Data, DB>
        }
        holder.bind(data)
        return view
    }

    override fun getCount(): Int = data.size

    override fun getItem(position: Int): Data {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun updateData(data: List<Data>) {
        this.data = data
        notifyDataSetChanged()
    }

    /**
     * bind item
     */
    protected open fun onBindItem(detail: Data, binding: DB, position: Int) {}
}