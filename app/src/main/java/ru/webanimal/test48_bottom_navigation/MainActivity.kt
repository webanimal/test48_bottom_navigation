package ru.webanimal.test48_bottom_navigation

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.webanimal.test48_bottom_navigation.features.MoviesListFragment

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

	lateinit var navigationView: BottomNavigationView
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		setupViews()

		if (savedInstanceState == null) {
			routeToMoviesList()
		}
	}

	private fun setupViews() {
		navigationView = findViewById(R.id.bottomNavigation)
		navigationView.setOnNavigationItemSelectedListener(this)
	}

	private fun routeToMoviesList() {
		supportFragmentManager.beginTransaction()
			.replace(R.id.container, MoviesListFragment.create())
			.commit()
	}

	override fun onNavigationItemSelected(item: MenuItem): Boolean {
		when (item.itemId) {
			R.id.menu_item_movies_list -> {
				Toast.makeText(this.applicationContext, "Movies checked", Toast.LENGTH_SHORT).show()
			}
			R.id.menu_item_more -> {
				Toast.makeText(this.applicationContext, "More checked", Toast.LENGTH_SHORT).show()
			}
		}

		return true
	}
}