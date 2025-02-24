package com.example.context_menu

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val listView = findViewById<ListView>(R.id.listview)

        val itemArray = arrayOf("item 1", "item 2", "item 3", "item 4")


        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemArray)
        listView.adapter = adapter


        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menu!!.setHeaderTitle("select below item")

        menu.add(0, v!!.id, 0, "sub item 1")
        menu.add(0, v!!.id, 0, "sub item 2")
        menu.add(0, v!!.id, 0, "sub item 3")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        if (item!!.title == "sub item 1") {
            Toast.makeText(this@MainActivity, "sub item 1 is clicked", Toast.LENGTH_SHORT).show()
        } else if (item!!.title == "sub item 2") {
            Toast.makeText(this@MainActivity, "sub item 2 is clicked", Toast.LENGTH_SHORT).show()
        } else if (item!!.title == "sub item 3") {
            Toast.makeText(this@MainActivity, "sub item 1 is clicked", Toast.LENGTH_SHORT).show()
        }
        return super.onContextItemSelected(item)
    }
}