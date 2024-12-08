package com.example.task2
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.TextView
import android.widget.Button

import androidx.recyclerview.widget.RecyclerView
import com.example.task2.R


class MovieListActivity : AppCompatActivity() {

    private lateinit var movieRecyclerView: RecyclerView
    private lateinit var movieAdapter: MovieAdapter
    private val movieList = mutableListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        val username = intent.getStringExtra("username")
        findViewById<TextView>(R.id.welcomeTextView).text = "Welcome, $username"

        movieRecyclerView = findViewById(R.id.movieRecyclerView)
        movieRecyclerView.layoutManager = LinearLayoutManager(this)

        movieAdapter = MovieAdapter(movieList)
        movieRecyclerView.adapter = movieAdapter

        loadMovies(10)

        findViewById<Button>(R.id.moreButton).setOnClickListener {
            loadMovies(5)
        }
    }

    private fun loadMovies(count: Int) {
        val start = movieList.size + 1
        for (i in start until start + count) {
            movieList.add(Movie("Movie $i", "Description of Movie $i"))
        }
        movieAdapter.notifyItemRangeInserted(start - 1, count)
    }
}
