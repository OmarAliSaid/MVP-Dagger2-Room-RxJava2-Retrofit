package com.omar.mvp.ui.MainActivity;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.omar.mvp.R;
import com.omar.mvp.data.model.Movie;
import com.omar.mvp.databinding.CardMovieItemBinding;
import java.util.ArrayList;


public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {

    LayoutInflater layoutInflater;
    public ArrayList<Movie> movies;

    public MovieListAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        CardMovieItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.card_movie_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        viewHolder.binding.setMovie(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CardMovieItemBinding binding;

        public ViewHolder(CardMovieItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void addItems(ArrayList<Movie>movies){
        this.movies.clear();
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }
}
