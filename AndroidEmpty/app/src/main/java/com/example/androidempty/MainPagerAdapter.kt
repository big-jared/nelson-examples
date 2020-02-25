package com.example.androidempty

import androidx.fragment.app.*

class MainPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

	private val screens = arrayListOf<MainScreen>()

	fun setItems(screens: List<MainScreen>) {
		this.screens.apply {
			clear()
			addAll(screens)
			notifyDataSetChanged()
		}
	}

	fun getItems(): List<MainScreen> {
		return screens
	}

	override fun getItem(position: Int): Fragment {
		return screens[position].fragment
	}

	override fun getCount(): Int {
		return screens.size
	}
}