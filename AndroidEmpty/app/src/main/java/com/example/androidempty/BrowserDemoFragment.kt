package com.example.androidempty

import android.os.*
import android.view.*
import androidx.fragment.app.Fragment


class BrowserDemoFragment : Fragment() {
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.fragment_browser_demo, container, false)
	}
}
