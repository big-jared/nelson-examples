package com.example.androidempty

import android.os.*
import android.view.*
import androidx.fragment.app.*

// I was lazy and put these all in the same file they should be broken out into their own files

class LoginKnownFragment : Fragment() {

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.fragment_known, container, false)
	}
}


class LoginNearbyFragment : Fragment() {

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.fragment_nearby, container, false)
	}
}

class LoginDemoFragment : Fragment() {

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.fragment_demo, container, false)
	}
}