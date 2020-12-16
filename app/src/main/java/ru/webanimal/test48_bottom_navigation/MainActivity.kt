package ru.webanimal.test48_bottom_navigation

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.animation.AnimationUtils
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.webanimal.test48_bottom_navigation.features.more.MoreFragment
import ru.webanimal.test48_bottom_navigation.features.moviedetails.MovieDetailsFragment
import ru.webanimal.test48_bottom_navigation.features.movieslist.MoviesListFragment

class MainActivity : AppCompatActivity(),
	BottomNavigationView.OnNavigationItemSelectedListener,
	MoviesListFragment.MovieClickListener,
	MovieDetailsFragment.BackClickListener {
	
	lateinit var navigationView: BottomNavigationView
	
	private val currentFragment: Fragment?
		get() = supportFragmentManager.findFragmentById(R.id.container)
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		
		setupViews()
		
		if (savedInstanceState == null) {
			routeToMoviesList()
		}
	}
	
	override fun onBackPressed() {
		if (currentFragment !is MoviesListFragment) {
			Toast.makeText(this.applicationContext, "Movies checked", Toast.LENGTH_SHORT)
				.show()
			routeToMoviesList()
			
		} else {
			super.onBackPressed()
		}
	}
	
	override fun onNavigationItemSelected(item: MenuItem): Boolean {
		when (item.itemId) {
			R.id.menu_item_movies_list -> {
				if (currentFragment !is MoviesListFragment) {
					Toast.makeText(this.applicationContext, "Movies checked", Toast.LENGTH_SHORT)
						.show()
					routeToMoviesList()
				}
			}
			R.id.menu_item_more -> {
				if (currentFragment !is MoreFragment) {
					Toast.makeText(this.applicationContext, "More checked", Toast.LENGTH_SHORT)
						.show()
					routeToMore()
				}
			}
		}
		
		// CLick event is handled here.
		return true
	}
	
	override fun onMovieSelected(id: Int) {
		routeToMovieDetails(id)
	}
	
	override fun onBackClicked() {
		routeToMoviesList()
	}
	
	private fun routeToMoviesList() {
		updateNavViewState(NavigationViewStates.MOVIES_LIST)
		supportFragmentManager.beginTransaction()
			.replace(R.id.container, MoviesListFragment.create())
			.commit()
	}
	
	private fun routeToMore() {
		updateNavViewState(NavigationViewStates.MORE)
		supportFragmentManager.beginTransaction()
			.replace(R.id.container, MoreFragment.create())
			.commit()
	}
	
	private fun routeToMovieDetails(id: Int) {
		updateNavViewState(NavigationViewStates.HIDDEN)
		supportFragmentManager.beginTransaction()
			.add(R.id.container, MovieDetailsFragment.create(id))
			.addToBackStack(null)
			.commit()
	}
	
	private fun setupViews() {
		navigationView = findViewById(R.id.bottomNavigation)
		navigationView.setOnNavigationItemSelectedListener(this)
	}
	
	private fun updateNavViewState(navViewState: NavigationViewStates) {
		when (navViewState) {
			NavigationViewStates.MOVIES_LIST -> {
				setBadge(R.id.menu_item_movies_list, setVisible = true, counter = 33)
				setBadge(R.id.menu_item_more, setVisible = true, counter = 0)
				navigationView.menu.findItem(R.id.menu_item_movies_list)?.isChecked = true
				showNavView()
			}
			NavigationViewStates.MORE -> {
				setBadge(R.id.menu_item_more, setVisible = true, counter = 1100)
				setBadge(R.id.menu_item_movies_list, setVisible = true, counter = 0)
				navigationView.menu.findItem(R.id.menu_item_more)?.isChecked = true
				showNavView()
			}
			NavigationViewStates.HIDDEN -> {
				hideNavView()
			}
		}
	}
	
	private fun setBadge(menuItemId: Int, setVisible: Boolean, counter: Int) {
		var badge = navigationView.getOrCreateBadge(menuItemId)
		badge.isVisible = setVisible
		if (counter > 0) {
			badge.number = counter
			
		} else {
			badge.clearNumber()
		}
	}
	
	private fun removeBadge(menuItemId: Int) {
		navigationView.removeBadge(menuItemId)
	}
	
	private fun showNavView() {
		navigationView.apply {
			if (!isEnabled) {
				isEnabled = true
				clearAnimation()
				animate()?.translationY(0f)
					?.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR)
					?.duration = 200
			}
			visibility = View.VISIBLE
		}
	}
	
	private fun hideNavView() {
		navigationView.apply {
			if (isEnabled) {
				isEnabled = false
				clearAnimation()
				animate()?.translationY(56f)
					?.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR)
					?.duration = 200
			}
			visibility = View.INVISIBLE
		}
	}
}