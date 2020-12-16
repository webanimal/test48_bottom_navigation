package ru.webanimal.test48_bottom_navigation.features.movieslist

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import ru.webanimal.test48_bottom_navigation.R
import ru.webanimal.test48_bottom_navigation.data.models.Movie

class MoviesAdapter(
	private val movieClickListener: MoviesListFragment.MovieClickListener?
) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
	
	private var moviesList: List<Movie> = mutableListOf()
	
	override fun getItemViewType(position: Int): Int {
		return when {
			moviesList.isNotEmpty() -> MOVIE_VIEW_HOLDER
			else -> EMPTY_VIEW_HOLDER
		}
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
		return when (viewType) {
			MOVIE_VIEW_HOLDER -> {
				MoviesHolder(
					LayoutInflater.from(parent.context).inflate(
						R.layout.item_movies_list,
						parent,
						false
					)
				)
			}
			EMPTY_VIEW_HOLDER -> EmptyHolder(
				LayoutInflater.from(parent.context).inflate(
					R.layout.item_movies_empty,
					parent,
					false
				)
			)
			else -> EmptyHolder(
				LayoutInflater.from(parent.context).inflate(
					R.layout.item_movies_empty,
					parent,
					false
				)
			)
		}
	}
	
	override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
		when (holder) {
			is MoviesHolder -> {
				holder.itemView.setOnClickListener {
					movieClickListener?.onMovieSelected(moviesList[position].hashCode())
				}
				holder.onBind(moviesList[position])
			}
			is EmptyHolder -> { /* nothing to bind */
			}
		}
	}
	
	override fun getItemCount(): Int {
		return moviesList.size
	}
	
	fun updateAdapter(newMovies: List<Movie>?) {
		if (newMovies == null) {
			return
		}
		
		moviesList = newMovies
		notifyDataSetChanged()
	}
	
	abstract class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
	private class EmptyHolder(itemView: View) : MoviesViewHolder(itemView)
	private class MoviesHolder(itemView: View) : MoviesViewHolder(itemView) {
		private val avatarImage: CircleImageView = itemView.findViewById(R.id.ivMoviesListAvatar)
		private val titleView: TextView = itemView.findViewById(R.id.tvMoviesListFilmTitle)
		private val overviewView: TextView = itemView.findViewById(R.id.tvMoviesListFilmOverview)
		
		fun onBind(movie: Movie) {
			Picasso.get().load(Uri.parse(movie.avatarUrl))
				.placeholder(R.drawable.ic_movie_download_placeholder)
				.into(avatarImage)
			
			titleView.text = movie.title
			overviewView.text = movie.overview
		}
	}
}

private const val MOVIE_VIEW_HOLDER = 0
private const val EMPTY_VIEW_HOLDER = 1