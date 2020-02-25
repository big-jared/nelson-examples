package com.example.androidempty

import android.os.*
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.*
import kotlinx.android.synthetic.main.fragment_browser_ble.*
import kotlinx.android.synthetic.main.fragment_browser_ble.view.*


class BrowserBLEFragment : Fragment() {
	lateinit var contentView: View
	lateinit var adapter: BleRecyclerViewAdapter

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		contentView = inflater.inflate(R.layout.fragment_browser_ble, container, false)
		initUi()
		return contentView
	}

	fun initUi() {
		adapter = BleRecyclerViewAdapter()
		contentView.bleScanningRecyclerView.adapter = adapter
		contentView.bleScanningRecyclerView.layoutManager = LinearLayoutManager(context)

		addATwig()
	}

	fun addATwig(count: Int = 1) {
		Handler().postDelayed({
			adapter.items.add("Twig$count")
			adapter.notifyDataSetChanged()
			addATwig(count + 1)
		}, 1000)
	}
}
