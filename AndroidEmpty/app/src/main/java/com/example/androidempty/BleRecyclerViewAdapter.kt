package com.example.androidempty

import android.view.*
import android.widget.*
import androidx.recyclerview.widget.*
import kotlinx.android.synthetic.main.ble_scan_row.view.*

class BleRecyclerViewAdapter : RecyclerView.Adapter<BleRecyclerViewAdapter.ViewHolder>() {

	val items = mutableListOf<String>()

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.ble_scan_row, parent, false))
	}

	override fun getItemCount() = items.size

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.bind(items[position])
	}

	class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

		fun bind(item: String) {
			view.bleScanRowButton.text = item
			view.bleScanRowButton.setOnClickListener {
				Toast.makeText(view.context, "Pressed $item", Toast.LENGTH_LONG).show()
			}
		}
	}
}