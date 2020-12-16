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
	MoviesListFragment.MovieClickListener,
	MovieDetailsFragment.BackClickListener {
	
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
	
	override fun onMovieSelected(id: Int) {
		routeToMovieDetails(id)
	}
	
	override fun onBackClicked() {
		routeToMoviesList()
	}
	
	private fun routeToMoviesList() {
		supportFragmentManager.beginTransaction()
			.replace(R.id.container, MoviesListFragment.create())
			.commit()
	}
	
	private fun routeToMore() {
		supportFragmentManager.beginTransaction()
			.replace(R.id.container, MoreFragment.create())
			.commit()
	}
	
	private fun routeToMovieDetails(id: Int) {
		supportFragmentManager.beginTransaction()
			.add(R.id.container, MovieDetailsFragment.create(id))
			.addToBackStack(null)
			.commit()
	}
	
	private fun setupViews() {

	}
}