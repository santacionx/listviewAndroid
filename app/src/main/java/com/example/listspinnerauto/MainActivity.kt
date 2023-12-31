package com.example.listspinnerauto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.listView)

        // Sample data for the list
        val existingData = arrayOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
        val additionalData = (6..105).map { "Item $it" } // Generate new items from 6 to 105

        val combinedData = existingData + additionalData // Combine existing and additional data

        // Adapter to populate data into the ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, combinedData)

        // Set the adapter to the ListView
        listView.adapter = adapter

        // Set item click listener
        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position).toString()
            Toast.makeText(this, "Clicked: $selectedItem", Toast.LENGTH_SHORT).show()
            // Add any other action you want to perform on item click
        }
    }
}