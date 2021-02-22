package no.kristiania.recyclerviewtraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import no.kristiania.recyclerviewtraining.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity(), ExampleAdapter.OnItemClickListener {

    private val exampleList = generateDummyList(500)
    private val adapter = ExampleAdapter(exampleList, this)

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)



        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)

    }

    fun insertItem (view : View){

        val index = Random.nextInt(8)

        val newItem = ExampleItem(
                R.drawable.ic_bedtime,
                text1 = "new item",
                text2 = "Line 2"
        )

        exampleList.add(index, newItem)

        adapter.notifyItemInserted(index);
    }

    fun removeItem (view : View){

        val index = Random.nextInt(8)

        exampleList.removeAt(index)

        adapter.notifyItemRemoved(index)

    }

    override fun onItemClick(position: Int) {

        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem : ExampleItem = exampleList[position]
        clickedItem.text1 = "Clicked"
        adapter.notifyItemChanged(position)
    }

    private fun generateDummyList(size : Int) : ArrayList<ExampleItem>{

        val list = ArrayList<ExampleItem>()

        for(i in 0 until size) {

            var drawable = when ( i % 3) {

                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_bedtime
                else -> R.drawable.ic_check_box
            }

            val item = ExampleItem(drawable,"Item $i", "Line2")

            list += item
        }

        return  list
    }
}