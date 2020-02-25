package com.example.androidempty

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.*
import androidx.viewpager.widget.*
import kotlinx.android.synthetic.main.activity_browser.*


class BrowserNavigatorActivity : FragmentActivity(), ViewPager.OnPageChangeListener {
	var _selectedPage: Int = 2

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		this.setContentView(R.layout.activity_browser)

		this.browserPager.adapter = BrowserPageAdapter(this.supportFragmentManager)
		this.browserPager.addOnPageChangeListener(this)

		this.selectedPage = this.selectedPage
	}

	val selectionButtons:List <Button> get() = listOf(this.browserMQTTButton, this.browserBLEButton, this.browserDemoButton)

	var selectedPage: Int
		get() = this._selectedPage
		set(newValue) {
			this._selectedPage = newValue
			this.updateButtonLabels()
			this.browserPager.setCurrentItem(newValue, true)
		}

	fun selectKnown(whatever: View) {
		this.selectedPage = 0
	}

	fun selectNearby(whatever: View) {
		this.selectedPage = 1
	}

	fun selectDemo(whatever: View) {
		this.selectedPage = 2
	}

	fun updateButtonLabels() {
		this.selectionButtons.forEachIndexed { index, button ->
			button.textSize = if (index == this.selectedPage) {
				20.0f
			} else {
				17.0f
			}
			button.setTextColor(
				if (index == this.selectedPage) {
					this.getColor(R.color.tabsActiveLabel)
				} else {
					this.getColor(R.color.tabsInactiveLabel)
				}
			)
		}
	}

	override fun onPageScrollStateChanged(state: Int) {
		// pass
	}

	override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
		// pass
	}

	override fun onPageSelected(position: Int) {
		if (position != this.selectedPage) {
			this.selectedPage = position
		}
	}
}
