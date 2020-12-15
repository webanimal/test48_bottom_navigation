package ru.webanimal.test48_bottom_navigation.features

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import ru.webanimal.test48_bottom_navigation.R
import ru.webanimal.test48_bottom_navigation.data.api.MoviesHttpClient
import ru.webanimal.test48_bottom_navigation.data.models.Movie

class MoviesListFragment : Fragment() {
    
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        val isActive = coroutineScope.isActive
        Log.e(TAG, "ExceptionHandler [Scope active:$isActive, throwable:$throwable]")
        context?.let {
            Toast.makeText(it, "Load movies error", Toast.LENGTH_LONG).show()
        }
        coroutineScope = createCoroutineScope()
    }
    private var coroutineScope = createCoroutineScope()
    
    private var recycler: RecyclerView? = null
    private lateinit var httpClient: MoviesHttpClient
    private var movies: List<Movie> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews(view)

        httpClient = MoviesHttpClient()
        updateData()
    }

    override fun onDetach() {
        coroutineScope.cancel("It's time")
        recycler = null

        super.onDetach()
    }
    
    private fun updateData() {
        coroutineScope.launch(coroutineExceptionHandler) {
            movies = httpClient.getMoviesAsync()
            updateAdapter(movies)
        }
    }
    
    private fun updateAdapter(movies: List<Movie>) {
        (recycler?.adapter as? MoviesAdapter)?.updateAdapter(movies)
    }

    private fun setupViews(parent: View) {
        recycler = parent.findViewById<RecyclerView>(R.id.rvMovies).apply {
            adapter = MoviesAdapter()
        }
    }
    
    private fun createCoroutineScope() = CoroutineScope(Job() + Dispatchers.Main)

    companion object {
        private val TAG = MoviesListFragment::class.java.simpleName
        
        fun create() = MoviesListFragment()
    }
}