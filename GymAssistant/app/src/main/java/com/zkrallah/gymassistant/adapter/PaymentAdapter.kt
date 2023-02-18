package com.zkrallah.gymassistant.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zkrallah.gymassistant.R
import com.zkrallah.gymassistant.local.entities.Payment

class PaymentAdapter(private val list: MutableList<Payment>) : RecyclerView.Adapter<PaymentAdapter.ViewHolder>() {

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {

        fun onDeleteClicker(payment: Payment, position: Int)

    }

    fun setItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.payment_item, parent, false), mListener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTV.text = list[position].userName
        holder.dateTV.text = "PAYED IN: ${list[position].paymentDate}"
        holder.idTV.text = "ID : ${list[position].userId}"
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun removeItem(position: Int){
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    inner class ViewHolder(itemView: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        val nameTV: TextView = itemView.findViewById(R.id.name)
        val dateTV: TextView = itemView.findViewById(R.id.date)
        val idTV: TextView = itemView.findViewById(R.id.id)
        private val deleteBtn: ImageButton = itemView.findViewById(R.id.delete)

        init {
            deleteBtn.setOnClickListener {
                listener.onDeleteClicker(list[adapterPosition], adapterPosition)
            }
        }
    }
}