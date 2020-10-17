package com.example.madlevel2task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_question.view.*

//declare the data set that is going to be displayed in the list
// so its going to  be an arraylist with items (THIS IS THE LIST)
//what type of viewholder is going to be recycled in my list
class MainAdapter (private val items: List<DataSource>):
    RecyclerView.Adapter<MainAdapter.QuizViewHolder>() {



    // everytime you have a reclycerview, you need to build a custom view holder class that
    //describes what the views are goin g to be looking like in your recyclerview
    inner class QuizViewHolder constructor(
        //inside the constructor you want to take a single parameter
        //so its going to be a view object
        itemView: View
        //this is the recyler view holder that is passed in the adapter
        // So that a view holder class is created
        //So its passing the view as input to the constructor of the view holder
    ):  RecyclerView.ViewHolder(itemView){
        //Inside of this custom view holder,we can set all of the properties to that view
        // the values are the pointers to the items in the layout
        val itemName = itemView.item_name

        //the last thing that needs to be done for the adapter is to create a bind method
        // this is going to be responsible for taking each individual item_name object
        // binding the item_name objects to the views in the layout

        fun bind(datasource: DataSource) {
            itemName.setText(datasource.Data)
        }

    }


    //this will tell the recyler view or its for creating different view holders in the list
    //this is resposible for creating each individual view holder
    //needs to return a new view holder object
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
        return QuizViewHolder(v)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        //in most cases you have different view holders, but in this case we have on viewholder
        //when view holder is the type of quiz view holder then that means this is what i wanna display, the items
        when (holder) {
            is QuizViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {

        //this will tell the recyler view how many items are inside of your list
        return items.size
    }
}


