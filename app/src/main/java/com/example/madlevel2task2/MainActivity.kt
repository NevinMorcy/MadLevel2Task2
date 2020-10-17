package com.example.madlevel2task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel2task2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    private val list= arrayListOf<DataSource>()

    //Add a field in MainActivity that will hold a reference to your adapter
    private val Quizadapter = MainAdapter(list)
    //the binding object
    // bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically.
    //init your layout in the activity
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {

        //opmaak hier te fixen
        binding.recyclerview.layoutManager =
            LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        binding.recyclerview.adapter = Quizadapter

        binding.recyclerview.addItemDecoration(
            DividerItemDecoration(
                this@MainActivity,
                DividerItemDecoration.VERTICAL
            )
        )

        // Populate the data list
        for (i in DataSource.items.indices) {
            list.add(DataSource.items[i])
        }

        //notify the data set has changed.
        createItemTouchHelper().attachToRecyclerView(recyclerview)
    }


    private fun createItemTouchHelper(): ItemTouchHelper {
        //we use itemtouchhelpercallback to swipe
        //0 : we do not want to move the items in the list up and down or reorderd
        val itemTouchHelperCallback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            //we do not want to drag any object, so false
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }


            //voor het swipen naar links en rechts
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, position: Int) {
                if (position == ItemTouchHelper.LEFT && list[position].boolean == false) {
                    list.removeAt(position)
                } else {
                    Snackbar.make(
                        recyclerview,
                        getString(R.string.incorrect),
                        Snackbar.LENGTH_SHORT
                    )
                        .show()
                }

                if (position == ItemTouchHelper.RIGHT && list[position].boolean == true) {
                    list.removeAt(position)
                } else {
                    Snackbar.make(
                        recyclerview,
                        getString(R.string.incorrect),
                        Snackbar.LENGTH_SHORT
                    )
                        .show()
                }

            }

        }
        return ItemTouchHelper(itemTouchHelperCallback)


    }

}


