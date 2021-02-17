package no.kristiania.recyclerviewtraining

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ExampleAdapter : RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_item,
        parent, false)

        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

    }

    inner class ExampleViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val imageView : ImageView = itemView.findViewById(R.id.image_view)
        val textView1 : TextView = itemView.findViewById(R.id.text_view_1)
        val textView2 : TextView = itemView.findViewById(R.id.text_view_2)

    }


}