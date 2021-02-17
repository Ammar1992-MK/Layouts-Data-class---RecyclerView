package no.kristiania.recyclerviewtraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import no.kristiania.recyclerviewtraining.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val exampleList = generateDummyList(500)

        binding.recyclerView.adapter = ExampleAdapter(exampleList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)

    }

    private fun generateDummyList(size : Int) : List<ExampleItem>{

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