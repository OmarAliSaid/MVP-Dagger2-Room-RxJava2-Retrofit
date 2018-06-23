package com.omar.mvp.ui.MainActivity;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class MovieListModule {

    @Provides
    MovieListAdapter provideMovieListAdapter(){
        return new MovieListAdapter(new ArrayList<>());
    }


    @Provides
    MovieListMvpPresenter<MovieListMvpView> provideMainPresenter(
            MovieListPresenter<MovieListMvpView> presenter) {
        return presenter;
    }
}
