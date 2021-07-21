package com.example.movieapplicationdemo.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapplicationdemo.databinding.FragmentMovieBinding
import com.example.movieapplicationdemo.model.Movie
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MovieFragment : Fragment(), MovieContract.MovieView {

    @Inject
    lateinit var presenter: MoviePresenter

    lateinit var binding: FragmentMovieBinding

    fun newInstance(): MovieFragment {
        return MovieFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        attachAndroidSupportInjection()
    }

    private fun attachAndroidSupportInjection() {
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMovieBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        presenter.loadMovies()
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    override fun showErrorMessage(error: String) {
        Log.e("MovieFragment", "Error- $error")
    }

    override fun loadDataSuccess(movieList: List<Movie>) {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.setHasFixedSize(true)
        val movieAdapter = MovieAdapter(movieList.toMutableList(), this)
        binding.recyclerView.adapter = movieAdapter
        movieAdapter.notifyDataSetChanged()
    }

    companion object {
        val TAG: String = MovieFragment::class.java.simpleName
    }

}