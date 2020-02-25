package com.example.androidempty

import androidx.fragment.app.*

class BrowserPageAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

	private val fragments = listOf(BrowserMQTTFragment(), BrowserBLEFragment(), BrowserDemoFragment())

	override fun getItem(position: Int): Fragment {
		return this.fragments[position]
	}

	override fun getCount(): Int {
		return 3
	}
}