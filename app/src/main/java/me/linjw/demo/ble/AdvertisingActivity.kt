package me.linjw.demo.ble

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.StringBuilder

class AdvertisingActivity : AppCompatActivity() {
    companion object {
        const val ADVERTISING = "advertising"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advertising)

        val items = ArrayList<String>()
        items.addAll(
            listOf(
                getString(R.string.len),
                getString(R.string.type),
                getString(R.string.data)
            )
        )

        val advertising = intent.getByteArrayExtra(ADVERTISING)!!
        var index = 0
        while (index < advertising.size) {
            val len = advertising[index]
            if (len == 0.toByte()) {
                break
            }

            val type = String.format("0x%02X", advertising[index + 1])
            val data = StringBuilder()
            for (i in 0 until len - 1) {
                data.append(String.format("0x%02X ", advertising[index + 2 + i]))
            }
            items.add(len.toString())
            items.add(type)
            items.add(data.toString())
            index += len + 1
        }

        findViewById<RecyclerView>(R.id.advertising).apply {
            adapter = Adapter(items)

            layoutManager =
                GridLayoutManager(this@AdvertisingActivity, 3, GridLayoutManager.VERTICAL, false)
        }
    }

    class Adapter(private val items: ArrayList<String>) : RecyclerView.Adapter<Holder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_advertising, parent, false)
            return Holder(view)
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.content.text = items[position]
        }

        override fun getItemCount(): Int {
            return items.size
        }

    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val content: TextView = itemView as TextView
    }
}