package com.example.androidempty

import android.os.*
import android.view.*
import androidx.annotation.*
import androidx.appcompat.app.*
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.*
import com.google.android.material.bottomnavigation.*
import kotlinx.android.synthetic.main.activity_browser.*

class BrowserActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

	private lateinit var mainPagerAdapter: MainPagerAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_browser)

		mainPagerAdapter = MainPagerAdapter(supportFragmentManager)

		// Set items to be displayed.
		mainPagerAdapter.setItems(arrayListOf(MainScreen.KNOWN, MainScreen.NEARBY, MainScreen.DEMO))

		// Show the default screen.
		val defaultScreen = MainScreen.KNOWN
		showScreen(defaultScreen)
		selectBottomNavigationViewMenuItem(defaultScreen.menuItemId)

		// Set the listener for item selection in the bottom navigation view.
		bottomNavigation.setOnNavigationItemSelectedListener(this)

		// Attach an adapter to the view pager and make it select the bottom navigation
		// menu item and change the title to proper values when selected.
		viewPager.adapter = mainPagerAdapter
		viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
			override fun onPageSelected(position: Int) {
				val selectedScreen = mainPagerAdapter.getItems()[position]
				selectBottomNavigationViewMenuItem(selectedScreen.menuItemId)
			}
		})
	}

	/**
	 * Scrolls `ViewPager` to show the provided screen.
	 */
	private fun showScreen(mainScreen: MainScreen) {
		val screenPosition = mainPagerAdapter.getItems().indexOf(mainScreen)
		if (screenPosition != viewPager.currentItem) {
			viewPager.currentItem = screenPosition
		}
	}

	/**
	 * Selects the specified item in the bottom navigation view.
	 */
	private fun selectBottomNavigationViewMenuItem(@IdRes menuItemId: Int) {
		bottomNavigation.selectedItemId = menuItemId
	}

	override fun onNavigationItemSelected(item: MenuItem): Boolean {
		getMainScreenForMenuItem(item.itemId)?.let {
			showScreen(it)
			return true
		}
		return false
	}
}

enum class MainScreen(@IdRes val menuItemId: Int, val fragment: Fragment) {
	KNOWN(R.id.navigationKnown, LoginKnownFragment()),
	NEARBY(R.id.navigationNearby, LoginNearbyFragment()),
	DEMO(R.id.navigationDemo, LoginDemoFragment())
}

fun getMainScreenForMenuItem(menuItemId: Int): MainScreen? {
	for (mainScreen in MainScreen.values()) {
		if (mainScreen.menuItemId == menuItemId) {
			return mainScreen
		}
	}
	return null
}
