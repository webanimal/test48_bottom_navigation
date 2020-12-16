package ru.webanimal.test48_bottom_navigation.features.moviedetails

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.webanimal.test48_bottom_navigation.R

class MovieDetailsFragment : Fragment() {
	
	private var backClickListener: BackClickListener? = null
	
	override fun onAttach(context: Context) {
		super.onAttach(context)
		
		if (context is BackClickListener) {
			backClickListener = context
		}
	}
	
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		val view = inflater.inflate(R.layout.fragment_movie_details, container, false)
		view.findViewById<View>(R.id.layMovieDetailsBack)?.setOnClickListener { backClickListener?.onBackClicked() }
		return view
	}
	
	override fun onDetach() {
		backClickListener = null
		
		super.onDetach()
	}
	
	interface BackClickListener {
		fun onBackClicked()
	}
	
	companion object {
		private val TAG = MovieDetailsFragment::class.java.simpleName
		
		// "id" not implemented
		fun create(id: Int) = MovieDetailsFragment()
	}
}