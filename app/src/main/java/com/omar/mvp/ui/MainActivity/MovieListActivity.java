package com.omar.mvp.ui.MainActivity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.omar.mvp.R;
import com.omar.mvp.data.model.Movie;
import com.omar.mvp.ui.Base.BaseActivity;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieListActivity extends BaseActivity implements MovieListMvpView {

    @BindView(R.id.activity_main_rv_movies) RecyclerView movies_recycler_view;

    @Inject
    MovieListMvpPresenter<MovieListMvpView> mainMvpPresenter;

    @Inject
    MovieListAdapter movieListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUnBinder(ButterKnife.bind(this));

        mainMvpPresenter.onAttach(this);

        setupMoviesRecyclerView();

        mainMvpPresenter.fetchMoviesSortedBy("popularity.desc");
    }


    private void setupMoviesRecyclerView() {
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this,2);
        movies_recycler_view.setLayoutManager(mLayoutManager);
        movies_recycler_view.setAdapter(movieListAdapter);
    }


    @Override
    public void onMoviesLoaded(ArrayList<Movie> movies) {
        if(movies!=null)
            movieListAdapter.addItems(movies);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        movieListAdapter = null;
    }
}
