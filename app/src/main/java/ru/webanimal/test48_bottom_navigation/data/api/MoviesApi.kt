package ru.webanimal.test48_bottom_navigation.data.api

import ru.webanimal.test48_bottom_navigation.data.models.Movie

interface MoviesApi {
    suspend fun getMoviesAsync(): List<Movie>
}