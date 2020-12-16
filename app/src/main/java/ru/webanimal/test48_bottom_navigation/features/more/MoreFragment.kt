package ru.webanimal.test48_bottom_navigation.features.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.webanimal.test48_bottom_navigation.R

class MoreFragment : Fragment() {
	
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.fragment_more, container, false)
	}
	
	companion object {
		private val TAG = MoreFragment::class.java.simpleName
		
		fun create() = MoreFragment()
	}
}