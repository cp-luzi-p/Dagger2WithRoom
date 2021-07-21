package com.example.movieapplicationdemo.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapplicationdemo.databinding.ListItemMoviesBinding
import com.example.movieapplicationdemo.model.Movie

class MovieAdapter ( private val movieList: MutableList<Movie>, fragment: Fragment
): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

   lateinit var binding: ListItemMoviesBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        binding = ListItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val itemList = movieList[position]
        binding.movieTitle.text = itemList.getTitle()
        binding.ratingMovie.text = movieList[position].getRating()
        binding.releaseYear.text = movieList[position].getReleaseYear().toString()

        Glide.with(holder.itemView.context)
            .load(movieList[position].getImage())
            .centerCrop()
            .into(binding.movieImage)


       //binding.genreMovie.text = movieList[position].getGenre().toString()
    }

    override fun getItemCount(): Int {
      return movieList.size
    }
    class MovieViewHolder(private val binding: ListItemMoviesBinding) : RecyclerView.ViewHolder(binding.root)
}